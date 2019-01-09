package com.admin.view;

import com.admin.model.MateriaPrima;
import com.admin.service.MateriaPrimaService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

@ManagedBean
public class MateriaPrimaView {

    private List<MateriaPrima> listaMateriaPrima;
    @ManagedProperty(value="#{materiaPrimaServ}")
    private MateriaPrimaService materiaPrimaService;

    @PostConstruct
    public void init(){
        listaMateriaPrima = materiaPrimaService.obtenerMateriaPrima();
    }

    public void insertarMateriaPrima(MateriaPrima materiaPrima){

    }

    public List<MateriaPrima> getListaMateriaPrima() {
        return listaMateriaPrima;
    }

    public void setListaMateriaPrima(List<MateriaPrima> listaMateriaPrima) {
        this.listaMateriaPrima = listaMateriaPrima;
    }

    public MateriaPrimaService getMateriaPrimaService() {
        return materiaPrimaService;
    }

    public void setMateriaPrimaService(MateriaPrimaService materiaPrimaService) {
        this.materiaPrimaService = materiaPrimaService;
    }
}
