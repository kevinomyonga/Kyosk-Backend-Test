package com.kevinomyonga.kyoskbackendtest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Kevin Omyonga
 */
public class Limits {

    private CPU cpu;

    public Limits() {}

    public Limits(CPU cpu) {
        super();
        this.cpu = cpu;
    }

    @JsonProperty("cpu")
    public CPU getCPU() { return cpu; }
    @JsonProperty("cpu")
    public void setCPU(CPU value) { this.cpu = value; }
}
