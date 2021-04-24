package org.my.example;

import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import lombok.SneakyThrows;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;


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

    @SneakyThrows
    @EventListener
    public void onStartup(ServerStartupEvent startupEvent) {
        URL url = embeddedServer.getURL();
        String s = url.toString();
        // String s = "url.toString()";

        System.out.println("baseUrl: " + s);

        URLConnection conn = null;
        try {
            URL broken = new URL(s + "/api/required");
            conn = broken.openConnection();
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");

            String requestBody = "{\"code\":\"okay\",\"url\":\"fake-some\"}";
            conn.getOutputStream().write((requestBody).getBytes(StandardCharsets.UTF_8));

            byte[] bytes = conn.getInputStream().readAllBytes();
            String responseBody = new String(bytes);

            System.out.println(responseBody);
        } catch (Exception e) {
            if (conn != null) {
                String returnedErrorMessage =
                        new String(((HttpURLConnection) conn).getErrorStream().readAllBytes());

                e = new Exception(e.getMessage() + "\n\n\n" +
                        returnedErrorMessage, e);
            }

            e.printStackTrace();
        }

    }

}
