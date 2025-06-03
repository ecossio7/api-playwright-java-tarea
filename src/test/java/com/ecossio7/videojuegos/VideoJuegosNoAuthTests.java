package com.ecossio7.videojuegos;

import com.google.gson.JsonParser;
import com.microsoft.playwright.APIRequestContext;
import models.RError;
import models.RVideoJuego;
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
    void getAllVideoJuegosTest() {
        apiResponse = videoJuegoRequests.getAll(requestOptions);
        final var actualError = gson.fromJson(apiResponse.text(), RError.class);
        Assertions.assertEquals(401, apiResponse.status());
        Assertions.assertEquals("No autorizado", actualError.mensaje());
    }

    @Test
    void findVideoJuegoTest() {
        requestOptions.setQueryParam("nombre", "Pac-Man");
        apiResponse = videoJuegoRequests.getAll(requestOptions);
        final var actualError = gson.fromJson(apiResponse.text(), RError.class);
        Assertions.assertEquals(401, apiResponse.status());
        Assertions.assertEquals("No autorizado", actualError.mensaje());
    }

    @Test
    void sortVideoJuegosTest() {
        requestOptions.setQueryParam("sortBy", "epoca");
        requestOptions.setQueryParam("order", "asc");
        apiResponse = videoJuegoRequests.getAll(requestOptions);
        final var actualError = gson.fromJson(apiResponse.text(), RError.class);
        Assertions.assertEquals(401, apiResponse.status());
        Assertions.assertEquals("No autorizado", actualError.mensaje());
    }

    @Test
    void filterVideoJuegosTest() {
        requestOptions.setQueryParam("filterBy", "genero");
        requestOptions.setQueryParam("value", "comedia");
        apiResponse = videoJuegoRequests.getAll(requestOptions);
        final var actualError = gson.fromJson(apiResponse.text(), RError.class);
        Assertions.assertEquals(401, apiResponse.status());
        Assertions.assertEquals("No autorizado", actualError.mensaje());
    }

    @Test
    void getVideoJuegoTest() {
        apiResponse = videoJuegoRequests.getById(25, requestOptions);
        final var actualError = gson.fromJson(apiResponse.text(), RError.class);
        Assertions.assertEquals(401, apiResponse.status());
        Assertions.assertEquals("No autorizado", actualError.mensaje());
    }

    @Test
    void createVideoJuegoTest() {
        final var participant = RVideoJuego.generateVideoJuego();
        final var jsonString = gson.toJson(participant);
        final var jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
        jsonObject.remove(("id"));
        requestOptions.setData(jsonObject);
        apiResponse = videoJuegoRequests.create(requestOptions);
        final var actualError = gson.fromJson(apiResponse.text(), RError.class);
        Assertions.assertEquals(401, apiResponse.status());
        Assertions.assertEquals("No autorizado", actualError.mensaje());
    }

    @Test
    void updateVideoJuegoTest() throws IOException {
        final var body = Files.readAllBytes(Paths.get("src/test/resources/videoJuego.json"));
        requestOptions.setData(body);
        apiResponse = videoJuegoRequests.update(5, requestOptions);
        final var actualError = gson.fromJson(apiResponse.text(), RError.class);
        Assertions.assertEquals(401, apiResponse.status());
        Assertions.assertEquals("No autorizado", actualError.mensaje());
    }

    @Test
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
        final var actualError = gson.fromJson(apiResponse.text(), RError.class);
        Assertions.assertEquals(401, apiResponse.status());
        Assertions.assertEquals("No autorizado", actualError.mensaje());
    }

    @Test
    void deleteVideoJuegoTest() {
        apiResponse = videoJuegoRequests.delete(5, requestOptions);
        final var actualError = gson.fromJson(apiResponse.text(), RError.class);
        Assertions.assertEquals(401, apiResponse.status());
        Assertions.assertEquals("No autorizado", actualError.mensaje());
    }
}
