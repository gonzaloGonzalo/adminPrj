package com.admin.view;

import com.admin.model.Receta;
import com.admin.service.DataService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

@ManagedBean
public class RecetaView {

    private final static String URI_OBTENER_RECETAS = "http://localhost:8383/api/control/recetas";
    private final static String URI_INSERTAR_RECETA = "http://localhost:8383/api/control/receta";

    @Getter
    @Setter
    private List<Receta> listaReceta;
    @Getter @Setter
    @ManagedProperty(value="#{dataService}")
    private DataService<Receta> dataService;
    @Getter @Setter
    private Receta receta;

    @PostConstruct
    public void init(){
        receta = new Receta();
        listaReceta = dataService.obtenerListaElementos(URI_OBTENER_RECETAS);
    }

    public void insertarReceta(){
        dataService.insertarElemento(receta, URI_INSERTAR_RECETA);
        init();
    }
}
