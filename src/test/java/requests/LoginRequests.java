package requests;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import utilities.ApiLogger;
import utilities.BaseRequest;
import utilities.BaseTest;


public class LoginRequests extends BaseRequest {
    public LoginRequests(APIRequestContext apiRequestContext) {
        super(apiRequestContext);
    }

    public APIResponse login(RequestOptions requestOptions) {
        apiResponse = apiRequestContext.post("login", requestOptions);
        ApiLogger.logApi(apiResponse, BaseTest.Method.POST);
        return apiResponse;
    }

}
