package com.kevinomyonga.kyoskbackendtest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Kevin Omyonga
 */
public class CPU {

    @JsonProperty("enabled")
    private String enabled;
    @JsonProperty("value")
    private String value;

    public CPU() {}

    public CPU(String enabled, String value) {
        super();
        this.enabled = enabled;
        this.value = value;
    }

    public String getEnabled() { return enabled; }
    public void setEnabled(String value) { this.enabled = value; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}
