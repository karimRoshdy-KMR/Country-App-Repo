package com.app.country.bus;

import com.app.country.dto.CountryInfoDto;
import com.app.country.exception.CountryNotFoundException;
import com.app.country.dao.CountryRepository;
import com.app.country.entity.Country;
import com.app.country.service.CountryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CountryAppController {

    @Autowired
    CountryInfoService countryInfoService;

    @GetMapping("/{code}")
    public ResponseEntity<CountryInfoDto> getCountryByCode(@PathVariable(value = "code") String countryCode) throws CountryNotFoundException {
        CountryInfoDto CountryInfoDto = countryInfoService.getCountryInfo(countryCode);
        return ResponseEntity.ok().body(CountryInfoDto);

    }

}
