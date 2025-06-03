package utilities;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;

public class BaseRequest {
    protected final APIRequestContext apiRequestContext;
    protected APIResponse apiResponse;

    public BaseRequest(APIRequestContext apiRequestContext) {
        this.apiRequestContext = apiRequestContext;
    }
}

