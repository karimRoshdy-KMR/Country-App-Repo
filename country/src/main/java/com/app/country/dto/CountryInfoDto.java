package com.app.country.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

public class CountryInfoDto {
    private String code;
    private String name;
    private String continent;
    private String region;
    private BigDecimal surfaceArea;
    private Integer population;
    private BigDecimal lifeExpectancy;
    private List<CountryLangDto> countryLanguages;

    public CountryInfoDto(){

    }

    public CountryInfoDto(String code,String name,String continent, String region, BigDecimal surfaceArea,Integer population, BigDecimal lifeExpectancy,List<CountryLangDto> countryLanguages){
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.countryLanguages = countryLanguages;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public BigDecimal getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(BigDecimal surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }


    public BigDecimal getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(BigDecimal lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public List<CountryLangDto> getCountryLanguages() {
        return countryLanguages;
    }

    public void setCountryLanguages(List<CountryLangDto> countryLanguages) {
        this.countryLanguages = countryLanguages;
    }
}
