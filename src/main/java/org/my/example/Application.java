package org.my.example;

import io.micronaut.runtime.Micronaut;


/**
 * /code7tiae -> redirect to http://full.com/shortened/url
 * /api/token - POST - get new token
 * /api/userinfo - GET - see if your token is good or need to refresh
 * /api/code - POST - new code
 * /api/code - GET - whose code is it
 * /api/stats - GET - maybe implement this (def a want not a need)
 */
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

}
