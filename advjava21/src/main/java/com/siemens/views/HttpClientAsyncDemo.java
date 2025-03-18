package com.siemens.views;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HttpClientAsyncDemo {
    public static void main(String[] args) {

        //step 1
        HttpClient client = HttpClient.newHttpClient();
        //step 2
        HttpRequest request = HttpRequest.newBuilder().GET()
                .uri(URI.create("https://restcountries.com/v2/all")) .build();

      CompletableFuture<HttpResponse<String>> completableFuture=
              client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

      completableFuture.thenApply(HttpResponse::body)
              .thenApply(HttpClientAsyncDemo::parseJsonArray)
              .thenAccept((jsonArray)->{
                  if(jsonArray!=null){
                      Stream<Object> jsonStream= IntStream.
                              range(0,jsonArray.length()).mapToObj(jsonArray::get);
                      jsonStream.forEach(obj-> {
                          final JSONObject jsonObjectInstance = (JSONObject) obj;
                          if (!jsonObjectInstance.isNull("capital"))
                              System.out.println(jsonObjectInstance.get("name") + "," + jsonObjectInstance.get("capital"));
                      });
                  }
              }).exceptionally(ex->{
                  System.out.println(ex.getMessage());
                  return null;
              }).join();



    }

    public static JSONArray parseJsonArray(String response) {

        try {
            System.out.println(response);
           return new JSONArray(response);
        }catch (JSONException exception){
            return null;
        }
    }

}
