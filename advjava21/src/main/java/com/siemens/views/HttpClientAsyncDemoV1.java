package com.siemens.views;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.siemens.dtos.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HttpClientAsyncDemoV1 {
    public static void main(String[] args) {

        //step 1
        HttpClient client = HttpClient.newHttpClient();
        //step 2
        HttpRequest request = HttpRequest.newBuilder().GET()
                .uri(URI.create("https://jsonplaceholder.typicode.com/users")) .build();

      CompletableFuture<HttpResponse<String>> completableFuture=
              client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

      completableFuture
              .thenApply(HttpResponse::body)

              .thenAccept(response->{

               Gson gson = new Gson();
               Type userListType = new TypeToken<List<User>>() {}.getType();
               List<User> users=gson.fromJson(response, userListType);
               users.forEach(System.out::println);

              }).exceptionally(ex->{
                  System.out.println(ex.getMessage());
                  return null;
              }).join();



    }



}
