package com.neusoft.ngcp.projectlet.controller;

import com.neusoft.ngcp.projectlet.ProjectletApplication;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProjectletApplication.class)
public abstract class ControllerTest {

    @Value("${testData.person_id}")
    public String person_id;

    @Value("${testData.region_no}")
    public String region_no;

    @Value("${testData.visit_no}")
    public String visit_no;

    @Value("${testData.hospital_no}")
    public String hospital_no;

    @Value("${testData.insurance_id}")
    public String insurance_id;

    @Autowired
    WebApplicationContext webApplicationContext;

    public MockMvc mockMvc;

    @Before
    public void setUp(){

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

}
