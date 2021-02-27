package com.app.country.service;

import com.app.country.dao.CityRepository;
import com.app.country.dao.CountryLanguageRepository;
import com.app.country.dao.CountryRepository;
import com.app.country.dto.CountryInfoDto;
import com.app.country.dto.CountryLangDto;
import com.app.country.entity.City;
import com.app.country.entity.Country;
import com.app.country.entity.CountryLanguage;
import com.app.country.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CountryInfoService {
    @Autowired
    private  CountryRepository countryRepository;

    public CountryInfoDto getCountryInfo(String countryCode){
        //get Country By Code
        Country country = countryRepository.findCountryByCode(countryCode);
        //Check If Country Not Exist
        if(country ==null)
            throw new CountryNotFoundException("Invalid Country Code: " + countryCode);
      return getCountryInfoDtoFromEntity(country);
    }

    private  CountryInfoDto  getCountryInfoDtoFromEntity(Country country){
        //construct CountryInfoDto Object
        CountryInfoDto countryInfoDto = new CountryInfoDto();
        countryInfoDto.setCode(country.getCode());
        countryInfoDto.setName(country.getName());
        countryInfoDto.setContinent(country.getContinent());
        countryInfoDto.setLifeExpectancy(country.getLifeExpectancy());
        countryInfoDto.setPopulation(country.getPopulation());
        countryInfoDto.setRegion(country.getRegion());
        countryInfoDto.setSurfaceArea(country.getSurfaceArea());

        List<CountryLangDto> countryLangDtos = new ArrayList<>();
        if (country.getCountryLanguage() != null) {
            for (CountryLanguage countryLanguage : country.getCountryLanguage()) {
                CountryLangDto dto = new CountryLangDto();
                dto.setLanguage(countryLanguage.getCountryLanguageId().getLanguage());
                dto.setOfficial(countryLanguage.getOfficial() ? "Yes" : "No");
                countryLangDtos.add(dto);
            }
            // set Country Languages in Country Info
            countryInfoDto.setCountryLanguages(countryLangDtos);
        }
        return countryInfoDto;
    }


}
