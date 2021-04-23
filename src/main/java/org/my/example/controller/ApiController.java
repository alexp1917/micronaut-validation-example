package org.my.example.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import org.my.example.model.NewShortCode;
import org.my.example.model.Shortened;

import java.util.Date;


@ErrorHidden
@Controller("/api")
public class ApiController {

    @Get
    public HttpResponse<?> api() {
        return HttpResponse.accepted().body(new Date());
    }

    @Post("/code")
    public HttpResponse<?> newCode(@Body Shortened shortened) {
        return HttpResponse.accepted().body(shortened);
    }

}
