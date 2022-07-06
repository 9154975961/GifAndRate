package com.example.GifAndRate.Controller;

import com.example.GifAndRate.Clients.GifClient;
import com.example.GifAndRate.Clients.RatesClient;
import com.example.GifAndRate.Models.GifModel;
import com.example.GifAndRate.Models.RateModel;
import com.example.GifAndRate.Service.RateAndGifService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class RateAndGifControllerTest {

    @Autowired
    RateAndGifController testRateAndGifController;

    @MockBean
    RatesClient testRateClient;

    @MockBean
    GifClient testGifClient;

    @Value("${test.gif}")
    String reee;

    @Test
    void getRates_from_Map() {

        RateModel testRateModel;
        Map<String,Double> rates = new HashMap<>();
        testRateModel = new RateModel();
        rates.put("RUB", 55.00);
        testRateModel.setRates(rates);

        assertEquals("{RUB=55.0}", String.valueOf(testRateModel.getRates()));
    }

    @Test
    public void getRates_real_rates(){

        RateModel testRateModel;
        Map<String,Double> rates = new HashMap<>();
        testRateModel = new RateModel();
        rates.put("RUB", 55.00);
        testRateModel.setRates(rates);

        when(testRateClient.getRatesClient(anyString())).thenReturn(testRateModel);

        assertEquals("{RUB=55.0}", testRateAndGifController.getAllRates());
    }

    @Test
    void getEqalsRates_get_answer_test() {
        RateModel firstTestRateModel;
        Map<String,Double> firstRates = new HashMap<>();
        firstTestRateModel = new RateModel();
        firstRates.put("RUB", 55.00);
        firstTestRateModel.setRates(firstRates);

        RateModel secondTestRateModel;
        Map<String,Double> secondRates = new HashMap<>();
        secondTestRateModel = new RateModel();
        secondRates.put("RUB", 54.00);
        secondTestRateModel.setRates(secondRates);

        GifModel firstTestGifModel = new GifModel();
        Map[] data = new Map[1];

        Map<String,Map<String, Map<String,String>>> testData = new HashMap<>();
        testData.put("images",Map.of("original",Map.of("url","test")));
        data[0] = testData;
        firstTestGifModel.setData(data);

        when(testRateClient.getRatesClient(anyString())).thenReturn(firstTestRateModel);
        when(testRateClient.getLastRateClient(anyString(), anyString())).thenReturn(secondTestRateModel);

        when(testGifClient.getGif(anyString(),anyInt(),anyString())).thenReturn(firstTestGifModel);

        assertEquals(reee, testRateAndGifController.getEqualsRates());

    }
}