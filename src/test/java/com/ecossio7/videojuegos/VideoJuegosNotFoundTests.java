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
import java.nio.file.Files;
import java.nio.file.Paths;

public class VideoJuegosNotFoundTests extends BaseTest {
    private VideoJuegoRequests videoJuegoRequests;

    @BeforeEach
    void setUp(APIRequestContext apiRequestContext) throws IOException {
        initOAuth2(apiRequestContext, requestOptions);
        videoJuegoRequests = new VideoJuegoRequests(apiRequestContext);
    }

    @Test
    @Regression
    void getVideoJuegoTest() {
        apiResponse = videoJuegoRequests.getById(5000, requestOptions);
        Assertions.assertEquals(404, apiResponse.status());
        final var actualError = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("Videojuego con id 5000 no encontrado", actualError.mensaje());
    }


    @Test
    @Regression
    void updateVideoJuegoTest() throws IOException {
        final var body = Files.readAllBytes(Paths.get("src/test/resources/videoJuego.json"));
        requestOptions.setData(body);
        apiResponse = videoJuegoRequests.update(5000, requestOptions);
        Assertions.assertEquals(404, apiResponse.status());
        final var actualError = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("Videojuego con id 5000 no encontrado", actualError.mensaje());
    }

    @Test
    @Regression
    void partialVideoJuegoTest() {
        final var body = """
                {
                    "nombre": "partial-Blass",
                    "epoca": 2024,
                    "precio": 31.3,
                    "duracion": 7,
                    "genero": "partial-accion"
                }
                """;
        requestOptions.setData(body);
        apiResponse = videoJuegoRequests.partialUpdate(5000, requestOptions);
        Assertions.assertEquals(404, apiResponse.status());
        final var actualError = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("Videojuego con id 5000 no encontrado", actualError.mensaje());
    }

    @Test
    @Regression
    void deleteVideoJuegoTest() {
        apiResponse = videoJuegoRequests.delete(5000, requestOptions);
        Assertions.assertEquals(404, apiResponse.status());
        final var actualError = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("Videojuego con id 5000 no encontrado", actualError.mensaje());
    }
}
