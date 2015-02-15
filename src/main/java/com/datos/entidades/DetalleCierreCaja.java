/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datos.entidades;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "DETALLE_CIERRE_CAJA")
@NamedQueries({
    @NamedQuery(name = "DetalleCierreCaja.findAll", query = "SELECT d FROM DetalleCierreCaja d")})
public class DetalleCierreCaja implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleCierreCajaPK detalleCierreCajaPK;
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @JoinColumn(name = "ID_CAJA", referencedColumnName = "ID_CAJA")
    @ManyToOne
    private Caja idCaja;
    @JoinColumn(name = "ID_DENOMINACION", referencedColumnName = "ID_DENOMINACION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Denominacion denominacion;

    public DetalleCierreCaja() {
    }

    public DetalleCierreCaja(DetalleCierreCajaPK detalleCierreCajaPK) {
        this.detalleCierreCajaPK = detalleCierreCajaPK;
    }

    public DetalleCierreCaja(long idDetalleCierreCaja, long idDenominacion) {
        this.detalleCierreCajaPK = new DetalleCierreCajaPK(idDetalleCierreCaja, idDenominacion);
    }

    public DetalleCierreCajaPK getDetalleCierreCajaPK() {
        return detalleCierreCajaPK;
    }

    public void setDetalleCierreCajaPK(DetalleCierreCajaPK detalleCierreCajaPK) {
        this.detalleCierreCajaPK = detalleCierreCajaPK;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public Caja getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(Caja idCaja) {
        this.idCaja = idCaja;
    }

    public Denominacion getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(Denominacion denominacion) {
        this.denominacion = denominacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleCierreCajaPK != null ? detalleCierreCajaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCierreCaja)) {
            return false;
        }
        DetalleCierreCaja other = (DetalleCierreCaja) object;
        if ((this.detalleCierreCajaPK == null && other.detalleCierreCajaPK != null) || (this.detalleCierreCajaPK != null && !this.detalleCierreCajaPK.equals(other.detalleCierreCajaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datos.entidades.DetalleCierreCaja[ detalleCierreCajaPK=" + detalleCierreCajaPK + " ]";
    }
    
}
