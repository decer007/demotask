package com.cobrick;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class ColorControllerTest {

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    public void testPublishing() {
        final String requestBody =
                "[\n" + "{\n" +
                "\"publish\": true,\n" +
                "\"color\": \"255,0,0\"\n" +
                "},\n" + "{\n" +
                "\"publish\": true,\n" +
                "\"color\": \"0,255,0\"\n" +
                "},\n" + "{\n" +
                "\"publish\": true,\n" +
                "\"color\": \"0,0,255\"\n" +
                "},\n" + "{\n" +
                "\"publish\": false,\n" +
                "\"color\": \"\"\n" +
                "},\n" + "{\n" +
                "\"publish\": true,\n" +
                "\"color\": \"\"\n" +
                "},\n" + "{\n" +
                "\"publish\": true,\n" +
                "\"color\": null\n" +
                "}\n" + "]";
        final HttpRequest<String> request = HttpRequest.POST("/publish", requestBody);
        final String responseBody = client.toBlocking().retrieve(request);
        assertNotNull(responseBody);
        assertEquals("{\"published\":true}", responseBody);
    }
}
