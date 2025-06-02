package utilities;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;

import java.util.Map;

public class CustomOptions implements OptionsFactory {

    /**
     * Creates and returns an Options object configured with API request options.
     */
    @Override
    public Options getOptions() {
        APIRequest.NewContextOptions apiRequestOptions = buildApiRequestOptions();

        // Create Options object and set the prepared API request options
        Options options = new Options();
        options.setApiRequestOptions(apiRequestOptions);

        return options;
    }

    /**
     * Constructs and configures APIRequest.NewContextOptions with base URL
     * and required HTTP headers for API communication.
     */
    private APIRequest.NewContextOptions buildApiRequestOptions() {
        APIRequest.NewContextOptions requestOptions = new APIRequest.NewContextOptions();

        // Set the base URL for all API requests
        requestOptions.setBaseURL("http://127.0.0.1:3000");

        // Set content type header to JSON for proper API data format
        requestOptions.setExtraHTTPHeaders(Map.of("Content-Type", "application/json"));

        return requestOptions;
    }
}
