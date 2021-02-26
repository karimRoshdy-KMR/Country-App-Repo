package com.app.country.entity;

import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "country")
@Check(constraints ="continent IN ('Asia','Europe','North America','Africa','Oceania','Antarctica','South America')")
public class Country {

    @Id
    @Column( nullable = false, unique = true, length = 3)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String continent;

    @Column( nullable = false)
    private String region;

    @Column(nullable = false)
    private BigDecimal surfaceArea;

    @Column(nullable = true)
    private Short indepYear;

    @Column(nullable = false)
    private Integer population;

    @Column(nullable = true)
    private BigDecimal lifeExpectancy;

    @Column(nullable = true)
    private Float gnp;

    @Column(nullable = true)
    private Float gnpOld;

    @Column(nullable = false)
    private String localName;

    @Column(nullable = false)
    private String governmentForm;

    @Column(nullable = true)
    private String headOfState;

    @Column
    private Integer capital;

    @OneToMany(mappedBy = "country")
    private List<CountryLanguage> countryLanguage;

    @Column(nullable = false, unique = true, length = 2)
    private String code2;
    
    public Country() {
        super();

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

    public Short getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(Short indepYear) {
        this.indepYear = indepYear;
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

    public Float getGnp() {
        return gnp;
    }

    public void setGnp(Float gnp) {
        this.gnp = gnp;
    }

    public Float getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(Float gnpOld) {
        this.gnpOld = gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public Integer getCapital() {
        return capital;
    }

    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    public List<CountryLanguage> getCountryLanguage() {
        return countryLanguage;
    }

    public void setCountryLanguage(List<CountryLanguage> countryLanguage) {
        this.countryLanguage = countryLanguage;
    }

    public String getcode2() {
        return code2;
    }

    public void setcode2(String codeTwo) {
        this.code2 = codeTwo;
    }

}
