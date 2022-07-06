package com.example.GifAndRate.Controller;

import com.example.GifAndRate.Service.RateAndGifService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class RateAndGifController {

    private final RateAndGifService rateAndGifService;
    @Value("${rates.baseCurrency}")
    String baseCurrency;

    @GetMapping("")
    public String getEqualsRates(){return rateAndGifService.getLastDay(baseCurrency);}

    @GetMapping("rates")
    public String getAllRates(){
        return rateAndGifService.getAllRates();
    }

    @GetMapping("rates/{currency}")
    public String getCurrency(@PathVariable String currency) {return rateAndGifService.getCurrency(currency);}




}
