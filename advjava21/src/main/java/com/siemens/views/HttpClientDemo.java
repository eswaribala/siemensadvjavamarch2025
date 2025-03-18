package com.siemens.views;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientDemo {
    public static void main(String[] args) {

        //step 1
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(5))
                .build();

        //step 2

        HttpRequest request = HttpRequest.newBuilder().GET()
                .uri(URI.create("https://restcountries.com/v2/all")) .build();

        HttpResponse<String> response;
        HttpHeaders headers;
        JSONArray jsonArray;
        try
        {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            headers = response.headers();
            headers.map().entrySet().stream().forEach((entry)->{
                System.out.println(entry.getKey()+ ": " + entry.getValue());
            });
           jsonArray = new JSONArray(response.body().toString());
           for (int i = 0; i < jsonArray.length(); i++) {
               JSONObject jsonObject = jsonArray.getJSONObject(i);
               System.out.println(jsonObject.getString("name"));
           }

        }catch (Exception ignored){

        }



    }
}
