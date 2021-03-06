package com.example.GifAndRate.Models;

import lombok.Data;
import java.util.Map;

@Data
public class RateModel {

        private String disclaimer;
        private String license;
        private Integer timestamp;
        private String base;
        private Map<String, Double> rates;
}
