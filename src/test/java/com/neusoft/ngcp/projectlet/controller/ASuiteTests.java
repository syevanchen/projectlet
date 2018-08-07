package com.neusoft.ngcp.projectlet.controller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 打包测试类
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CommonControllerTest.class, HealthControllerTest.class, InsuranceControllerTest.class,fileControllerTest.class,DrugstoreControllerTest.class})

public class ASuiteTests {
    //无需实现代码
}
