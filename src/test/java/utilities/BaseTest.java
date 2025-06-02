package utilities;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.RequestOptions;
import org.junit.jupiter.api.BeforeEach;

@UsePlaywright(CustomOptions.class)
public class BaseTest {
    protected APIResponse apiResponse;
    protected RequestOptions requestOptions;

    @BeforeEach
    void masterSetUp() {
        requestOptions = RequestOptions.create();
        Logs.info("BeforeEach: BaseTest - Initializing request options");
    }

    public enum Method {
        GET,
        POST,
        PUT,
        PATCH,
        DELETE
    }
}
