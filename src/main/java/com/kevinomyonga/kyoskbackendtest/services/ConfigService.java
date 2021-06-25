package com.kevinomyonga.kyoskbackendtest.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        )
    );

    /** Create */

    /**
     * Create new config entry in repo
     * @param configData : Config data to be stored
     * @return specified config
     */
    public ConfigDataModel create(ConfigDataModel configData) {
        repository.add(configData);
        return configData;
    }

    /** Read */

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
     * Fetch specific configs matching search param from repo
     * @param name : Name of config
     * @return specified config
     */
    public String search(Map<String, String> searchParam) {

        // Initialize variables
        String searchParamKey = null, searchParamValue = null, searchJsonStr = null;

        for (Map.Entry<String, String> pair : searchParam.entrySet()) {
            // Retrieve param key
            searchParamKey = pair.getKey(); 
            // Retrieve param value
            searchParamValue = pair.getValue(); 
        }

        searchJsonStr = generateNestedMap(searchParamKey, searchParamValue);

        ArrayList<ConfigDataModel> results = new ArrayList<>();

        // Iterate through the items stored in the repo
        for (ConfigDataModel configDataModel : repository) {

            String record = objectToJsonString(configDataModel);

            if(record.contains(searchJsonStr)) {
                results.add(configDataModel);
            }
        }
        return generateNestedMap(searchParamKey, searchParamValue) + "\n" + objectToJsonString(results);
    }

    /** Update */
    
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

    /** Delete */
    
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

    /**
     * Generate JSON object string
     * @param path String path to JSON key using dot notation
     * @param value Value to be set on the final JSON object key
     * @return Return the map as a JSON string
     */
    public String generateNestedMap(String path, Object value) {
        int end = path.length();
        for (int start; (start = path.lastIndexOf('.', end - 1)) != -1; end = start) {
            value = new HashMap<>(Collections.singletonMap(path.substring(start + 1, end), value));
        }
        
        Map<String, Object> map = new HashMap<>(Collections.singletonMap(path.substring(0, end), value));

        // Return the map as a JSON string
        return objectToJsonString(map);
    }

    /**
     * Convert object to JSON string
     * @param obj Object to be converted
     * @return JSON string
     */
    public String objectToJsonString(Object obj) {

        // Creating Object of ObjectMapper define in Jakson Api
        ObjectMapper mapper = new ObjectMapper();

        String jsonStr = null;
        try {
            // Get Config Data object as a json string
            jsonStr = mapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Returns the JSON string
        return jsonStr;
    }

}
