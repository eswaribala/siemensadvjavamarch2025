package com.siemens.views;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Base64;

public class HttpClientAuthenticationDemo {
    public static void main(String[] args) {

        //step 1
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(5))
                .build();

        //step 2

        HttpRequest request = HttpRequest.newBuilder().GET()
                .uri(URI.create("https://httpbin.org/basic-auth/user/pass"))
                .headers("Authorization",getBasicAuthenticationHeader("user","pass"))
                .build();

        HttpResponse<String> response;
        HttpHeaders headers;

        try
        {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            headers = response.headers();
            headers.map().entrySet().forEach((entry)->{
                System.out.println(entry.getKey()+ ": " + entry.getValue());
            });
           System.out.println(response.body());

        }catch (Exception ignored){

        }



    }

    private static final String getBasicAuthenticationHeader(String username, String password) {
        String valueToEncode = username + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
    }
}
