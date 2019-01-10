package com.adminprj.back.adminPrjBack.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Receta {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long idReceta;

    private String nombre;

    @OneToMany
    private List<MateriaPrima> ingredientes;

    public long getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(long idReceta) {
        this.idReceta = idReceta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<MateriaPrima> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<MateriaPrima> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
