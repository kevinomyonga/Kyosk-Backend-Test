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
    private ArrayList<ConfigDataModel> repository = new ArrayList<>(Arrays.asList(
            configDataEntry1,
            configDataEntry2
        ));

    /**
     * Fetch all configs from repository
     * @return List of all configs
     */
    public List<ConfigDataModel> readAll() {
        return repository;
    }
    
    /**
     * Fetch specific config from repo
     * @param name : Name of config
     * @return specified config
     */
    public ConfigDataModel read(String name) {

        // Iterate through the items stored in the repo
        for (ConfigDataModel configDataModel : repository) {
            if(configDataModel.getName().contains(name)) {
                return configDataModel;
            }
        }
        return null;
    }

    /**
     * Create new config entry in repo
     * @param configData : Config data to be stored
     * @return specified config
     */
    public ConfigDataModel create(ConfigDataModel configData) {
        repository.add(configData);
        return configData;
    }
    
    /**
     * Update specific config entry in repo
     * @param name : Name  of config
     * @param configData : Data to be used to update specified record 
     * @return specified config with updated data for confirmation
     */
    public ConfigDataModel update(String name, ConfigDataModel configData) {

        // Iterate through the items stored in the repo
        for (ConfigDataModel configDataModel : repository) {
            if(configDataModel.getName().contains(name)) {
                // Get index of selected data in list
                int index = repository.indexOf(configDataModel);

                // Update the metadata
                repository.get(index).setMetadata(configData.getMetadata());
                return configData;
            }
        }
        
        return null;
    }
    
    /**
     * Delete specific config from repo
     * @param name: Name  of config
     * @return specified config
     */
    public String delete(String name) {
        // Iterate through the items stored in the repo
        for (ConfigDataModel configDataModel : repository) {
            if(configDataModel.getName().contains(name)) {
                // Remove the selected item from the list
                repository.remove(configDataModel);
                return "Deleted Config Matching: " + name;
            }
        }

        // Error response incase record not found
        return "Record Not Found";
    }

}
