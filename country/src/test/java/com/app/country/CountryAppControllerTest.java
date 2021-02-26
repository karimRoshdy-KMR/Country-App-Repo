package com.app.country;

import com.app.country.bus.CountryAppController;
import com.app.country.dto.CountryInfoDto;
import com.app.country.exception.CountryNotFoundException;
import com.app.country.exception.CustomizedExceptionHandler;
import com.app.country.service.CountryInfoService;
import org.hibernate.exception.JDBCConnectionException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
class CountryAppControllerTest {

   @InjectMocks
   CountryAppController countryAppController ;
   @Mock
   CountryInfoService countryInfoService;


   private MockMvc mockMvc;

   @BeforeEach
   public void setup(){
       mockMvc = MockMvcBuilders.standaloneSetup(countryAppController).setControllerAdvice(new CustomizedExceptionHandler()).build();
   }
    @Test
    void getCountryByCode() throws Exception {
       when(countryInfoService.getCountryInfo("BHR")).thenReturn(createCountryDto());
       MvcResult mvcResult = mockMvc.perform(get("/BHR")).andReturn();
       assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
       verify(countryInfoService,times(1)).getCountryInfo("BHR");
       assertFalse(mvcResult.getResponse().getContentAsString().isEmpty());
    }

    @Test
    void getCountryByCodeThrowInvalidCountryCode() throws Exception {
        when(countryInfoService.getCountryInfo("GRE")).thenThrow(new CountryNotFoundException("Invalid Country Code: GRE"));
        MvcResult mvcResult = mockMvc.perform(get("/GRE")).andReturn();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(),mvcResult.getResponse().getStatus());
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Invalid Country Code"));
    }

    @Test
    void getCountryByCodeWithDBDown() throws Exception {
        when(countryInfoService.getCountryInfo("GRE")).thenThrow(new JDBCConnectionException("DB Connection error",new SQLException()));
        MvcResult mvcResult = mockMvc.perform(get("/GRE")).andReturn();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(),mvcResult.getResponse().getStatus());
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Internal Error"));
    }

    private CountryInfoDto createCountryDto(){
       CountryInfoDto countryInfoDto  = new CountryInfoDto();
        countryInfoDto.setName("Bahrain");
        countryInfoDto.setCode("BHR");
        return  countryInfoDto;
    }
}