package com.admin.model;

public class Producto {

    private long idProducto;

    private int codigo;
    private String descripcion;
    private String centroDeCosto;
    private float rindePorRecetaKg;
    private float rindePorRecetaUnidad;

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCentroDeCosto() {
        return centroDeCosto;
    }

    public void setCentroDeCosto(String centroDeCosto) {
        this.centroDeCosto = centroDeCosto;
    }

    public float getRindePorRecetaKg() {
        return rindePorRecetaKg;
    }

    public void setRindePorRecetaKg(float rindePorRecetaKg) {
        this.rindePorRecetaKg = rindePorRecetaKg;
    }

    public float getRindePorRecetaUnidad() {
        return rindePorRecetaUnidad;
    }

    public void setRindePorRecetaUnidad(float rindePorRecetaUnidad) {
        this.rindePorRecetaUnidad = rindePorRecetaUnidad;
    }
}
