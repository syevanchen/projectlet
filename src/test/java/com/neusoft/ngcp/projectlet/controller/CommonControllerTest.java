package com.neusoft.ngcp.projectlet.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CommonControllerTest extends ControllerTest{

    private String urlStart = "/api/v1/common/person";

    @Autowired
    JdbcTemplate hiveJdbcTemplate;


    @Test
    public void getPersonInfo() throws Exception{
        String getUrl = urlStart + "/info?type=1&no=" + this.person_id;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getContacts() throws Exception{
        String getUrl =  urlStart + "/contacts?type=1&no="+ this.person_id;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getContactsWith_() throws Exception{
        String getUrl =  urlStart + "/contacts?type=1&no="+ "210411198804232920";
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getTelephone() throws Exception{
        String getUrl =  urlStart + "/telephone?type=1&no="+ this.person_id;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }


    @Test
    public void searchPersonInfosByPageIdNo() throws Exception{

        String getUrl =  urlStart + "/search-persons";
        this.mockMvc.perform(
                post(getUrl)
                .param("id_no","210105196501192287")
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andDo(print());
    }

    @Test
    public void searchPersonInfosByPageTel() throws Exception{

        String getUrl =  urlStart + "/search-persons";
        this.mockMvc.perform(
                post(getUrl)
                        .param("telephone","188"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andDo(print());

    }

    @Test
    public void searchPersonInfosByPageName() throws Exception{

        String getUrl =  urlStart + "/search-persons";
        this.mockMvc.perform(
                post(getUrl)
                        .param("name","任丽")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andDo(print());

    }

    @Test
    public void searchPersonInfosByPageNameSex() throws Exception{

        String getUrl =  urlStart + "/search-persons";
        this.mockMvc.perform(
                post(getUrl)
                        .param("name","任丽")
                        .param("gender_code","2")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andDo(print());

    }

    @Test
    public void searchPersonInfosByPageDi() throws Exception{

        String getUrl =  urlStart + "/search-persons";
        this.mockMvc.perform(
                post(getUrl)
                        .param("name","金珊")
                        .param("diagnosis_code","A16")
                        .param("hospital_no","2026")
                        .param("page_size","1")
                        .param("age_start","20")
                        .param("age_end","35")
                        .param("nation_code","01")
                        .param("abo_blood_code","1")
                        .param("occupation_code","70")
                        .param("gender_code","2")
                        .param("marital_status_code","1")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andDo(print());

    }

    @Test
    public void getMedOrgInfos() throws Exception{
        String getUrl = "/api/v1/common/med-org/infos/query";
        this.mockMvc.perform(post(getUrl).contentType(MediaType.APPLICATION_JSON).content("[ {\"region\":\"210100\",\"org_no\":\"9051\"},{\"region\":\"210100\",\"org_no\":\"2094\"},{\"region\":\"210100\",\"org_no\":\"1001\"} ]"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }


    @Test
    public void getVisitInfo() throws Exception{
        String getUrl = "/api/v1/common/visit-record/info?type=1&region=" + this.region_no+"&hos="+this.hospital_no+"&vno="+this.visit_no;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

}