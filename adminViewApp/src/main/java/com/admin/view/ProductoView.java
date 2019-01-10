package com.admin.view;

import com.admin.model.Producto;
import com.admin.service.DataService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

@ManagedBean
public class ProductoView {

    private final static String URI_OBTENER_PRODUCTOS = "http://localhost:8383/api/control/productos";
    private final static String URI_INSERTAR_PRODUCTO = "http://localhost:8383/api/control/producto";

    @Getter
    @Setter
    private List<Producto> listaProducto;
    @Getter @Setter
    @ManagedProperty(value="#{dataService}")
    private DataService<Producto> dataService;
    @Getter @Setter
    private Producto producto;

    @PostConstruct
    public void init(){
        producto = new Producto();
        listaProducto = dataService.obtenerListaElementos(URI_OBTENER_PRODUCTOS);
    }

    public void insertarProducto(){
        dataService.insertarElemento(producto, URI_INSERTAR_PRODUCTO);
        init();
    }
}
