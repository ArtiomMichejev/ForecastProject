package com.example.demo.controllers;

import com.example.demo.models.Place;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

@Controller
public class ForecastController {
    @GetMapping("/")
    public ModelAndView index() throws IOException {
        var modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    private static ArrayList<Place> getCities() throws IOException {
        var cities = new ArrayList<Place>();

        var json = loadDataJson("https://api.meteo.lt/v1/places");

        ObjectMapper om = new ObjectMapper();
        Place[] places = om.readValue(json, Place[].class);

        for (var place : places) {
            var p = new Place();
            p.code = place.code;
            p.name = place.name;
            cities.add(place);
        }

        return cities;
    }

    private static String loadDataJson(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        String text = "";
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNext()) {
            text += scanner.nextLine();
        }
        scanner.close();

        return text;
    }


}
