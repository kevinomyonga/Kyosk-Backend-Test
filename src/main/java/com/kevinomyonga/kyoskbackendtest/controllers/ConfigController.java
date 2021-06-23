package com.kevinomyonga.kyoskbackendtest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevinomyonga.kyoskbackendtest.models.ConfigDataModel;
import com.kevinomyonga.kyoskbackendtest.services.ConfigService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Kevin Omyonga
 */
@RestController
@RequestMapping("/configs")
public class ConfigController {

    @Autowired
    private ConfigService service;
    
    @GetMapping
    public List<ConfigDataModel> listConfigs() {
        return service.readAll();
    }
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createConfigs(@RequestBody  ConfigDataModel configData) {

        ConfigDataModel createdConfig = service.create(configData);
        if (createdConfig == null) {
            return "Config Record Not Found";
        } else {
            return objectToJsonString(createdConfig);
        }
    }
    
    @GetMapping(value = "/{name}")
    public String getConfigs(@PathVariable String name) {

        ConfigDataModel foundConfig = service.read(name);
        return objectToJsonString(foundConfig);
    }

    @PutMapping(value = "/{name}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateConfigs(@PathVariable String name, @RequestBody ConfigDataModel configData) {

        ConfigDataModel updatedConfig = service.update(name, configData);
        if (updatedConfig == null) {
            return "Config Record Not Found";
        } else {
            return objectToJsonString(updatedConfig);
        }
    }

    @DeleteMapping("/{name}")
    public String deleteConfigs(@PathVariable String name) {
        return service.delete(name);
    }

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

        return jsonStr;
    }
    
}
