package requests;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import utilities.ApiLogger;
import utilities.BaseRequest;
import utilities.BaseTest.Method;

public class VideoJuegoRequests extends BaseRequest {
    public VideoJuegoRequests(APIRequestContext apiRequestContext) {
        super(apiRequestContext);
    }

    public APIResponse getAll(RequestOptions requestOptions) {
        apiResponse = apiRequestContext.get("videojuegos", requestOptions);
        ApiLogger.logApi(apiResponse, Method.GET);
        return apiResponse;
    }

    public APIResponse getById(int id, RequestOptions requestOptions) {
        apiResponse = apiRequestContext.get("videojuegos/" + id, requestOptions);
        ApiLogger.logApi(apiResponse, Method.GET);
        return apiResponse;
    }

    public APIResponse create(RequestOptions requestOptions) {
        apiResponse = apiRequestContext.post("videojuegos", requestOptions);
        ApiLogger.logApi(apiResponse, Method.POST);
        return apiResponse;
    }

    public APIResponse update(int id, RequestOptions requestOptions) {
        apiResponse = apiRequestContext.put("videojuegos/" + id, requestOptions);
        ApiLogger.logApi(apiResponse, Method.PUT);
        return apiResponse;
    }

    public APIResponse partialUpdate(int id, RequestOptions requestOptions) {
        apiResponse = apiRequestContext.patch("videojuegos/" + id, requestOptions);
        ApiLogger.logApi(apiResponse, Method.PATCH);
        return apiResponse;
    }

    public APIResponse delete(int id, RequestOptions requestOptions) {
        apiResponse = apiRequestContext.delete("videojuegos/" + id, requestOptions);
        ApiLogger.logApi(apiResponse, Method.DELETE);
        return apiResponse;
    }
}
