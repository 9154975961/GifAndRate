package com.example.GifAndRate.Models;

import lombok.Data;

import java.util.Map;

@Data
public class GifModel {

    private Map[] data;
    private Map pagination;
    private Map meta;
}
