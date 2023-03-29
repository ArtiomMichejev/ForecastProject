package com.example.demo.models;

public class ForecastModel {
    public String city;
    public String date;
    public double temperature;

    public ForecastModel(String city, String date, double temperature) {
        this.city = city;
        this.date = date;
        this.temperature = temperature;
    }
}
