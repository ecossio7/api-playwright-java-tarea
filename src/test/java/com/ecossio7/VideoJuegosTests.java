package com.ecossio7;

import com.microsoft.playwright.APIRequestContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.ApiLogger;
import utilities.BaseTest;

public class VideoJuegosTests extends BaseTest {
    private static final String VIDEOGAMES_ENDPOINT = "videojuegos";
    private static final String SELECTED_ID = "/25";

    @Test
    void getAllVideoJuegosTest(APIRequestContext apiRequestContext) {
        apiResponse = apiRequestContext.get(VIDEOGAMES_ENDPOINT);
        Assertions.assertEquals(200, apiResponse.status());
        ApiLogger.logApi(apiResponse, Method.GET);
    }

    @Test
    void findVideoJuegoTest(APIRequestContext apiRequestContext) {
        requestOptions.setQueryParam("nombre", "Pac-Man");
        apiResponse = apiRequestContext.get(VIDEOGAMES_ENDPOINT, requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
        ApiLogger.logApi(apiResponse, Method.GET);
    }

    @Test
    void sortVideoJuegosTest(APIRequestContext apiRequestContext) {
        requestOptions.setQueryParam("sortBy", "epoca");
        requestOptions.setQueryParam("order", "asc");
        apiResponse = apiRequestContext.get(VIDEOGAMES_ENDPOINT, requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
        ApiLogger.logApi(apiResponse, Method.GET);
    }

    @Test
    void filterVideoJuegosTest(APIRequestContext apiRequestContext) {
        requestOptions.setQueryParam("filterBy", "genero");
        requestOptions.setQueryParam("value", "comedia");
        apiResponse = apiRequestContext.get(VIDEOGAMES_ENDPOINT, requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
        ApiLogger.logApi(apiResponse, Method.GET);
    }

    @Test
    void getVideoJuegoTest(APIRequestContext apiRequestContext) {
        apiResponse = apiRequestContext.get(VIDEOGAMES_ENDPOINT + SELECTED_ID);
        Assertions.assertEquals(200, apiResponse.status());
        ApiLogger.logApi(apiResponse, Method.GET);
    }

    @Test
    void createVideoJuegoTest(APIRequestContext apiRequestContext) {
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
        apiResponse = apiRequestContext.post(VIDEOGAMES_ENDPOINT, requestOptions);
        Assertions.assertEquals(201, apiResponse.status());
        ApiLogger.logApi(apiResponse, Method.POST);
    }

    @Test
    void updateVideoJuegoTest(APIRequestContext apiRequestContext) {
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
        apiResponse = apiRequestContext.put(VIDEOGAMES_ENDPOINT + SELECTED_ID, requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
        ApiLogger.logApi(apiResponse, Method.PUT);
    }

    @Test
    void partialVideoJuegoTest(APIRequestContext apiRequestContext) {
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
        apiResponse = apiRequestContext.patch(VIDEOGAMES_ENDPOINT + SELECTED_ID, requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
        ApiLogger.logApi(apiResponse, Method.PATCH);
    }

    @Test
    void deleteVideoJuegoTest(APIRequestContext apiRequestContext) {
        apiResponse = apiRequestContext.delete(VIDEOGAMES_ENDPOINT + SELECTED_ID);
        Assertions.assertEquals(200, apiResponse.status());
        ApiLogger.logApi(apiResponse, Method.DELETE);
    }
}
