package com.example.GifAndRate.Service;


import com.example.GifAndRate.Clients.GifClient;
import com.example.GifAndRate.Clients.RatesClient;
import com.example.GifAndRate.Models.GifModel;
import com.example.GifAndRate.Models.RateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RateAndGifService {

    @Autowired
    public RatesClient ratesClient;

    @Autowired
    public GifClient gifClient;

    @Value("${rates.app_key}")
    private String rateAppId;
    @Value("${giphy.app_key}")
    private String gifAppId;

    private String gifGoodAnswer = "rich";
    private String gifBadAnswer = "broke";

    final long LAST_DAY = 1000*60*60*24;

    public String getLastDay(String currency){
        Date lastDate = new Date(System.currentTimeMillis()-LAST_DAY);
        String date = new SimpleDateFormat("yyyy-MM-dd").format(lastDate);
        RateModel responseLast = ratesClient.getLastRateClient(date, rateAppId);
        RateModel responseNow = ratesClient.getRatesClient(rateAppId);
        Double lastRub = responseLast.getRates().get(currency);
        Double nowRub = responseNow.getRates().get(currency);
        if (nowRub>lastRub){
            return getGif(gifGoodAnswer);
        } else {
            return getGif(gifBadAnswer);
        }
    }

    public String getAllRates(){

        RateModel responce = ratesClient.getRatesClient(rateAppId);
        String allRates = String.valueOf(responce.getRates());

        return allRates;
    }

    public String getGif(String answer){
        GifModel responce = gifClient.getGif(gifAppId, new Random().nextInt(1000), answer);
        Map[] buffer = responce.getData();
        Map buf = new HashMap((Map) buffer[0].get("images"));
        buf = (Map) buf.get("original");
        String url = String.valueOf(buf.get("url"));

        String gif = "<html><head><title>"+ answer +"</title></head><body><img src=\"" + url
                + "\"></body></html>";
        return gif;
    }

    public String getCurrency(String currency) {
        return getLastDay(currency.toUpperCase());
    }
}
