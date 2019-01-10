package com.admin.service;

import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="restService")
public class RestService {

    private RestTemplate restTemplate;

    @PostConstruct
    private void init(){
        restTemplate = new RestTemplate();
    }

    public RestTemplate getRestTemplate(){
        return this.restTemplate;
    }
}
