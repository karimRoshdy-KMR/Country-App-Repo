package com.app.country.dao;

import com.app.country.dto.CountryInfoDto;
import com.app.country.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    Country findCountryByCode(String code);

}
