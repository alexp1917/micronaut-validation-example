package org.my.example.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;
import org.my.example.service.Cache;
import org.my.example.service.Shortener;


@Controller()
public class ShortenedController {

    private final Shortener shortener;

    public ShortenedController(Shortener shortener) {
        this.shortener = shortener;
    }

    @Get("/some/other/route")
    public HttpResponse<?> example(@QueryValue String required) {
        return HttpResponse.ok("required is " + required);
    }

    @Get("/{shortenedCode}")
    public HttpResponse<String> unShorten(@PathVariable("shortenedCode") String shortenedCode) {

        // this would redirect if the shortener found the code
        return HttpResponse.ok("hello world to " + shortenedCode)
                .contentType(MediaType.TEXT_HTML);
    }
}