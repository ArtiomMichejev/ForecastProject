package com.example.demo.controllers;

import ch.qos.logback.core.model.Model;
import com.example.demo.models.Forecast;
import com.example.demo.repositories.ForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyForecastController {
    @Autowired
    private ForecastRepository forecastRepository;
    @GetMapping("/my-forecasts")
    public ModelAndView index(@RequestParam(required = false) String cityCode) {
        var modelAndView = new ModelAndView("myForecasts");
        var model = forecastRepository.findAll();

        modelAndView.addObject("myForecasts", model);
        return modelAndView;
    }
    @PostMapping("/my-forecasts/{id}/remove")
    public String savedForecastDelete(@PathVariable(value = "id") int id, Model model) {
        Forecast entity = forecastRepository.findById(id).orElseThrow();
        forecastRepository.delete(entity);
        return "redirect:/my-forecasts";
    }

}
