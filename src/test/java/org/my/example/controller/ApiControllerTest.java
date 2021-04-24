package org.my.example.controller;

import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@MicronautTest
class ApiControllerTest {

    @Inject
    @Client("/")
    RxHttpClient rootClient;

    @Inject
    @Client("/api")
    RxHttpClient apiClient;

    @Test
    public void homeIsEmpty() {
        HttpClientResponseException e = assertThrows(HttpClientResponseException.class, () -> {
            rootClient.toBlocking().exchange("/");
        });

        assertThat(e.getStatus(), is(404));
    }

}
