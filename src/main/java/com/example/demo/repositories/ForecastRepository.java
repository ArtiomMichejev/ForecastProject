package com.example.demo.repositories;

import com.example.demo.models.Forecast;
import org.springframework.data.repository.CrudRepository;
public interface ForecastRepository extends CrudRepository<Forecast, Integer> {

}

