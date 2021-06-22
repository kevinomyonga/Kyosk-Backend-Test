package com.kevinomyonga.kyoskbackendtest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Limits {

    private CPU cpu;

    @JsonProperty("cpu")
    public CPU getCPU() { return cpu; }
    @JsonProperty("cpu")
    public void setCPU(CPU value) { this.cpu = value; }
}
