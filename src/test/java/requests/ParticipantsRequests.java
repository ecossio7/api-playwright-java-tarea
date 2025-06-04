package requests;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import io.qameta.allure.Step;
import utilities.ApiLogger;
import utilities.BaseRequest;
import utilities.BaseTest.Method;

public class ParticipantsRequests extends BaseRequest {
    public ParticipantsRequests(APIRequestContext apiRequestContext) {
        super(apiRequestContext);
    }

    @Step("(GET) Get all participants")
    public APIResponse getAll(RequestOptions requestOptions) {
        apiResponse = apiRequestContext.get("participantes", requestOptions);
        ApiLogger.logApi(apiResponse, Method.GET);
        return apiResponse;
    }

    @Step("(GET) Get participant by ID")
    public APIResponse getById(int id, RequestOptions requestOptions) {
        final var endpoint = String.format("participantes/%d", id);
        apiResponse = apiRequestContext.get(endpoint, requestOptions);
        ApiLogger.logApi(apiResponse, Method.GET);
        return apiResponse;
    }

    @Step("(POST) Create participant")
    public APIResponse create(RequestOptions requestOptions) {
        apiResponse = apiRequestContext.post("participantes", requestOptions);
        ApiLogger.logApi(apiResponse, Method.POST);
        return apiResponse;
    }

    @Step("(PUT) Update participant")
    public APIResponse update(int id, RequestOptions requestOptions) {
        final var endpoint = String.format("participantes/%d", id);
        apiResponse = apiRequestContext.put(endpoint, requestOptions);
        ApiLogger.logApi(apiResponse, Method.PUT);
        return apiResponse;
    }

    @Step("(PATCH) Partial update participant")
    public APIResponse partialUpdate(int id, RequestOptions requestOptions) {
        final var endpoint = String.format("participantes/%d", id);
        apiResponse = apiRequestContext.patch(endpoint, requestOptions);
        ApiLogger.logApi(apiResponse, Method.PATCH);
        return apiResponse;
    }

    @Step("(DELETE) Delete participant")
    public APIResponse delete(int id, RequestOptions requestOptions) {
        final var endpoint = String.format("participantes/%d", id);
        apiResponse = apiRequestContext.delete(endpoint, requestOptions);
        ApiLogger.logApi(apiResponse, Method.DELETE);
        return apiResponse;
    }
}
