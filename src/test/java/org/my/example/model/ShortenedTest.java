package org.my.example.model;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;


class ShortenedTest {

    @SneakyThrows
    @Test
    public void testUrlValidation() {
        Shortened shortened = new Shortened();
        shortened.setCode("abc");
        shortened.setUrl(new URL("http://abc.def/thing"));
    }

}