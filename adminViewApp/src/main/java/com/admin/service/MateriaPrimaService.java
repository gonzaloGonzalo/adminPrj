package com.admin.service;

import com.admin.model.MateriaPrima;
import com.admin.util.UtilConvert;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.faces.bean.ManagedBean;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean(name="materiaPrimaServ")
public class MateriaPrimaService{

    public long insertarMateriaPrima(MateriaPrima materiaPrima){
         try{

             final String uri = "http://localhost:8383/api/control/materiaPrima";

             MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
             headers.add("Content-Type", "application/json");

             RestTemplate restTemplate = new RestTemplate();
             restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());

             HttpEntity<MateriaPrima> request = new HttpEntity<MateriaPrima>(materiaPrima, headers);

             restTemplate.postForObject(uri, request, Boolean.class);
         }
         catch (Exception ex) {
             Logger.getAnonymousLogger().log(Level.ALL, ex.getMessage());
         }
         return -1L;
    }

    public List<MateriaPrima> obtenerMateriaPrima(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            final String uri = "http://localhost:8383/api/control/materiasPrimas";
            RestTemplate restTemplate = new RestTemplate();
            String votersJson = restTemplate.getForObject(uri, String.class);
            List<MateriaPrima> listMateriaPrima =
                    mapper.readValue(votersJson,
                            new TypeReference<List<MateriaPrima>>(){});
            return listMateriaPrima;
        }
        catch (Exception ex){

        }
        return Collections.emptyList();
    }
}
