package com.admin.service;

import com.admin.model.MateriaPrima;
import com.admin.util.UtilConvert;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.faces.bean.ManagedBean;
import java.util.Collections;
import java.util.List;

@ManagedBean(name="materiaPrimaServ")
public class MateriaPrimaService{

    public long insertarMateriaPrima(MateriaPrima materiaPrima){
         try{
             HttpHeaders headers = new HttpHeaders();
             headers.setContentType(MediaType.APPLICATION_JSON);
             final String uri = "http://localhost:8383/api/control/materiaPrima";
             RestTemplate restTemplate = new RestTemplate();
             MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
             map.add("materiaPrima", materiaPrima);
             HttpEntity<MultiValueMap<String, Object>> httpEntity =
                     new HttpEntity<MultiValueMap<String, Object>>(map, headers);

             MateriaPrima res = restTemplate.postForObject(uri, httpEntity, MateriaPrima.class);
             return res.getIdMateriaPrima();
         }
         catch (Exception ex) {

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
