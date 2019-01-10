package com.admin.view;

import com.admin.model.MateriaPrima;
import com.admin.model.Receta;
import com.admin.service.DataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.DualListModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ManagedBean
public class RecetaView {

    private final static String URI_OBTENER_RECETAS = "http://localhost:8383/api/control/recetas";
    private final static String URI_INSERTAR_RECETA = "http://localhost:8383/api/control/receta";
    private final static String URI_OBTENER_MATERIAS_PRIMAS = "http://localhost:8383/api/control/materiasPrimas";


    @Getter
    @Setter
    private List<Receta> listaReceta;
    @Getter @Setter
    @ManagedProperty(value="#{dataService}")
    private DataService<Receta> dataService;
    @Getter @Setter
    @ManagedProperty(value="#{dataService}")
    private DataService<MateriaPrima> materiaPrimaService;
    @Getter @Setter
    private Receta receta;
    @Getter @Setter
    DualListModel listaMateriaPrimas;

    @PostConstruct
    public void init(){
        receta = new Receta();
        receta.setIngredientes(materiaPrimaService.obtenerListaElementos(URI_OBTENER_MATERIAS_PRIMAS));
        listaReceta = dataService.obtenerListaElementos(URI_OBTENER_RECETAS);
        List<MateriaPrima> target = new ArrayList<>();
        listaMateriaPrimas = new DualListModel<MateriaPrima>(receta.getIngredientes(), target);
    }

    public void insertarReceta(){
        receta.setIngredientes(convertMateriaPrima(listaMateriaPrimas.getTarget()));
        dataService.insertarElemento(receta, URI_INSERTAR_RECETA);
        init();
    }

    private List<MateriaPrima> convertMateriaPrima(List<String> materiaPrimaJson){
        try{
            List<MateriaPrima> listaMateriaPrima = new ArrayList<>();
            for (String materiaPrima : materiaPrimaJson){
                List<String> fields = Arrays.asList(materiaPrima
                        .replace("{","")
                        .replace("}","")
                        .split(","));

                MateriaPrima mPrima = new MateriaPrima();
                mPrima.setIdMateriaPrima(Integer.parseInt(fields.get(0).split("=")[1]));
                mPrima.setCodigo(Integer.parseInt(fields.get(1).split("=")[1]));
                mPrima.setDescripcion(fields.get(2).split("=")[1]);
                mPrima.setListaPrecioIva(Float.parseFloat(fields.get(3).split("=")[1]));
                mPrima.setKgPorBulto(Integer.parseInt(fields.get(4).split("=")[1]));
                mPrima.setPrecioPorKg(Float.parseFloat(fields.get(5).split("=")[1]));
                mPrima.setProveedor(fields.get(6).split("=")[1]);
                mPrima.setCodigoProveedor(Integer.parseInt(fields.get(7).split("=")[1]));
                mPrima.setPrecioPorBultoDeLista(Float.parseFloat(fields.get(8).split("=")[1]));
                listaMateriaPrima.add(mPrima);
            }
            return listaMateriaPrima;
        }catch (Exception ex){

        }
            return Collections.emptyList();
    }
}
