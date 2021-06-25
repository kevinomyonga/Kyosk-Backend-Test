package com.kevinomyonga.kyoskbackendtest.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevinomyonga.kyoskbackendtest.models.CPU;
import com.kevinomyonga.kyoskbackendtest.models.ConfigDataModel;
import com.kevinomyonga.kyoskbackendtest.models.Limits;
import com.kevinomyonga.kyoskbackendtest.models.Metadata;
import com.kevinomyonga.kyoskbackendtest.models.Monitoring;

@SpringBootTest
@AutoConfigureMockMvc
public class ConfigControllerIntegrationTests {

    // Initialize variables
    private static final String URL_PATH = "/configs/";
    private static final String PARAM_CONFIG_NAME = "datacenter-1";
    
    @Autowired
    private MockMvc mockMvc;

    /** Create */

    @Test
    public void whenCreate_thenStatusIsCreated() throws Exception {

        ConfigDataModel configDataEntry = new ConfigDataModel(
            "datacenter-3", 
            new Metadata(
                new Monitoring("false"), 
                new Limits(
                    new CPU("false", "300m")
                )
            )
        );

        this.mockMvc.perform(post(URL_PATH).content(asJsonString(configDataEntry))
            .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isCreated());
    }

    /** Read */

    @Test
    public void whenReadAll_thenStatusIsOk() throws Exception {
        this.mockMvc.perform(get(URL_PATH))
            .andExpect(status().isOk());
    }

    @Test
    public void whenReadOne_thenStatusIsOk() throws Exception {
        this.mockMvc.perform(get(URL_PATH + PARAM_CONFIG_NAME))
            .andExpect(status().isOk());
    }

    /** Update */

    @Test
    public void whenUpdate_thenStatusIsOk() throws Exception {

        ConfigDataModel configDataEntry = new ConfigDataModel(
            "datacenter-1", 
            new Metadata(
                new Monitoring("true"), 
                new Limits(
                    new CPU("false", "700m")
                )
            )
        );

        this.mockMvc.perform(put(URL_PATH + PARAM_CONFIG_NAME)
            .content(asJsonString(configDataEntry))
            .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk());
    }

    /** Delete */
    
    @Test
    public void whenDelete_thenStatusIsOk() throws Exception {
        this.mockMvc.perform(delete(URL_PATH + PARAM_CONFIG_NAME))
            .andExpect(status().isOk());
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
