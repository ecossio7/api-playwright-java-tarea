package com.ecossio7.videojuegos;

import anotations.Regression;
import com.microsoft.playwright.APIRequestContext;
import models.Error;
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
    @Regression
    void createVideoJuegoTest() {
        requestOptions.setData("{}");
        apiResponse = videoJuegoRequests.create(requestOptions);
        Assertions.assertEquals(400, apiResponse.status());
        final var actualError = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("Debe especificar un payload", actualError.mensaje());
    }

    @Test
    @Regression
    void updateVideoJuegoTest() {
        requestOptions.setData("{}");
        apiResponse = videoJuegoRequests.update(5, requestOptions);
        Assertions.assertEquals(400, apiResponse.status());
        final var actualError = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("Debe especificar un payload", actualError.mensaje());
    }

    @Test
    @Regression
    void partialVideoJuegoTest() {
        requestOptions.setData("{}");
        apiResponse = videoJuegoRequests.partialUpdate(5, requestOptions);
        Assertions.assertEquals(400, apiResponse.status());
        final var actualError = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("Debe especificar un payload", actualError.mensaje());
    }
}
