package com.app.country.dto;

import java.math.BigDecimal;

public class CapitalDto {
    private String name;
    private Integer population;


    public CapitalDto(String name, Integer population) {

        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}


