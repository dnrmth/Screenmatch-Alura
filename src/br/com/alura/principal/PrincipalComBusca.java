package br.com.alura.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://www.omdbapi.com/?t=matrix&apikey=ae2e66cb"))
                .build();

        HttpResponse<String> responce = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(responce.body());
    }
}


//http://www.omdbapi.com/?i=tt3896198&apikey=ae2e66cb