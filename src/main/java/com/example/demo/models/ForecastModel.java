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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
