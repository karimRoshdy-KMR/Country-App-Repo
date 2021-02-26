package com.app.country.dao;

import com.app.country.entity.City;
import com.app.country.entity.CountryLanguage;
import com.app.country.entity.CountryLanguageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageId> {
}
