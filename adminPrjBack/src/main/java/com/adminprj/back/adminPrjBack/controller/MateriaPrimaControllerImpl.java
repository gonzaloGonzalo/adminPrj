package com.adminprj.back.adminPrjBack.controller;

import com.adminprj.back.adminPrjBack.model.MateriaPrima;
import com.adminprj.back.adminPrjBack.repository.MateriaPrimaRepository;
import com.adminprj.back.adminPrjBack.util.UtilConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/control")
public class MateriaPrimaControllerImpl implements MateriaPrimaController{

    private final static String PROCESSED = "Processed";

    @Autowired
    private MateriaPrimaRepository materiaPrimaRepository;

    @Override
    public String insertarMateriaPrima(@RequestBody MateriaPrima materiaPrima){
        materiaPrimaRepository.save(materiaPrima);
        return PROCESSED;
    }

    @Override
    public List<MateriaPrima> listaMateriaPrima(){
        return UtilConvert.toList(materiaPrimaRepository.findAll());
    }
}
