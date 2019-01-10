package com.admin.view;

import com.admin.model.MateriaPrima;
import com.admin.service.DataService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

@ManagedBean
public class MateriaPrimaView {

    private final static String URI_OBTENER_MATERIAS_PRIMAS = "http://localhost:8383/api/control/materiasPrimas";
    private final static String URI_INSERTAR_MATERIA_PRIMA = "http://localhost:8383/api/control/materiaPrima";

    @Getter @Setter
    private List<MateriaPrima> listaMateriaPrima;
    @Getter @Setter
    @ManagedProperty(value="#{dataService}")
    private DataService<MateriaPrima> dataService;
    @Getter @Setter
    private MateriaPrima materiaPrima;

    @PostConstruct
    public void init(){
        materiaPrima = new MateriaPrima();
        listaMateriaPrima = dataService.obtenerListaElementos(URI_OBTENER_MATERIAS_PRIMAS);
    }

    public void insertarMateriaPrima(){
        dataService.insertarElemento(materiaPrima, URI_INSERTAR_MATERIA_PRIMA);
        init();
    }
}
