package com.adminprj.back.adminPrjBack.controller;

import com.adminprj.back.adminPrjBack.model.MateriaPrima;
import com.adminprj.back.adminPrjBack.model.Producto;
import com.adminprj.back.adminPrjBack.model.Receta;
import com.adminprj.back.adminPrjBack.repository.MateriaPrimaRepository;
import com.adminprj.back.adminPrjBack.repository.ProductoRepository;
import com.adminprj.back.adminPrjBack.repository.RecetaRepository;
import com.adminprj.back.adminPrjBack.util.UtilConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/control")
public class EntidadControllerImpl implements EntidadController {

    private final static String PROCESSED = "Processed";

    @Autowired
    private MateriaPrimaRepository materiaPrimaRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private RecetaRepository recetaRepository;

    @Override
    public String insertarMateriaPrima(@RequestBody MateriaPrima materiaPrima){
        materiaPrimaRepository.save(materiaPrima);
        return PROCESSED;
    }

    @Override
    public List<MateriaPrima> listaMateriaPrima(){
        return UtilConvert.toList(materiaPrimaRepository.findAll());
    }

    @Override
    public String insertarProducto(Producto producto) {
        productoRepository.save(producto);
        return PROCESSED;
    }

    @Override
    public List<Producto> listaProductos() {
        return UtilConvert.toList(productoRepository.findAll());
    }

    @Override
    public String insertarReceta(Receta receta) {
        recetaRepository.save(receta);
        return PROCESSED;
    }

    @Override
    public List<Receta> listaReceta() {
        return UtilConvert.toList(recetaRepository.findAll());
    }
}
