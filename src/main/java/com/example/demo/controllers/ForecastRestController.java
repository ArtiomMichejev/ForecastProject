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

       Forecast entity = new Forecast(
               model.date,
               String.valueOf(model.temperature),
               model.city,
               1);
       forecastRepository.save(entity);

   }

}
