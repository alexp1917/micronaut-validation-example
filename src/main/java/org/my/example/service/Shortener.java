package org.my.example.service;

import javax.inject.Singleton;
import java.net.URL;


/**
 * class to manage storing things in DB and cache
 */
@Singleton
public class Shortener {

    private final Cache cache;

    public Shortener(Cache cache) {
        this.cache = cache;
    }

    // public String shorten(URL url) {
    //
    // }

}
