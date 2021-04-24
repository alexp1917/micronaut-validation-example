package org.my.example.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.convert.exceptions.ConversionErrorException;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.hateoas.JsonError;
import org.my.example.model.Shortened;

import java.util.Date;


// @ErrorHidden
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
                                   HttpRequest<?> request
                                   /*FullHttpRequest r,
                                   io.netty.handler.codec.http.FullHttpRequest req*/) {
        // r.getBody();
        // req.getBody();
        // ByteBuf content = req.content();
        String s = request.getBody(String.class).orElse(null);
        return HttpResponse.accepted().body(shortened);
    }

    @Error(exception = ConversionErrorException.class)
    public HttpResponse<?> jsonErrorHttpResponse(HttpRequest<?> request,
                                                 Throwable e) {

        return HttpResponse.badRequest("fix your json");
    }

}
