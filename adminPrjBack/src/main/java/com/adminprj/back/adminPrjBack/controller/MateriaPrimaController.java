package com.adminprj.back.adminPrjBack.controller;

import com.adminprj.back.adminPrjBack.model.MateriaPrima;
import com.adminprj.back.adminPrjBack.util.UtilConvert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by computer on 09/01/19.
 */
public interface MateriaPrimaController {

    @PostMapping("/materiaPrima")
    public String insertarMateriaPrima(@RequestBody MateriaPrima materiaPrima);

    @GetMapping("/materiasPrimas")
    public List<MateriaPrima> listaMateriaPrima();
}
