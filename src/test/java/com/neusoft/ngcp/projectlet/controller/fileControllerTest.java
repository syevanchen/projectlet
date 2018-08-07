package com.neusoft.ngcp.projectlet.controller;

import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class fileControllerTest extends ControllerTest {

    private String urlStart = "/api/v1/file/person";

    @Test
    public void getPersonPhoto() throws Exception{
        String getUrl = urlStart + "/photo?type=1&no="+ this.person_id;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("image/jpeg"));
    }


}