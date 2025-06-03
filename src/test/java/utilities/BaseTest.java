package utilities;

import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.RequestOptions;
import org.junit.jupiter.api.BeforeEach;
import requests.LoginRequests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@UsePlaywright(CustomOptions.class)
public class BaseTest {
    protected APIResponse apiResponse;
    protected RequestOptions requestOptions;
    protected Gson gson = new Gson();

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

    public void initOAuth2(APIRequestContext apiRequestContext, RequestOptions requestOptions) throws IOException {
        Logs.info("initOAuth2: Placeholder for OAuth2 initialization logic");
        final var body = Files.readAllBytes(Paths.get("src/test/resources/user.json"));
        requestOptions.setData(body);
        requestOptions.setHeader("Content-Type", "application/json; charset=utf-8");
        LoginRequests loginRequests = new LoginRequests(apiRequestContext);
        apiResponse = loginRequests.login(requestOptions);
        final var json = JsonPath.parse(apiResponse.text());
        final var token = json.read("accessToken", String.class);
        requestOptions.setHeader("Authorization", "Bearer " + token);
    }
}
