package com.kevinomyonga.kyoskbackendtest.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.kevinomyonga.kyoskbackendtest.models.CPU;
import com.kevinomyonga.kyoskbackendtest.models.ConfigDataModel;
import com.kevinomyonga.kyoskbackendtest.models.Limits;
import com.kevinomyonga.kyoskbackendtest.models.Metadata;
import com.kevinomyonga.kyoskbackendtest.models.Monitoring;

import org.springframework.stereotype.Service;

/**
 * @author Kevin Omyonga
 */
@Service
public class ConfigService {

    // Initialize test data
    private ConfigDataModel configDataEntry1 = new ConfigDataModel(
        "datacenter-1", 
        new Metadata(
            new Monitoring("true"), 
            new Limits(
                new CPU("false", "300m")
            )
        )
    );
    private ConfigDataModel configDataEntry2 = new ConfigDataModel(
        "datacenter-2", 
        new Metadata(
            new Monitoring("true"), 
            new Limits(
                new CPU("true", "250m")
            )
        )
    );
    
    // Repository to mock DB and store test and user defined data
    private List<ConfigDataModel> repository = Arrays.asList(
        new ConfigDataModel[]{
            configDataEntry1,
            configDataEntry2,
        });

    public List<ConfigDataModel> readAll() {
        return repository;
    }
    
    public ConfigDataModel read(String name) {

        ConfigDataModel result = null;

        for (ConfigDataModel configDataModel : repository) {
            if(configDataModel.getName() == name) {
                result = configDataModel;
            }
        }
        return result;
    }

    public ConfigDataModel create(ConfigDataModel configData) {
        repository.add(configData);
        return configData;
    }
    
    public ConfigDataModel update(String name, ConfigDataModel configData) {
        for (ConfigDataModel configDataModel : repository) {
            if(configDataModel.getName() == name) {
                repository.add(configData);
            }
        }
        
        return configData;
    }
    
    public void delete(String name) {
        for (ConfigDataModel configDataModel : repository) {
            if(configDataModel.getName() == name) {
                repository.remove(configDataModel);
                return;
            }
        }
    }

}
