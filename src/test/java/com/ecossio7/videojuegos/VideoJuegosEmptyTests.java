package com.ecossio7.videojuegos;

import com.microsoft.playwright.APIRequestContext;
import models.RError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requests.VideoJuegoRequests;
import utilities.BaseTest;

import java.io.IOException;

public class VideoJuegosEmptyTests extends BaseTest {
    private VideoJuegoRequests videoJuegoRequests;

    @BeforeEach
    void setUp(APIRequestContext apiRequestContext) throws IOException {
        initOAuth2(apiRequestContext, requestOptions);
        videoJuegoRequests = new VideoJuegoRequests(apiRequestContext);
    }

    @Test
    void createVideoJuegoTest() {
        final var body = "{}";
        requestOptions.setData(body);
        apiResponse = videoJuegoRequests.create(requestOptions);
        final var actualError = gson.fromJson(apiResponse.text(), RError.class);
        Assertions.assertEquals(400, apiResponse.status());
        Assertions.assertEquals("Debe especificar un payload", actualError.mensaje());
    }

    @Test
    void updateVideoJuegoTest() {
        final var body = "{}";
        requestOptions.setData(body);
        apiResponse = videoJuegoRequests.update(5, requestOptions);
        final var actualError = gson.fromJson(apiResponse.text(), RError.class);
        Assertions.assertEquals(400, apiResponse.status());
        Assertions.assertEquals("Debe especificar un payload", actualError.mensaje());
    }

    @Test
    void partialVideoJuegoTest() {
        final var body = "{}";
        requestOptions.setData(body);
        apiResponse = videoJuegoRequests.partialUpdate(5, requestOptions);
        final var actualError = gson.fromJson(apiResponse.text(), RError.class);
        Assertions.assertEquals(400, apiResponse.status());
        Assertions.assertEquals("Debe especificar un payload", actualError.mensaje());
    }
}
