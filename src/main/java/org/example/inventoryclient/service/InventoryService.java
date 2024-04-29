package org.example.inventoryclient.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.inventoryclient.dto.PagedResponse;
import org.example.inventoryclient.model.Item;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class InventoryService {
    public static PagedResponse<Item> getItems(int limit) {
        try {
            final var httpClient = HttpClient.newHttpClient();
            final var apiOrigin = System.getProperty("api.origin");
            final var request = HttpRequest.newBuilder(URI.create(apiOrigin + "/api/inventory/products?size=" + limit))
                    .build();
            var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            var json = response.body();
            var mapper = new ObjectMapper();
            return mapper.readValue(json, new TypeReference<>() {
            });
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    public static PagedResponse<Item> getItems() {
        return getItems(50);
    }
}
