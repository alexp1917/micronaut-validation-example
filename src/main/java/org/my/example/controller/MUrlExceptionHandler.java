// package org.my.example.controller;
//
// import io.micronaut.http.HttpRequest;
// import io.micronaut.http.HttpResponse;
// import io.micronaut.http.HttpStatus;
// import io.micronaut.http.annotation.Produces;
// import io.micronaut.http.server.exceptions.ExceptionHandler;
//
// import javax.inject.Singleton;
// import java.net.MalformedURLException;
//
//
// @Produces
// @Singleton
// public class MUrlExceptionHandler implements ExceptionHandler<MalformedURLException,
//         HttpResponse<?>> {
//     @Override
//     public HttpResponse<?> handle(HttpRequest request, MalformedURLException exception) {
//         return HttpResponse.status(HttpStatus.BAD_REQUEST, "hey oh");
//     }
// }
