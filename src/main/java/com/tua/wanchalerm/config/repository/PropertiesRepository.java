package com.tua.wanchalerm.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.tua.wanchalerm.config.model.Properties;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertiesRepository extends JpaRepository<Properties, Integer>, JpaSpecificationExecutor<Properties> {
    List<Properties> findByApplicationAndProfile(String application, String profile);
}