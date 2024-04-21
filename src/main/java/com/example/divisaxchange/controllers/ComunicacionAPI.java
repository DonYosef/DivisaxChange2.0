package com.example.divisaxchange.controllers;

import com.example.divisaxchange.models.DivisaModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.ietf.jgss.GSSContext;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ComunicacionAPI {


    public DivisaModel informacionAPI(String base, String target) throws IOException, InterruptedException {



        HttpClient client = HttpClient.newHttpClient();

        URI uri = URI.create("https://v6.exchangerate-api.com/v6/482bd76f99b196223709930e/pair/"+base+"/"+target);
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();

        HttpResponse<String> response;
        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gsn = new GsonBuilder().create();

        return gsn.fromJson(response.body(), DivisaModel.class);
    }


}
