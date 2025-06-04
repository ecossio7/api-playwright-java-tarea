package com.ecossio7.participants;

import anotations.Regression;
import com.google.gson.JsonParser;
import com.microsoft.playwright.APIRequestContext;
import models.Error;
import models.Participant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requests.ParticipantsRequests;
import utilities.BaseTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParticipantsNoAuthTests extends BaseTest {
    private ParticipantsRequests participantsRequests;

    @BeforeEach
    void setUp(APIRequestContext apiRequestContext) throws IOException {
        participantsRequests = new ParticipantsRequests(apiRequestContext);
    }

    @Test
    @Regression
    void getAllParticipantsTest() {
        apiResponse = participantsRequests.getAll(requestOptions);
        Assertions.assertEquals(401, apiResponse.status());
        final var error = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("No autorizado", error.mensaje());
    }

    @Test
    @Regression
    void findParticipantTest() {
        requestOptions.setQueryParam("nombre", "Will");
        apiResponse = participantsRequests.getAll(requestOptions);
        Assertions.assertEquals(401, apiResponse.status());
        final var error = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("No autorizado", error.mensaje());
    }

    @Test
    @Regression
    void sortParticipantsTest() {
        requestOptions.setQueryParam("sortBy", "dislikes");
        requestOptions.setQueryParam("order", "asc");
        apiResponse = participantsRequests.getAll(requestOptions);
        Assertions.assertEquals(401, apiResponse.status());
        final var error = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("No autorizado", error.mensaje());
    }

    @Test
    @Regression
    void filterParticipantsTest() {
        requestOptions.setQueryParam("filterBy", "plataforma");
        requestOptions.setQueryParam("value", "tiktok");
        apiResponse = participantsRequests.getAll(requestOptions);
        Assertions.assertEquals(401, apiResponse.status());
        final var error = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("No autorizado", error.mensaje());
    }

    @Test
    @Regression
    void getParticipantTest() {
        apiResponse = participantsRequests.getById(20, requestOptions);
        Assertions.assertEquals(401, apiResponse.status());
        final var error = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("No autorizado", error.mensaje());
    }

    @Test
    @Regression
    void createParticipantTest() {
        final var participant = Participant.generateRParticipant();
        final var jsonString = gson.toJson(participant);
        final var jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
        jsonObject.remove(("id"));

        requestOptions.setData(jsonObject);
        apiResponse = participantsRequests.create(requestOptions);
        Assertions.assertEquals(401, apiResponse.status());
        final var error = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("No autorizado", error.mensaje());
    }

    @Test
    @Regression
    void updateParticipantTest() throws IOException {
        final var body = Files.readAllBytes(Paths.get("src/test/resources/participant.json"));
        requestOptions.setData(body);
        apiResponse = participantsRequests.update(5, requestOptions);
        Assertions.assertEquals(401, apiResponse.status());
        final var error = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("No autorizado", error.mensaje());
    }

    @Test
    @Regression
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
        Assertions.assertEquals(401, apiResponse.status());
        final var error = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("No autorizado", error.mensaje());
    }

    @Test
    @Regression
    void deleteParticipantTest() {
        apiResponse = participantsRequests.delete(5, requestOptions);
        Assertions.assertEquals(401, apiResponse.status());
        final var error = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("No autorizado", error.mensaje());
    }
}
