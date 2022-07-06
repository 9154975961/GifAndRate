package com.example.GifAndRate.Service;

import com.example.GifAndRate.Clients.GifClient;
import com.example.GifAndRate.Clients.RatesClient;
import com.example.GifAndRate.Models.GifModel;
import com.example.GifAndRate.Models.RateModel;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RateAndGifServiceTest {

    @Autowired
    RateAndGifService rateAndGifService = new RateAndGifService();

    @Before
    public void setUp() {
        RateModel testRateModel;
        Map<String,Double> rates = new HashMap<>();
        testRateModel = new RateModel();
        testRateModel.setBase("RUB");
        testRateModel.setTimestamp(1000000);
        testRateModel.setDisclaimer("Disclaimer");
        testRateModel.setLicense("License");
        rates.put("RUB", 55.00);
        testRateModel.setRates(rates);
    }

    @Test
    public void getAllRates() {

        RateModel testRateModel;
        Map<String,Double> rates = new HashMap<>();
        testRateModel = new RateModel();
        testRateModel.setBase("RUB");
        testRateModel.setTimestamp(1000000);
        testRateModel.setDisclaimer("Disclaimer");
        testRateModel.setLicense("License");
        rates.put("RUB", 55.00);
        testRateModel.setRates(rates);

        assertEquals("{RUB=55.0}", String.valueOf(testRateModel.getRates()));
    }

    @Test
    void get_responce_to_client (){
        RatesClient testRateClient = Mockito.mock(RatesClient.class);
        when(testRateClient.getRatesClient("111111111")).thenReturn(new RateModel());

        assertNotNull(testRateClient.getRatesClient( "111111111"));
    }

    @Test
    void getLastDay() {
        RatesClient testRateClient = Mockito.mock(RatesClient.class);
        when(testRateClient.getLastRateClient("2022-01-01", "111111111")).thenReturn(new RateModel());

        assertNotNull(testRateClient.getLastRateClient("2022-01-01", "111111111"));
    }

    @Test
    void get_two_date() {
        RateModel testRateModel;
        Map<String,Double> rates = new HashMap<>();
        testRateModel = new RateModel();
        rates.put("RUB", 55.00);
        testRateModel.setRates(rates);

        RatesClient testFirstRateClient = Mockito.mock(RatesClient.class);
        when(testFirstRateClient.getLastRateClient("2022-01-01", "111111111")).thenReturn(testRateModel);

        RatesClient testSecondRateClient = Mockito.mock(RatesClient.class);
        when(testSecondRateClient.getRatesClient("111111111")).thenReturn(testRateModel);

        assertEquals(testFirstRateClient.getLastRateClient("2022-01-01", "111111111")
        ,testSecondRateClient.getRatesClient("111111111"));
    }

}