package com.app.country.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "country_language")
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguageId countryLanguageId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId("countryCode")
    @JoinColumn(name = "country_code")
    private Country country;

    @Column(nullable = false)
    private BigDecimal  percentage;

    @Column(nullable = false)
    @Type(type="true_false")
    private Boolean isOfficial;


    public CountryLanguage(){

    }

    public CountryLanguageId getCountryLanguageId() {
        return countryLanguageId;
    }

    public void setCountryLanguageId(CountryLanguageId countryLanguageId) {
        this.countryLanguageId = countryLanguageId;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public Boolean getOfficial() {
        return isOfficial;
    }

    public void setOfficial(Boolean official) {
        isOfficial = official;
    }
}
