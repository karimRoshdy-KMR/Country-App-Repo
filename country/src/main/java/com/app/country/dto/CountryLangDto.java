package com.app.country.dto;

import java.math.BigDecimal;

public class CountryLangDto {
    private String language;
    private String official;

    public CountryLangDto(){}
    public CountryLangDto(String language,String official){

        this.language = language;
        this.official = official;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getOfficial() {
        return official;
    }

    public void setOfficial(String official) {
        this.official = official;
    }
}
