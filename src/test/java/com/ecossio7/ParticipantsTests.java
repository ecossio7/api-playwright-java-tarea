package com.ecossio7;

import com.microsoft.playwright.APIRequestContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.ApiLogger;
import utilities.BaseTest;

public class ParticipantsTests extends BaseTest {
    private static final String PARTICIPANTS_ENDPOINT = "participantes";
    private static final String SELECTED_ID = "/5";

    @Test
    void getAllParticipantsTest(APIRequestContext apiRequestContext) {
        apiResponse = apiRequestContext.get(PARTICIPANTS_ENDPOINT);
        Assertions.assertEquals(200, apiResponse.status());
        ApiLogger.logApi(apiResponse, Method.GET);
    }

    @Test
    void findParticipantTest(APIRequestContext apiRequestContext) {
        requestOptions.setQueryParam("nombre", "Will");
        apiResponse = apiRequestContext.get(PARTICIPANTS_ENDPOINT, requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
        ApiLogger.logApi(apiResponse, Method.GET);
    }

    @Test
    void sortParticipantsTest(APIRequestContext apiRequestContext) {
        requestOptions.setQueryParam("sortBy", "dislikes");
        requestOptions.setQueryParam("order", "asc");
        apiResponse = apiRequestContext.get(PARTICIPANTS_ENDPOINT, requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
        ApiLogger.logApi(apiResponse, Method.GET);
    }

    @Test
    void filterParticipantsTest(APIRequestContext apiRequestContext) {
        requestOptions.setQueryParam("filterBy", "plataforma");
        requestOptions.setQueryParam("value", "tiktok");
        apiResponse = apiRequestContext.get(PARTICIPANTS_ENDPOINT, requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
        ApiLogger.logApi(apiResponse, Method.GET);
    }

    @Test
    void getParticipantTest(APIRequestContext apiRequestContext) {
        apiResponse = apiRequestContext.get(PARTICIPANTS_ENDPOINT + SELECTED_ID);
        Assertions.assertEquals(200, apiResponse.status());
        ApiLogger.logApi(apiResponse, Method.GET);
    }

    @Test
    void createParticipantTest(APIRequestContext apiRequestContext) {
        String body = """
                {
                    "nombre": "blass",
                    "apellido": "Jakubowski",
                    "correo": "Moriah59@gmail.com",
                    "usuario": "blass4",
                    "clave": "g3ajlkXrHZt6PFY",
                    "reaccion": {
                        "likes": 418,
                        "dislikes": 143
                    },
                    "plataforma": "Administrator"
                }
                """;
        requestOptions.setData(body);
        apiResponse = apiRequestContext.post(PARTICIPANTS_ENDPOINT, requestOptions);
        Assertions.assertEquals(201, apiResponse.status());
        ApiLogger.logApi(apiResponse, Method.POST);
    }

    @Test
    void updateParticipantTest(APIRequestContext apiRequestContext) {
        String body = """
                {
                    "nombre": "updated-nombre",
                    "apellido": "updated-apellido",
                    "correo": "update@gmail.com",
                    "usuario": "update4",
                    "clave": "g3ajlkXrHZt6PFY",
                    "reaccion": {
                        "likes": 4,
                        "dislikes": 4
                    },
                    "plataforma": "Administrator"
                }
                """;
        requestOptions.setData(body);
        apiResponse = apiRequestContext.put(PARTICIPANTS_ENDPOINT + SELECTED_ID, requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
        ApiLogger.logApi(apiResponse, Method.PUT);
    }

    @Test
    void partialParticipantTest(APIRequestContext apiRequestContext) {
        String body = """
                {
                    "nombre": "partial-updated-nombre",
                    "apellido": "partial-updated-apellido",
                    "correo": "partial-update@gmail.com"
                }
                """;
        requestOptions.setData(body);
        apiResponse = apiRequestContext.patch(PARTICIPANTS_ENDPOINT + SELECTED_ID, requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
        ApiLogger.logApi(apiResponse, Method.PATCH);
    }

    @Test
    void deleteParticipantTest(APIRequestContext apiRequestContext) {
        apiResponse = apiRequestContext.delete(PARTICIPANTS_ENDPOINT + SELECTED_ID);
        Assertions.assertEquals(200, apiResponse.status());
        ApiLogger.logApi(apiResponse, Method.DELETE);
    }
}
