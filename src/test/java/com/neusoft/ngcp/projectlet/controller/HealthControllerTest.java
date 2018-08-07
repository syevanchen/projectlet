package com.neusoft.ngcp.projectlet.controller;

import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HealthControllerTest extends ControllerTest {

    private String urlStart = "/api/v1/health/person";

    @Test
    public void getDiseases() throws Exception{
        String getUrl = urlStart + "/diseases?type=1&no="+ this.person_id;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getDiseasesMe() throws Exception{
        String getUrl = urlStart + "/diseases?type=1&no="+ "210402198711010513";
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getMedicalRecords() throws Exception{
        String getUrl = urlStart + "/medical-records?type=1&no="+ this.person_id;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getMedicalRecordsV2() throws Exception{
        String getUrl = urlStart + "/medical-records?type=1&no="+ "210112197802023434";
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getMedicalRecordsNoHomePage() throws Exception{
        String getUrl = urlStart + "/medical-records?type=1&no="+ "211202198105111277";
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getTestReports() throws Exception{
        String getUrl = urlStart + "/med/tests?type=1&no=" + this.person_id
                + "&region=" + this.region_no
                + "&hos=" + this.hospital_no
                + "&vno=" + this.visit_no;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getExaminations() throws Exception{
        String getUrl = urlStart + "/med/examinations?type=1&no=" + this.person_id
                + "&region=" + this.region_no
                + "&hos=" + this.hospital_no
                + "&vno=" + this.visit_no;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getAdvices() throws Exception{
        String getUrl = urlStart + "/med/advices?type=1&no=" + this.person_id
                + "&region=" + this.region_no
                + "&hos=" + this.hospital_no
                + "&vno=" + this.visit_no;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getOperations() throws Exception{
        String getUrl = urlStart + "/med/operations?type=1&no=" + this.person_id
                + "&region=" + this.region_no
                + "&hos=" + this.hospital_no
                + "&vno=" + this.visit_no;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getDrugs() throws Exception{
        String getUrl = urlStart + "/med/drugs?type=1&no=" + this.person_id
                + "&region=" + this.region_no
                + "&hos=" + this.hospital_no
                + "&vno=" + this.visit_no;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getClinicItems() throws Exception{
        String getUrl = urlStart + "/med/clinic-items?type=1&no=" + this.person_id
                + "&region=" + this.region_no
                + "&hos=" + this.hospital_no
                + "&vno=" + this.visit_no;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getHomepage() throws Exception{
        String getUrl = urlStart + "/med/homepage?type=1&no=" + this.person_id
                + "&region=" + this.region_no
                + "&hos=" + this.hospital_no
                + "&vno=" + this.visit_no;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getHomepageBase() throws Exception{
        String getUrl = urlStart + "/med/homepage-base?type=1&no=" + this.person_id
                + "&region=" + this.region_no
                + "&hos=" + this.hospital_no
                + "&vno=" + this.visit_no;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getHomepageFee() throws Exception{
        String getUrl = urlStart + "/med/homepage-fee?type=1&no=" + this.person_id
                + "&region=" + this.region_no
                + "&hos=" + this.hospital_no
                + "&vno=" + this.visit_no;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getSummary() throws Exception{
        String getUrl = urlStart + "/med/summary?type=1&no=" + this.person_id
                + "&region=" + this.region_no
                + "&hos=" + this.hospital_no
                + "&vno=" + this.visit_no;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getEmrDiagnoses() throws Exception{
        String getUrl = urlStart + "/med/homepage-diagnoses?type=1&no=" + this.person_id
                + "&region=" + this.region_no
                + "&hos=" + this.hospital_no
                + "&vno=" + this.visit_no;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getEmrOperations() throws Exception{
        String getUrl = urlStart + "/med/homepage-operations?type=1&no=" + this.person_id
                + "&region=" + this.region_no
                + "&hos=" + this.hospital_no
                + "&vno=" + this.visit_no;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getOutpatientRecords() throws Exception{
        String getUrl = urlStart + "/outpatient-records?type=1&no="+ this.person_id;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getInpatientRecords() throws Exception{
        String getUrl = urlStart + "/inpatient-records?type=1&no="+ this.person_id;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getInpatientRecords1() throws Exception{
        String getUrl = urlStart + "/inpatient-records?type=1&no=210106195010252144";
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getMedicalRecord() throws Exception{
        String getUrl = urlStart + "/medical-record?type=1&no=" + this.person_id
                + "&region=" + this.region_no
                + "&hos=" + this.hospital_no
                + "&vno=" + this.visit_no;
        this.mockMvc.perform(get(getUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

//    @Test
//    public void getMedicalRecordsTemp() throws Exception{
//        String getUrl = urlStart + "/medical-records?type=1&no="+ "210105201202133125";
//        this.mockMvc.perform(get(getUrl))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType("application/json;charset=UTF-8"));
//    }
//
//    @Test
//    public void getEmrDiagnosesTemp() throws Exception{
//        String getUrl = urlStart + "/med/homepage-diagnoses?type=1&no=" + "210103199106173626"
//                + "&region=" + "210100"
//                + "&hos=" + "2150"
//                + "&vno=" + "ZY010001272247";
//        this.mockMvc.perform(get(getUrl))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType("application/json;charset=UTF-8"));
//    }
//
//    @Test
//    public void getHomepageTemp() throws Exception{
//        String getUrl = urlStart + "/med/homepage?type=1&no=" + "210103199106173626"
//                + "&region=" + "210100"
//                + "&hos=" + "2150"
//                + "&vno=" + "ZY010001272247";
//        this.mockMvc.perform(get(getUrl))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType("application/json;charset=UTF-8"));
//    }
}