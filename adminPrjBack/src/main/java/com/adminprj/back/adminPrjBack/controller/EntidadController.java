package com.adminprj.back.adminPrjBack.controller;

import com.adminprj.back.adminPrjBack.model.MateriaPrima;
import com.adminprj.back.adminPrjBack.model.Producto;
import com.adminprj.back.adminPrjBack.model.Receta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by computer on 09/01/19.
 */
public interface EntidadController {

    @PostMapping("/materiaPrima")
    public String insertarMateriaPrima(@RequestBody MateriaPrima materiaPrima);

    @GetMapping("/materiasPrimas")
    public List<MateriaPrima> listaMateriaPrima();

    @PostMapping("/producto")
    public String insertarProducto(@RequestBody Producto producto);

    @GetMapping("/productos")
    public List<Producto> listaProductos();

    @PostMapping("/receta")
    public String insertarReceta(@RequestBody Receta receta);

    @GetMapping("/recetas")
    public List<Receta> listaReceta();

}
