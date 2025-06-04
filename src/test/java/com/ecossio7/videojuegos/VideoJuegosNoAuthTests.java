package com.ecossio7.videojuegos;

import anotations.Regression;
import com.google.gson.JsonParser;
import com.microsoft.playwright.APIRequestContext;
import models.Error;
import models.VideoJuego;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requests.VideoJuegoRequests;
import utilities.BaseTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VideoJuegosNoAuthTests extends BaseTest {
    private VideoJuegoRequests videoJuegoRequests;

    @BeforeEach
    void setUp(APIRequestContext apiRequestContext) throws IOException {
        videoJuegoRequests = new VideoJuegoRequests(apiRequestContext);
    }

    @Test
    @Regression
    void getAllVideoJuegosTest() {
        apiResponse = videoJuegoRequests.getAll(requestOptions);
        Assertions.assertEquals(401, apiResponse.status());
        final var actualError = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("No autorizado", actualError.mensaje());
    }

    @Test
    @Regression
    void findVideoJuegoTest() {
        requestOptions.setQueryParam("nombre", "Pac-Man");
        apiResponse = videoJuegoRequests.getAll(requestOptions);
        Assertions.assertEquals(401, apiResponse.status());
        final var actualError = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("No autorizado", actualError.mensaje());
    }

    @Test
    @Regression
    void sortVideoJuegosTest() {
        requestOptions.setQueryParam("sortBy", "epoca");
        requestOptions.setQueryParam("order", "asc");
        apiResponse = videoJuegoRequests.getAll(requestOptions);
        Assertions.assertEquals(401, apiResponse.status());
        final var actualError = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("No autorizado", actualError.mensaje());
    }

    @Test
    @Regression
    void filterVideoJuegosTest() {
        requestOptions.setQueryParam("filterBy", "genero");
        requestOptions.setQueryParam("value", "comedia");
        apiResponse = videoJuegoRequests.getAll(requestOptions);
        Assertions.assertEquals(401, apiResponse.status());
        final var actualError = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("No autorizado", actualError.mensaje());
    }

    @Test
    @Regression
    void getVideoJuegoTest() {
        apiResponse = videoJuegoRequests.getById(25, requestOptions);
        Assertions.assertEquals(401, apiResponse.status());
        final var actualError = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("No autorizado", actualError.mensaje());
    }

    @Test
    @Regression
    void createVideoJuegoTest() {
        final var participant = VideoJuego.generateVideoJuego();
        final var jsonString = gson.toJson(participant);
        final var jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
        jsonObject.remove(("id"));
        requestOptions.setData(jsonObject);
        apiResponse = videoJuegoRequests.create(requestOptions);
        Assertions.assertEquals(401, apiResponse.status());
        final var actualError = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("No autorizado", actualError.mensaje());
    }

    @Test
    @Regression
    void updateVideoJuegoTest() throws IOException {
        final var body = Files.readAllBytes(Paths.get("src/test/resources/videoJuego.json"));
        requestOptions.setData(body);
        apiResponse = videoJuegoRequests.update(5, requestOptions);
        Assertions.assertEquals(401, apiResponse.status());
        final var actualError = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("No autorizado", actualError.mensaje());
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
        apiResponse = videoJuegoRequests.partialUpdate(5, requestOptions);
        Assertions.assertEquals(401, apiResponse.status());
        final var actualError = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("No autorizado", actualError.mensaje());
    }

    @Test
    @Regression
    void deleteVideoJuegoTest() {
        apiResponse = videoJuegoRequests.delete(5, requestOptions);
        Assertions.assertEquals(401, apiResponse.status());
        final var actualError = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("No autorizado", actualError.mensaje());
    }
}
