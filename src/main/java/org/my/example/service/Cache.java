package org.my.example.service;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
@Singleton
public class Cache {

    private final RedisCommands<String, String> syncApi;

    public Cache(StatefulRedisConnection<String, String> connection) {
        this.syncApi = connection.sync();
    }

    // spaghetti code - try to get the thing; null checks +logs along the way
    public URL resolve(String code) throws MalformedURLException {
        if (code == null) {
            log.debug("resolve code is null");
            return null;
        }

        String s = syncApi.get(code);

        if (s == null) {
            log.debug("resolve code {} got back null", code);
            return null;
        }

        URL url;
        try {
            url = new URL(s);
        } finally {
            log.debug("resolve code {} got back invalid url {}", code, s);
        }

        log.debug("resolve code {} got back url {}", code, url);
        return url;
    }

    public void store(@NonNull String code, @NonNull URL url) {
        String s = url.toString();
        syncApi.set(code, s);
    }

}
