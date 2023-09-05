package br.com.alura.principal;

import br.com.alura.screematch.modelos.Titulo;
import br.com.alura.screematch.modelos.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um filme para buscar:");
        var busca = scanner.nextLine();
        String url = "http://www.omdbapi.com/?t=" + busca + "&apikey=ae2e66cb";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
                .build();

        HttpResponse<String> responce = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = responce.body();
        System.out.println(json);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy
                .UPPER_CAMEL_CASE).create();
        TituloOMDB titleOMDB = gson.fromJson(json, TituloOMDB.class);
        System.out.println(titleOMDB);

        Titulo title = new Titulo(titleOMDB);
        System.out.println("Titulo já convertido: "+title);
    }
}


//http://www.omdbapi.com/?i=tt3896198&apikey=ae2e66cb