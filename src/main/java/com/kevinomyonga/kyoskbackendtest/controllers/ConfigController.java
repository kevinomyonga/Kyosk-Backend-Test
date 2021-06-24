package com.kevinomyonga.kyoskbackendtest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
    
    /** Create */

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createConfigs(@RequestBody  ConfigDataModel configData) {

        ConfigDataModel createdConfig = service.create(configData);
        if (createdConfig == null) {
            return "Config Record Not Found";
        } else {
            return service.objectToJsonString(createdConfig);
        }
    }

    /** Read */
    
    @GetMapping
    public List<ConfigDataModel> listConfigs() {
        return service.readAll();
    }
    
    @GetMapping(value = "/{name}")
    public String getConfigs(@PathVariable String name) {

        ConfigDataModel foundConfig = service.read(name);
        return service.objectToJsonString(foundConfig);
    }

    @GetMapping(value = "/search")
    public String searchConfigs(@RequestParam Map<String, String> searchParam) {

        String searchResults = service.search(searchParam);
        return searchResults;
    }

    /** Update */

    @PutMapping(value = "/{name}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateConfigs(@PathVariable String name, @RequestBody ConfigDataModel configData) {

        ConfigDataModel updatedConfig = service.update(name, configData);
        if (updatedConfig == null) {
            return "Config Record Not Found";
        } else {
            return service.objectToJsonString(updatedConfig);
        }
    }

    /** Delete */

    @DeleteMapping("/{name}")
    public String deleteConfigs(@PathVariable String name) {
        return service.delete(name);
    }
    
}
