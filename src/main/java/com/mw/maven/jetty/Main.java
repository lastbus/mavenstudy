package com.mw.maven.jetty;

import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerWrapper;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by Administrator on 2017/7/8.
 */


public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8082);

        ServletHolder servlet = new ServletHolder(ServletContainer.class);
        servlet.setInitParameter("com.sun.jersey.config.property.resourceConfigClass",
                "com.sun.jersey.api.core.PackagesResourceConfig");
        servlet.setInitParameter("com.sun.jersey.config.property.packages",
                "com.mw.maven.jetty;" );

        ServletHolder servlet2 = new ServletHolder(ServletContainer.class);
        servlet2.setInitParameter("com.sun.jersey.config.property.resourceConfigClass",
                "com.sun.jersey.api.core.PackagesResourceConfig");
        servlet2.setInitParameter("com.sun.jersey.config.property.packages",
                "com.mw.maven.jetty2");

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);

        handler.setContextPath("/abc");
        handler.addServlet(servlet, "/api/*");
        handler.addServlet(servlet2, "/api2/*");

        server.setHandler(handler);
        server.start();
        System.out.println("start...in 82");
    }

}

