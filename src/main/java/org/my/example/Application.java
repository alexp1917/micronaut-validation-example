package org.my.example;

import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.runtime.server.EmbeddedServer;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.net.URL;


/**
 * /code7tiae -> redirect to http://full.com/shortened/url
 * /api/token - POST - get new token
 * /api/userinfo - GET - see if your token is good or need to refresh
 * /api/code - POST - new code
 * /api/code - GET - whose code is it
 * /api/stats - GET - maybe implement this (def a want not a need)
 */
@Singleton

public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

    @Inject
    private EmbeddedServer embeddedServer;

    @EventListener
    public void onStartup(StartupEvent startupEvent) {
        URL url = embeddedServer.getURL();
        String s = url.toString();
        // String s = "url.toString()";

        System.out.println("baseUrl: " + s);

    }

}
