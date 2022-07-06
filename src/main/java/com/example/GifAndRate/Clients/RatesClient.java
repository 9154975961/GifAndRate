package com.example.GifAndRate.Clients;

import com.example.GifAndRate.Models.RateModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value="JSONPlaceHolderClient",
        url="${rates.server}"
)
public interface RatesClient {

    @GetMapping("historical/{date}.json")
    RateModel getLastRateClient(@PathVariable String date, @RequestParam("app_id") String appId);

    @GetMapping("latest.json")
    RateModel getRatesClient(@RequestParam("app_id") String appId);

}