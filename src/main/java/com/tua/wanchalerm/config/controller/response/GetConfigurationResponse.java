package com.tua.wanchalerm.config.controller.response;


import lombok.Data;

import java.util.List;

@Data
public class GetConfigurationResponse {
    private List<PropertySourceResponse> propertySources;
}
