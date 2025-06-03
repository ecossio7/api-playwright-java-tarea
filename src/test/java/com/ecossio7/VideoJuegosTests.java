package com.ecossio7;

import com.microsoft.playwright.APIRequestContext;
import models.VideoJuego;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requests.VideoJuegoRequests;
import utilities.BaseTest;

public class VideoJuegosTests extends BaseTest {
    private VideoJuegoRequests videoJuegoRequests;

    @BeforeEach
    void setUp(APIRequestContext apiRequestContext) {
        videoJuegoRequests = new VideoJuegoRequests(apiRequestContext);
    }

    @Test
    void getAllVideoJuegosTest() {
        apiResponse = videoJuegoRequests.getAll(requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
    }

    @Test
    void findVideoJuegoTest() {
        requestOptions.setQueryParam("nombre", "Pac-Man");
        apiResponse = videoJuegoRequests.getAll(requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
    }

    @Test
    void sortVideoJuegosTest() {
        requestOptions.setQueryParam("sortBy", "epoca");
        requestOptions.setQueryParam("order", "asc");
        apiResponse = videoJuegoRequests.getAll(requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
    }

    @Test
    void filterVideoJuegosTest() {
        requestOptions.setQueryParam("filterBy", "genero");
        requestOptions.setQueryParam("value", "comedia");
        apiResponse = videoJuegoRequests.getAll(requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
    }

    @Test
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
    void createVideoJuegoTest() {
        final var body = """
                {
                    "nombre": "Ergonomic Rubber Pizza",
                    "epoca": 2024,
                    "precio": 296.51,
                    "duracion": 7,
                    "genero": "bandwidth",
                    "empresa": {
                        "nombre": "Hayes - Cartwright",
                        "paginaWeb": "http://celia.org",
                        "mision": "Borders",
                        "direccion": {
                            "direccion": "75189 Vilma Way",
                            "ciudad": "Bolivia",
                            "estado": "North Carolina",
                            "pais": "Long Beach",
                            "continente": "North America",
                            "codigoPostal": "68268-3939",
                            "coordenadas": {
                                "latitud": -65.5507,
                                "longitud": -15.9609
                            }
                        }
                    }
                }
                """;
        requestOptions.setData(body);
        apiResponse = videoJuegoRequests.create(requestOptions);
        Assertions.assertEquals(201, apiResponse.status());
    }

    @Test
    void updateVideoJuegoTest() {
        final var body = """
                {
                     "nombre": "update-blass",
                     "epoca": 2024,
                     "precio": 31.3,
                     "duracion": 7,
                     "genero": "update-terror",
                     "empresa": {
                         "nombre": "update",
                         "paginaWeb": "https://afraid-summer.net",
                         "mision": "update-Immersive intermediate utilisation",
                         "direccion": {
                             "direccion": "update-22257 W Pine Street",
                             "ciudad": "update-Carmichael",
                             "estado": "update-North Carolina",
                             "pais": "update-Malaysia",
                             "continente": "update-North America",
                             "codigoPostal": "68268-3939",
                             "coordenadas": {
                                 "latitud": 110.94,
                                 "longitud": 84.64
                             }
                         }
                     }
                 }
                """;
        requestOptions.setData(body);
        apiResponse = videoJuegoRequests.update(5, requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
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
        Assertions.assertEquals(200, apiResponse.status());
    }

    @Test
    void deleteVideoJuegoTest() {
        apiResponse = videoJuegoRequests.delete(5, requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
    }
}
