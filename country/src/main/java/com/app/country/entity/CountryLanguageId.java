package com.app.country.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CountryLanguageId implements Serializable {

    @Column(nullable = false)
    private String countryCode;

    @Column(nullable = false)
    private String language;

    public CountryLanguageId(){
    }

    public CountryLanguageId(String countryCode ,String language){
        this.countryCode = countryCode;
        this.language = language;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "CountryLanguageId{" +
                "countryCode='" + countryCode + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryLanguageId that = (CountryLanguageId) o;
        return countryCode.equals(that.countryCode) &&
                language.equals(that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, language);
    }
}
