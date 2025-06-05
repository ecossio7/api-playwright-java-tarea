package requests;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import io.qameta.allure.Step;
import utilities.ApiLogger;
import utilities.BaseRequest;
import utilities.BaseTest.Method;

public class ParticipantsRequests extends BaseRequest {
    private static final String ENDPOINT = "participantes";

    public ParticipantsRequests(APIRequestContext apiRequestContext) {
        super(apiRequestContext);
    }

    /**
     * Get all video games
     */
    @Step("(GET) Get all video games")
    public APIResponse getAll(RequestOptions requestOptions) {
        return sendRequest(Method.GET, ENDPOINT, requestOptions);
    }

    /**
     * Get a video game by its ID
     */
    @Step("(GET) Get video game by ID")
    public APIResponse getById(int id, RequestOptions requestOptions) {
        String endpoint = String.format("%s/%d", ENDPOINT, id);
        return sendRequest(Method.GET, endpoint, requestOptions);
    }

    /**
     * Create a new video game
     */
    @Step("(POST) Create new video game")
    public APIResponse create(RequestOptions requestOptions) {
        return sendRequest(Method.POST, ENDPOINT, requestOptions);
    }

    /**
     * Update an existing video game
     */
    @Step("(PUT) Update video game")
    public APIResponse update(int id, RequestOptions requestOptions) {
        String endpoint = String.format("%s/%d", ENDPOINT, id);
        return sendRequest(Method.PUT, endpoint, requestOptions);
    }

    /**
     * Partially update a video game
     */
    @Step("(PATCH) Partial update video game")
    public APIResponse partialUpdate(int id, RequestOptions requestOptions) {
        String endpoint = String.format("%s/%d", ENDPOINT, id);
        return sendRequest(Method.PATCH, endpoint, requestOptions);
    }

    /**
     * Delete a video game
     */
    @Step("(DELETE) Delete video game")
    public APIResponse delete(int id, RequestOptions requestOptions) {
        String endpoint = String.format("%s/%d", ENDPOINT, id);
        return sendRequest(Method.DELETE, endpoint, requestOptions);
    }

    private APIResponse sendRequest(Method httpMethod, String endpoint, RequestOptions requestOptions) {
        switch (httpMethod) {
            case GET:
                apiResponse = apiRequestContext.get(endpoint, requestOptions);
                break;
            case POST:
                apiResponse = apiRequestContext.post(endpoint, requestOptions);
                break;
            case PUT:
                apiResponse = apiRequestContext.put(endpoint, requestOptions);
                break;
            case PATCH:
                apiResponse = apiRequestContext.patch(endpoint, requestOptions);
                break;
            case DELETE:
                apiResponse = apiRequestContext.delete(endpoint, requestOptions);
                break;
            default:
                throw new UnsupportedOperationException("Unsupported HTTP method: " + httpMethod);
        }

        ApiLogger.logApi(apiResponse, httpMethod);
        return apiResponse;
    }
}
