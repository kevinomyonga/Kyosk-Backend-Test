package com.kevinomyonga.kyoskbackendtest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Kevin Omyonga
 */
public class Monitoring {

    @JsonProperty("enabled")
    private String enabled;

    public Monitoring() {}

    public Monitoring(String enabled) {
        super();
        this.enabled = enabled;
    }

    public String getEnabled() { return enabled; }
    public void setEnabled(String value) { this.enabled = value; }
}
