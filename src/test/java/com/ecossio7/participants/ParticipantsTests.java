package com.ecossio7.participants;

import com.google.gson.JsonParser;
import com.microsoft.playwright.APIRequestContext;
import models.RParticipant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requests.ParticipantsRequests;
import utilities.BaseTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParticipantsTests extends BaseTest {
    private ParticipantsRequests participantsRequests;

    @BeforeEach
    void setUp(APIRequestContext apiRequestContext) throws IOException {
        initOAuth2(apiRequestContext, requestOptions);
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
        apiResponse = participantsRequests.getById(20, requestOptions);
        Assertions.assertEquals(200, apiResponse.status());
        final var participant = gson.fromJson(apiResponse.text(), RParticipant.class);
        Assertions.assertAll(
                () -> Assertions.assertEquals(20, participant.id()),
                () -> Assertions.assertEquals("David", participant.nombre()),
                () -> Assertions.assertEquals("Goy", participant.apellido()),
                () -> Assertions.assertEquals("David_Goy@yahoo.com", participant.correo()),
                () -> Assertions.assertEquals("David_Goy", participant.usuario()),
                () -> Assertions.assertEquals("crfm04M0JM3WeTU", participant.clave()),
                () -> Assertions.assertEquals(210, participant.reaccion().likes()),
                () -> Assertions.assertEquals(1533, participant.reaccion().dislikes()),
                () -> Assertions.assertEquals("youtube", participant.plataforma())

        );
    }

    @Test
    void createParticipantTest() throws IOException {
        final var participant = RParticipant.generateRParticipant();
        final var jsonString = gson.toJson(participant);
        final var jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
        jsonObject.remove(("id"));

        requestOptions.setData(jsonObject);
        apiResponse = participantsRequests.create(requestOptions);
        Assertions.assertEquals(201, apiResponse.status());
    }

    @Test
    void updateParticipantTest() throws IOException {
        final var body = Files.readAllBytes(Paths.get("src/test/resources/participant.json"));
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
