package com.example.entities;

import java.util.List;

public class Condiment {
    private List<String> condiments;

    public Condiment() {
    }

    public Condiment(List<String> condiments) {
        this.condiments = condiments;
    }

    public List<String> getCondiments() {
        return condiments;
    }

    public void setCondiments(List<String> condiments) {
        this.condiments = condiments;
    }
}
