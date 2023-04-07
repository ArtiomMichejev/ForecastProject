package com.example.demo.controllers;

import com.example.demo.models.Forecast;
import com.example.demo.models.ForecastModel;
import com.example.demo.repositories.ForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ForecastRestController {
   @Autowired
    private ForecastRepository forecastRepository;

   @PostMapping(value = "/api/forecast", consumes = "application/json")
    public void index(@RequestBody ForecastModel model) {

       String str = "";
       String firstLetter = model.city.substring(0,1).toUpperCase();
       String endOfAString = model.city.substring(1);
       str = firstLetter + endOfAString;

       Forecast entity = new Forecast(
               model.date,
               String.valueOf(model.temperature),
               str,
               1);
       forecastRepository.save(entity);

   }

}
