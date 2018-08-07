package com.neusoft.ngcp.projectlet.backend.mgwcore;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "mgwcore" , url="${mgwcore.url:http://localhost:8080/}",configuration=MgwCoreFeignConfiguration.class)
public interface MgwCoreFeignClient {

}
