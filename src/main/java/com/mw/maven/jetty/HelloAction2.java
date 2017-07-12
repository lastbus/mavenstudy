package com.mw.maven.jetty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Administrator on 2017/7/8.
 */


public class HelloAction2 {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws Exception {
        return "hello wolrd! kjhddjssfkjas ";
    }
}


