package com.ecossio7.participants;

import anotations.Regression;
import com.microsoft.playwright.APIRequestContext;
import models.Error;
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
        requestOptions.setData("{}");
        apiResponse = participantsRequests.create(requestOptions);
        Assertions.assertEquals(400, apiResponse.status());
        final var actualError = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("Debe especificar un payload", actualError.mensaje());
    }

    @Test
    @Regression
    void updateParticipantTest() {
        requestOptions.setData("{}");
        apiResponse = participantsRequests.update(5, requestOptions);
        Assertions.assertEquals(400, apiResponse.status());
        final var actualError = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("Debe especificar un payload", actualError.mensaje());
    }

    @Test
    @Regression
    void partialParticipantTest() {
        requestOptions.setData("{}");
        apiResponse = participantsRequests.partialUpdate(5, requestOptions);
        Assertions.assertEquals(400, apiResponse.status());
        final var actualError = gson.fromJson(apiResponse.text(), Error.class);
        Assertions.assertEquals("Debe especificar un payload", actualError.mensaje());
    }
}
