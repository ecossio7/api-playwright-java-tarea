package com.ecossio7;

import com.microsoft.playwright.APIRequestContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requests.ParticipantsRequests;
import utilities.BaseTest;

public class ParticipantsTests extends BaseTest {
    private ParticipantsRequests participantsRequests;

    @BeforeEach
    void setUp(APIRequestContext apiRequestContext) {
        participantsRequests = new ParticipantsRequests(apiRequestContext);
    }

    @Test
    void getAllParticipantsTest() {
        apiResponse = participantsRequests.getAll(requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
    }

    @Test
    void findParticipantTest() {
        requestOptions.setQueryParam("nombre", "Will");
        apiResponse = participantsRequests.getAll(requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
    }

    @Test
    void sortParticipantsTest() {
        requestOptions.setQueryParam("sortBy", "dislikes");
        requestOptions.setQueryParam("order", "asc");
        apiResponse = participantsRequests.getAll(requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
    }

    @Test
    void filterParticipantsTest() {
        requestOptions.setQueryParam("filterBy", "plataforma");
        requestOptions.setQueryParam("value", "tiktok");
        apiResponse = participantsRequests.getAll(requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
    }

    @Test
    void getParticipantTest() {
        apiResponse = participantsRequests.getById(5, requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
    }

    @Test
    void createParticipantTest() {
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
        apiResponse = participantsRequests.create(requestOptions);
        Assertions.assertEquals(201, apiResponse.status());
    }

    @Test
    void updateParticipantTest() {
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
        apiResponse = participantsRequests.update(5, requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
    }

    @Test
    void partialParticipantTest() {
        String body = """
                {
                    "nombre": "partial-updated-nombre",
                    "apellido": "partial-updated-apellido",
                    "correo": "partial-update@gmail.com"
                }
                """;
        requestOptions.setData(body);
        apiResponse = participantsRequests.partialUpdate(5, requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
    }

    @Test
    void deleteParticipantTest() {
        apiResponse = participantsRequests.delete(5, requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
    }
}
