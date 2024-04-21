package com.example.divisaxchange.models;

public record DivisaModel(String result,
                          String base_code,
                          String target_code,
                          Double conversion_rate) {
}
