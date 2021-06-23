package com.kevinomyonga.kyoskbackendtest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Kevin Omyonga
 */
public class Limits {

    @JsonProperty("cpu")
    private CPU cpu;

    public Limits() {}

    public Limits(CPU cpu) {
        super();
        this.cpu = cpu;
    }

    public CPU getCPU() { return cpu; }
    public void setCPU(CPU value) { this.cpu = value; }
}
