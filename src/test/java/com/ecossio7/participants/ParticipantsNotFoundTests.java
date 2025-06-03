package com.ecossio7.participants;

import Anotations.Regression;
import com.microsoft.playwright.APIRequestContext;
import models.RError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requests.ParticipantsRequests;
import utilities.BaseTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParticipantsNotFoundTests extends BaseTest {
    private ParticipantsRequests participantsRequests;

    @BeforeEach
    void setUp(APIRequestContext apiRequestContext) throws IOException {
        initOAuth2(apiRequestContext, requestOptions);
        participantsRequests = new ParticipantsRequests(apiRequestContext);
    }

    @Test
    @Regression
    void getParticipantTest() {
        apiResponse = participantsRequests.getById(5000, requestOptions);
        Assertions.assertEquals(404, apiResponse.status());
        final var error = gson.fromJson(apiResponse.text(), RError.class);
        Assertions.assertEquals("Participante con id 5000 no encontrado", error.mensaje());

    }

    @Test
    @Regression
    void updateParticipantTest() throws IOException {
        final var body = Files.readAllBytes(Paths.get("src/test/resources/participant.json"));
        requestOptions.setData(body);
        apiResponse = participantsRequests.update(5000, requestOptions);
        Assertions.assertEquals(404, apiResponse.status());
        final var error = gson.fromJson(apiResponse.text(), RError.class);
        Assertions.assertEquals("Participante con id 5000 no encontrado", error.mensaje());
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
        apiResponse = participantsRequests.partialUpdate(5000, requestOptions);
        Assertions.assertEquals(404, apiResponse.status());
        final var error = gson.fromJson(apiResponse.text(), RError.class);
        Assertions.assertEquals("Participante con id 5000 no encontrado", error.mensaje());
    }

    @Test
    @Regression
    void deleteParticipantTest() {
        apiResponse = participantsRequests.delete(5000, requestOptions);
        Assertions.assertEquals(404, apiResponse.status());
        final var error = gson.fromJson(apiResponse.text(), RError.class);
        Assertions.assertEquals("Participante con id 5000 no encontrado", error.mensaje());
    }
}
