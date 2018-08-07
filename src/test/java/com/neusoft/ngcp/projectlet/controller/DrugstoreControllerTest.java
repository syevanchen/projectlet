package com.neusoft.ngcp.projectlet.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;

public class DrugstoreControllerTest extends ControllerTest{


    private String urlStart = "/api/v1/store/person";

    @Test
    public void getDrugRecordDetails() throws Exception{
        String getUrl =  urlStart + "/drugs?type=1&no="+ "21010319620415242X";
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getDrugRecords() throws Exception{
        String getUrl =  urlStart + "/drugRecords?type=1&no="+ "21010319620415242X";
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }
}