package org.my.example.controller;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.convert.exceptions.ConversionErrorException;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.annotation.*;
import io.micronaut.web.router.exceptions.UnsatisfiedBodyRouteException;
import org.my.example.model.Shortened;

import java.util.Date;


@Controller("/api")
public class ApiController {

    @Get
    public HttpResponse<?> api() {
        return HttpResponse.accepted().body(new Date());
    }

    @Post("/required")
    public HttpResponse<?> newCode(@Body Shortened shortened) {
        return HttpResponse.accepted().body("{\"good\": \"job\"}");
    }

    @Post("/code")
    public HttpResponse<?> newCode(@Body @Nullable Shortened shortened,
                                   HttpRequest<?> request) {
        return HttpResponse.accepted().body(shortened);
    }

    @Error(exception = UnsatisfiedBodyRouteException.class)
    public HttpResponse<?> handle(UnsatisfiedBodyRouteException e) {
        return null;
    }

    @Error(exception = ConversionErrorException.class)
    public HttpResponse<?> jsonErrorHttpResponse(HttpRequest<?> request,
                                                 Throwable e) {

        return HttpResponse.badRequest("fix your json");
    }

}
