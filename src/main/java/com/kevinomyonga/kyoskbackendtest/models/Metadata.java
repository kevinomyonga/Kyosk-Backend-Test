package com.kevinomyonga.kyoskbackendtest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Metadata {

    private Monitoring monitoring;
    private Limits limits;

    @JsonProperty("monitoring")
    public Monitoring getMonitoring() { return monitoring; }
    @JsonProperty("monitoring")
    public void setMonitoring(Monitoring value) { this.monitoring = value; }

    @JsonProperty("limits")
    public Limits getLimits() { return limits; }
    @JsonProperty("limits")
    public void setLimits(Limits value) { this.limits = value; }
}
