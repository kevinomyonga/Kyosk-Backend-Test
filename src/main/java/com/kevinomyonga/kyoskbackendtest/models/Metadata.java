package com.kevinomyonga.kyoskbackendtest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Kevin Omyonga
 */
public class Metadata {

    @JsonProperty("monitoring")
    private Monitoring monitoring;
    @JsonProperty("limits")
    private Limits limits;

    public Metadata() {}

    public Metadata(Monitoring monitoring, Limits limits) {
        super();
        this.monitoring = monitoring;
        this.limits = limits;
    }

    public Monitoring getMonitoring() { return monitoring; }
    public void setMonitoring(Monitoring value) { this.monitoring = value; }

    public Limits getLimits() { return limits; }
    public void setLimits(Limits value) { this.limits = value; }
}
