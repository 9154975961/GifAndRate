package com.example.GifAndRate.Clients;

import com.example.GifAndRate.Models.GifModel;
import com.example.GifAndRate.Models.RateModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        value="GifClient",
        url="${giphy.server}"
)
public interface GifClient {

    @GetMapping("?api_key={apiKey}&q={item}&limit=1&offset={rates}&bundle=messaging_non_clips")
    GifModel getGif(@PathVariable String apiKey, @PathVariable int item, @PathVariable String rates);

}
