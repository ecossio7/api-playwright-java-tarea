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

public class ParticipantsEmptyTests extends BaseTest {
    private ParticipantsRequests participantsRequests;

    @BeforeEach
    void setUp(APIRequestContext apiRequestContext) throws IOException {
        initOAuth2(apiRequestContext, requestOptions);
        participantsRequests = new ParticipantsRequests(apiRequestContext);
    }


    @Test
    @Regression
    void createParticipantTest() {
        final var body = "{}";
        requestOptions.setData(body);
        apiResponse = participantsRequests.create(requestOptions);
        final var actualError = gson.fromJson(apiResponse.text(), RError.class);
        Assertions.assertEquals(400, apiResponse.status());
        Assertions.assertEquals("Debe especificar un payload", actualError.mensaje());
    }

    @Test
    @Regression
    void updateParticipantTest() {
        final var body = "{}";
        requestOptions.setData(body);
        apiResponse = participantsRequests.update(5, requestOptions);
        final var actualError = gson.fromJson(apiResponse.text(), RError.class);
        Assertions.assertEquals(400, apiResponse.status());
        Assertions.assertEquals("Debe especificar un payload", actualError.mensaje());
    }

    @Test
    @Regression
    void partialParticipantTest() {
        final var body = "{}";
        requestOptions.setData(body);
        apiResponse = participantsRequests.partialUpdate(5, requestOptions);
        final var actualError = gson.fromJson(apiResponse.text(), RError.class);
        Assertions.assertEquals(400, apiResponse.status());
        Assertions.assertEquals("Debe especificar un payload", actualError.mensaje());
    }
}
