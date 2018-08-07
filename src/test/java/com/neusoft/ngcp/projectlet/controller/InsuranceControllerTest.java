package com.neusoft.ngcp.projectlet.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;

public class InsuranceControllerTest extends ControllerTest {

    private String urlStart = "/api/v1/insurance/person";

    @Test
    public void getInsurants() throws Exception{
        String getUrl = urlStart + "/insurant?type=1&no="+ this.person_id;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getAllInsurants() throws Exception{
        String getUrl = urlStart + "/insurants?type=1&no="+ this.person_id;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getBalance() throws Exception{
        String getUrl = urlStart + "/balance?type=1&no="+ this.person_id;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getPayJournal() throws Exception{
        String getUrl = urlStart + "/pay-journal?type=1&no="+ this.person_id;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getPayDetail() throws Exception {
        String getUrl = urlStart + "/pay-detail?type=1&no=" + this.person_id
                + "&region=" + this.region_no
                + "&hos=" + this.hospital_no
                + "&vno=" + this.visit_no;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getPayDetail1() throws Exception {
        String getUrl = urlStart + "/pay-detail?type=1&no=210106195010252144"
                + "&region=" + this.region_no
                + "&hos=2648"
                + "&vno=ZY010000025896";
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getVisitPayJournal() throws Exception {
        String getUrl = urlStart + "/visit-pay-journal?type=1&no=" + this.person_id
                + "&region=" + this.region_no
                + "&hos=" + this.hospital_no
                + "&vno=" + this.visit_no;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getVisitPayJournal1() throws Exception {
        String getUrl = urlStart + "/visit-pay-journal?type=1&no=210106195010252144"
                + "&region=" + this.region_no
                + "&hos=2648"
                + "&vno=ZY010000025896";
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getPersonInfo() throws Exception {
        String getUrl = urlStart + "/info?type=1&no=" + this.insurance_id
                + "&region=" + this.region_no;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }
}