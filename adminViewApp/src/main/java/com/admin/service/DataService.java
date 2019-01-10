package com.admin.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean(name="dataService")
public class DataService<T> {

    @Getter @Setter
    @ManagedProperty(value="#{restService}")
    private RestService restService;

    public long insertarElemento(T element, String url){
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<T> requestEntity = new HttpEntity<T>(element, headers);
            ResponseEntity<String> uri = restService.getRestTemplate()
                    .exchange(url, HttpMethod.POST, requestEntity, String.class);
        }
        catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.ALL, ex.getMessage());
        }
        return -1L;
    }

    public List<T> obtenerListaElementos(String uri){
        try{
            ObjectMapper mapper = new ObjectMapper();
            RestTemplate restTemplate = new RestTemplate();
            String votersJson = restService.getRestTemplate()
                    .getForObject(uri, String.class);
            List<T> listElement =
                    mapper.readValue(votersJson,
                            new TypeReference<List<T>>(){});
            return listElement;
        }
        catch (Exception ex){
            Logger.getAnonymousLogger().log(Level.ALL, ex.getMessage());
        }
        return Collections.emptyList();
    }
}
