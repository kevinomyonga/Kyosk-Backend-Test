package com.kevinomyonga.kyoskbackendtest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Kevin Omyonga
 */
public class CPU {

    private String enabled;
    private String value;

    public CPU() {}

    public CPU(String enabled, String value) {
        super();
        this.enabled = enabled;
        this.value = value;
    }

    @JsonProperty("enabled")
    public String getEnabled() { return enabled; }
    @JsonProperty("enabled")
    public void setEnabled(String value) { this.enabled = value; }

    @JsonProperty("value")
    public String getValue() { return value; }
    @JsonProperty("value")
    public void setValue(String value) { this.value = value; }
}
