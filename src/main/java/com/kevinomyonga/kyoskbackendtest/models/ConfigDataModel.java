package com.kevinomyonga.kyoskbackendtest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Kevin Omyonga
 */
public class ConfigDataModel {
    
    private String name;
    private Metadata metadata;

    public ConfigDataModel() {}

    public ConfigDataModel(String name, Metadata metadata) {
        super();
        this.name = name;
        this.metadata = metadata;
    }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("metadata")
    public Metadata getMetadata() { return metadata; }
    @JsonProperty("metadata")
    public void setMetadata(Metadata value) { this.metadata = value; }
}
