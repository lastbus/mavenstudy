package com.mw.maven.jetty;

import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by Administrator on 2017/7/8.
 */
public class JettyServer {

    private void start() throws Exception {
        int port = 8080;
        Server server = new Server(port);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        ServletHolder sh = new ServletHolder(ServletContainer.class);
        sh.setInitParameter("com.sun.jersey.config.property.resourceConfigClass",
                "com.sun.jersey.api.core.PackagesResourceConfig");
        sh.setInitParameter("com.sun.jersey.config.property.packages",
                "com.mw.maven.jetty");

        context.addServlet(sh, "/*");
        server.start();

    }

    public void stop() throws Exception {

    }

    public static void main(String[] args) throws Exception {
        JettyServer server = new JettyServer();
        server.start();
    }

}
