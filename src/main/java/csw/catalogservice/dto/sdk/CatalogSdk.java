package csw.catalogservice.dto.sdk;

import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.databind.ObjectMapper;
import csw.catalogservice.dto.BookDto;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

public class CatalogSdk {

    private final HttpClient httpClient;
    private final String baseUrl;
    public CatalogSdk(String baseUrl) {
        this.httpClient = HttpClients.createDefault();
        this.baseUrl = baseUrl;
    }

    public CompletableFuture<Void> CreateBook(BookDto bookDto, String authToken) {
        if (bookDto == null) {
            throw new IllegalArgumentException("book name cannot be null");
        }

        String url = baseUrl + "/api/catalog/Book";

        return postAsync(url, bookDto, authToken);
    }

    private CompletableFuture<Void> postAsync(String url, Object data, String authToken) {
        var future = new CompletableFuture<Void>();

        try {
            // AUTH HEADER
            var request = new HttpPost(url);
            request.setHeader("Content-Type", "application/json");
            if (authToken != null && !authToken.isEmpty()) {
                request.setHeader("Authorization", "Bearer " + authToken);
            }

            // OBJECT TO STRING
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonData = objectMapper.writeValueAsString(data);
            StringEntity entity = new StringEntity(jsonData);

            request.setEntity(entity);

            httpClient.execute(request, response -> {
                var statusCode = response.getStatusLine().getStatusCode();
                if (statusCode >= 200 && statusCode < 300) {
                    future.complete(null);
                } else {
                    future.completeExceptionally(new RuntimeException("HTTP error code: " + statusCode));
                }
                return null;
            });
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
    }
}