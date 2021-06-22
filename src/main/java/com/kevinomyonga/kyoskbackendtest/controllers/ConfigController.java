package com.kevinomyonga.kyoskbackendtest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    
    @GetMapping
    public String listConfigs() {
        return "List Configs";
    }
    
    @PostMapping("/")
    public String createConfigs(@RequestBody String param) {
        return "Added Configs";
    }
    
    @GetMapping("/{name}")
    public String getConfigs(@PathVariable String name) {
        return "List Configs Matching: " + name;
    }

    @PutMapping("/{name}")
    public String updateConfigs(@PathVariable String name, @RequestBody String param) {
        return "Updated Configs Matching: " + name;
    }

    @DeleteMapping("/{name}")
    public String deleteConfigs(@PathVariable String name) {
        return "Deleted Configs Matching: " + name;
    }
    
}
