package com.kevinomyonga.kyoskbackendtest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Monitoring {

    private String enabled;

    @JsonProperty("enabled")
    public String getEnabled() { return enabled; }
    @JsonProperty("enabled")
    public void setEnabled(String value) { this.enabled = value; }
}
