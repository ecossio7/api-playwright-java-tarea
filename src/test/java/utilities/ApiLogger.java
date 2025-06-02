package utilities;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.microsoft.playwright.APIResponse;

import java.util.Map;

public class ApiLogger {

    public static void logApi(APIResponse response, BaseTest.Method method) {
        final var responseHeaders = parseHeaders(response.headers());
        final var responseBody = format(response.text());

        System.out.printf("""
                URL: (%s) %s,
                Status Code: %s,
                Response Body: %n%s
                %n""", method, response.url(), response.status(), responseBody);
        Logs.info(
                """
                        \nURL: (%s) %s
                        =============================================
                        Response
                        =============================================
                        Status Code: %s
                        Response Headers:
                        ----------------
                        %s
                        Response Body:
                        -------------
                        %s
                        """, method, response.url(), response.status(), responseHeaders, responseBody
        );
    }

    private static String parseHeaders(Map<String, String> headerMap) {
        final var stringBuilder = new StringBuilder();
        for (var values : headerMap.entrySet()) {
            stringBuilder.append(String.format("\t%s: %s%n", values.getKey(), values.getValue()));
        }
        return stringBuilder.toString();
    }

    private static String format(String source) {
        final var jsonElement = JsonParser.parseString(source);
        final var gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(jsonElement);
    }
}
