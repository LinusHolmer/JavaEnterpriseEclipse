package com.example.demo.weather.domain;

import java.util.ArrayList;

public class Hourly {
    private ArrayList<String> time;
    private ArrayList<Double> temperature_2m ;

    public ArrayList<String> getTime() {
        return time;
    }

    public void setTime(ArrayList<String> time) {
        this.time = time;
    }

    public ArrayList<Double> getTemperature_2m() {
        return temperature_2m;
    }

    public void setTemperature_2m(ArrayList<Double> temperature_2m) {
        this.temperature_2m = temperature_2m;
    }
}
