package com.kevinomyonga.kyoskbackendtest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CPU {

    private String enabled;
    private String value;

    @JsonProperty("enabled")
    public String getEnabled() { return enabled; }
    @JsonProperty("enabled")
    public void setEnabled(String value) { this.enabled = value; }

    @JsonProperty("value")
    public String getValue() { return value; }
    @JsonProperty("value")
    public void setValue(String value) { this.value = value; }
}
