package com.tua.wanchalerm.config.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertySourceResponse {
    private String name;
    private Map<String, String> source;
}
