/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datos.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Wesker
 */
@Entity
@Table(name = "EXISTENCIA_BODEGA")
@NamedQueries({
    @NamedQuery(name = "ExistenciaBodega.findAll", query = "SELECT e FROM ExistenciaBodega e")})
public class ExistenciaBodega implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExistenciaBodegaPK existenciaBodegaPK;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COSTO")
    private BigDecimal costo;
    @Column(name = "PRECIO_VENTA")
    private BigDecimal precioVenta;
    @JoinColumn(name = "ID_ARTICULO", referencedColumnName = "ID_ARTICULO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Articulo articulo;
    @JoinColumn(name = "ID_BODEGA", referencedColumnName = "ID_BODEGA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bodega bodega;

    public ExistenciaBodega() {
    }

    public ExistenciaBodega(ExistenciaBodegaPK existenciaBodegaPK) {
        this.existenciaBodegaPK = existenciaBodegaPK;
    }

    public ExistenciaBodega(long idExistenciaBodega, long idBodega, long idArticulo) {
        this.existenciaBodegaPK = new ExistenciaBodegaPK(idExistenciaBodega, idBodega, idArticulo);
    }

    public ExistenciaBodegaPK getExistenciaBodegaPK() {
        return existenciaBodegaPK;
    }

    public void setExistenciaBodegaPK(ExistenciaBodegaPK existenciaBodegaPK) {
        this.existenciaBodegaPK = existenciaBodegaPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (existenciaBodegaPK != null ? existenciaBodegaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExistenciaBodega)) {
            return false;
        }
        ExistenciaBodega other = (ExistenciaBodega) object;
        if ((this.existenciaBodegaPK == null && other.existenciaBodegaPK != null) || (this.existenciaBodegaPK != null && !this.existenciaBodegaPK.equals(other.existenciaBodegaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datos.entidades.ExistenciaBodega[ existenciaBodegaPK=" + existenciaBodegaPK + " ]";
    }
    
}
