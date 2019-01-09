package com.admin.model;


public class MateriaPrima {

    private long idMateriaPrima;

    private int codigo;
    private String descripcion;
    private float listaPrecioIva;
    private int kgPorBulto;
    private float precioPorKg;
    private String proveedor;
    private int codigoProveedor;
    private float precioPorBultoDeLista;

    public long getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(long idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
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

    public float getListaPrecioIva() {
        return listaPrecioIva;
    }

    public void setListaPrecioIva(float listaPrecioIva) {
        this.listaPrecioIva = listaPrecioIva;
    }

    public int getKgPorBulto() {
        return kgPorBulto;
    }

    public void setKgPorBulto(int kgPorBulto) {
        this.kgPorBulto = kgPorBulto;
    }

    public float getPrecioPorKg() {
        return precioPorKg;
    }

    public void setPrecioPorKg(float precioPorKg) {
        this.precioPorKg = precioPorKg;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public float getPrecioPorBultoDeLista() {
        return precioPorBultoDeLista;
    }

    public void setPrecioPorBultoDeLista(float precioPorBultoDeLista) {
        this.precioPorBultoDeLista = precioPorBultoDeLista;
    }
}
