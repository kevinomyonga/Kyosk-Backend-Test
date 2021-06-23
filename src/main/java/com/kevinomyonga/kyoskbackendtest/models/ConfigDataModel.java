package com.kevinomyonga.kyoskbackendtest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Kevin Omyonga
 */
public class ConfigDataModel {
    
    @JsonProperty("name")
    private String name;
    @JsonProperty("metadata")
    private Metadata metadata;

    public ConfigDataModel() {}

    public ConfigDataModel(String name, Metadata metadata) {
        super();
        this.name = name;
        this.metadata = metadata;
    }

    
    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public Metadata getMetadata() { return metadata; }
    public void setMetadata(Metadata value) { this.metadata = value; }
}
