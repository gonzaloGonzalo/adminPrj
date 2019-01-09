package com.admin.model;

import java.util.List;

public class Receta {

    private long idReceta;
    private List<MateriaPrima> ingredientes;

    public long getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(long idReceta) {
        this.idReceta = idReceta;
    }

    public List<MateriaPrima> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<MateriaPrima> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
