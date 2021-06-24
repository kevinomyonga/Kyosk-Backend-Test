package com.kevinomyonga.kyoskbackendtest.controllers;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

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
public class ConfigController {

    @Autowired
    private ConfigService service;
    
    /** Create */

    @ApiOperation(value = "Create new config entry")
    @PostMapping(value = "/configs", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createConfigs(@RequestBody  ConfigDataModel configData) {

        ConfigDataModel createdConfig = service.create(configData);
        if (createdConfig == null) {
            return "Config Record Not Found";
        } else {
            return service.objectToJsonString(createdConfig);
        }
    }

    /** Read */
    
    @ApiOperation(value = "Retrieve all config entries")
    @GetMapping(value = "/configs", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ConfigDataModel> listConfigs() {
        return service.readAll();
    }
    
    @ApiOperation(value = "Retrieve specific config entry")
    @GetMapping(value = "/configs/{name}")
    public String getConfigs(@PathVariable String name) {

        ConfigDataModel foundConfig = service.read(name);
        return service.objectToJsonString(foundConfig);
    }

    @ApiOperation(value = "Retrieve specific config entry by search query")
    @GetMapping(value = "/search")
    public String searchConfigs(@RequestParam Map<String, String> searchParam) {

        String searchResults = service.search(searchParam);
        return searchResults;
    }

    /** Update */

    @ApiOperation(value = "Update specific config entry")
    @PutMapping(value = "/configs/{name}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateConfigs(@PathVariable String name, @RequestBody ConfigDataModel configData) {

        ConfigDataModel updatedConfig = service.update(name, configData);
        if (updatedConfig == null) {
            return "Config Record Not Found";
        } else {
            return service.objectToJsonString(updatedConfig);
        }
    }

    /** Delete */

    @ApiOperation(value = "Delete specific config entry")
    @DeleteMapping("/configs/{name}")
    public String deleteConfigs(@PathVariable String name) {
        return service.delete(name);
    }
    
}
