package com.ecossio7.videojuegos;

import anotations.Regression;
import anotations.Smoke;
import com.google.gson.JsonParser;
import com.microsoft.playwright.APIRequestContext;
import models.VideoJuego;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requests.VideoJuegoRequests;
import utilities.BaseTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VideoJuegosTests extends BaseTest {
    private VideoJuegoRequests videoJuegoRequests;

    @BeforeEach
    void setUp(APIRequestContext apiRequestContext) throws IOException {
        initOAuth2(apiRequestContext, requestOptions);
        videoJuegoRequests = new VideoJuegoRequests(apiRequestContext);
    }

    @Test
    @Regression
    @Smoke
    void getAllVideoJuegosTest() {
        apiResponse = videoJuegoRequests.getAll(requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
    }

    @Test
    @Regression
    @Smoke
    void findVideoJuegoTest() {
        requestOptions.setQueryParam("nombre", "Pac-Man");
        apiResponse = videoJuegoRequests.getAll(requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
    }

    @Test
    @Regression
    @Smoke
    void sortVideoJuegosTest() {
        requestOptions.setQueryParam("sortBy", "epoca");
        requestOptions.setQueryParam("order", "asc");
        apiResponse = videoJuegoRequests.getAll(requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
    }

    @Test
    @Regression
    @Smoke
    void filterVideoJuegosTest() {
        requestOptions.setQueryParam("filterBy", "genero");
        requestOptions.setQueryParam("value", "comedia");
        apiResponse = videoJuegoRequests.getAll(requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
    }

    @Test
    @Regression
    @Smoke
    void getVideoJuegoTest() {
        apiResponse = videoJuegoRequests.getById(25, requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
        final var videoJuego = gson.fromJson(apiResponse.text(), VideoJuego.class);
        Assertions.assertAll(
                () -> Assertions.assertEquals(25, videoJuego.id()),
                () -> Assertions.assertEquals("Astro Bot", videoJuego.nombre()),
                () -> Assertions.assertEquals(7, videoJuego.duracion()),
                () -> Assertions.assertEquals("https://winding-zebra.net/", videoJuego.empresa().paginaWeb()),
                () -> Assertions.assertEquals("64902-8286", videoJuego.empresa().direccion().codigoPostal()),
                () -> Assertions.assertEquals(108.22, videoJuego.empresa().direccion().coordenadas().latitud())
        );
    }

    @Test
    @Regression
    @Smoke
    void createVideoJuegoTest() {
        final var participant = VideoJuego.generateVideoJuego();
        final var jsonString = gson.toJson(participant);
        final var jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
        jsonObject.remove(("id"));
        requestOptions.setData(jsonObject);
        apiResponse = videoJuegoRequests.create(requestOptions);
        Assertions.assertEquals(201, apiResponse.status());
    }

    @Test
    @Regression
    @Smoke
    void updateVideoJuegoTest() throws IOException {
        final var body = Files.readAllBytes(Paths.get("src/test/resources/videoJuego.json"));
        requestOptions.setData(body);
        apiResponse = videoJuegoRequests.update(5, requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
    }

    @Test
    @Regression
    @Smoke
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
        Assertions.assertEquals(200, apiResponse.status());
    }

    @Test
    @Regression
    @Smoke
    void deleteVideoJuegoTest() {
        apiResponse = videoJuegoRequests.delete(5, requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
    }
}
