package com.tua.wanchalerm.config.service;

import com.tua.wanchalerm.config.model.Properties;
import com.tua.wanchalerm.config.repository.PropertiesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConfigurationService {

    private  final PropertiesRepository propertiesRepository;

    public List<Properties> getProperties(String application, String profile) {
        log.info("Get properties by [{}] application and [{}] profile", application, profile);
        return propertiesRepository.findByApplicationAndProfile(application, profile);
    }
}
