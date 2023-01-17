package ru.netology;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println(" ");
        List<Response> responsesList = jsonToList(getResponse());
        responsesList.stream()
                .filter(value -> value.getUpvotes() != null && new Integer(value.getUpvotes()) > 0)
                .forEach(System.out::println);

    }
    static String getResponse(){
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();
        HttpGet request = new HttpGet(
                "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats");
        try {
            CloseableHttpResponse response = httpClient.execute(request);
            String body = new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);
            System.out.println(body);
            return body;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Response> jsonToList(String json) {
        JSONParser parser = new JSONParser();
        Gson gson = new GsonBuilder().create();
        List <Response> list = new ArrayList<>();
        try {
            JSONArray array = (JSONArray) parser.parse(json);
            for (int i = 0; i < array.size(); i++) {
                list.add(gson.fromJson(String.valueOf(array.get(i)), Response.class));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}