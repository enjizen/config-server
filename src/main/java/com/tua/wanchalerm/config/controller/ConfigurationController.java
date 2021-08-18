package com.tua.wanchalerm.config.controller;

import com.tua.wanchalerm.config.controller.response.GetConfigurationResponse;
import com.tua.wanchalerm.config.controller.response.PropertySourceResponse;
import com.tua.wanchalerm.config.model.Properties;
import com.tua.wanchalerm.config.service.ConfigurationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ConfigurationController {

    private final ConfigurationService configurationService;

    @GetMapping("/ssw/{application}/{profile}")
    public ResponseEntity<Object> getConfiguration(@PathVariable("application") String application, @PathVariable("profile") String profile) {
        log.info("======== Start get configuration ===========");
        Map<String ,String> configurationMap = new HashMap<>();
        List<PropertySourceResponse> propertySourceResponseList = new ArrayList<>();
        List<Properties> propertiesList = configurationService.getProperties(application, profile);
        propertiesList.forEach(properties -> configurationMap.put(properties.getKey(), properties.getValue()));

        PropertySourceResponse propertySourceResponse = new PropertySourceResponse(application + ".properties", configurationMap);
        propertySourceResponseList.add(propertySourceResponse);
        GetConfigurationResponse getConfigurationResponse = new GetConfigurationResponse();
        getConfigurationResponse.setPropertySources(propertySourceResponseList);

        log.info("=============== End get configuration  ==============================");
        return ResponseEntity.ok(getConfigurationResponse);
    }
}
