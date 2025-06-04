package requests;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import io.qameta.allure.Step;
import utilities.ApiLogger;
import utilities.BaseRequest;
import utilities.BaseTest.Method;

public class VideoJuegoRequests extends BaseRequest {
    public VideoJuegoRequests(APIRequestContext apiRequestContext) {
        super(apiRequestContext);
    }

    @Step("(GET) Get all video games")
    public APIResponse getAll(RequestOptions requestOptions) {
        apiResponse = apiRequestContext.get("videojuegos", requestOptions);
        ApiLogger.logApi(apiResponse, Method.GET);
        return apiResponse;
    }

    @Step("(GET) Get video game by ID")
    public APIResponse getById(int id, RequestOptions requestOptions) {
        final var endpoint = String.format("videojuegos/%d", id);
        apiResponse = apiRequestContext.get(endpoint, requestOptions);
        ApiLogger.logApi(apiResponse, Method.GET);
        return apiResponse;
    }

    @Step("(POST) Create video game")
    public APIResponse create(RequestOptions requestOptions) {
        apiResponse = apiRequestContext.post("videojuegos", requestOptions);
        ApiLogger.logApi(apiResponse, Method.POST);
        return apiResponse;
    }

    @Step("(PUT) Update video game")
    public APIResponse update(int id, RequestOptions requestOptions) {
        final var endpoint = String.format("videojuegos/%d", id);
        apiResponse = apiRequestContext.put(endpoint, requestOptions);
        ApiLogger.logApi(apiResponse, Method.PUT);
        return apiResponse;
    }

    @Step("(PATCH) Partial update video game")
    public APIResponse partialUpdate(int id, RequestOptions requestOptions) {
        final var endpoint = String.format("videojuegos/%d", id);
        apiResponse = apiRequestContext.patch(endpoint, requestOptions);
        ApiLogger.logApi(apiResponse, Method.PATCH);
        return apiResponse;
    }

    @Step("(DELETE) Delete video game")
    public APIResponse delete(int id, RequestOptions requestOptions) {
        final var endpoint = String.format("videojuegos/%d", id);
        apiResponse = apiRequestContext.delete(endpoint, requestOptions);
        ApiLogger.logApi(apiResponse, Method.DELETE);
        return apiResponse;
    }
}
