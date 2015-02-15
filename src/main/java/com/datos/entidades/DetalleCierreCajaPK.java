/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datos.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Wesker
 */
@Embeddable
public class DetalleCierreCajaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_DETALLE_CIERRE_CAJA")
    private long idDetalleCierreCaja;
    @Basic(optional = false)
    @Column(name = "ID_DENOMINACION")
    private long idDenominacion;

    public DetalleCierreCajaPK() {
    }

    public DetalleCierreCajaPK(long idDetalleCierreCaja, long idDenominacion) {
        this.idDetalleCierreCaja = idDetalleCierreCaja;
        this.idDenominacion = idDenominacion;
    }

    public long getIdDetalleCierreCaja() {
        return idDetalleCierreCaja;
    }

    public void setIdDetalleCierreCaja(long idDetalleCierreCaja) {
        this.idDetalleCierreCaja = idDetalleCierreCaja;
    }

    public long getIdDenominacion() {
        return idDenominacion;
    }

    public void setIdDenominacion(long idDenominacion) {
        this.idDenominacion = idDenominacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDetalleCierreCaja;
        hash += (int) idDenominacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCierreCajaPK)) {
            return false;
        }
        DetalleCierreCajaPK other = (DetalleCierreCajaPK) object;
        if (this.idDetalleCierreCaja != other.idDetalleCierreCaja) {
            return false;
        }
        if (this.idDenominacion != other.idDenominacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datos.entidades.DetalleCierreCajaPK[ idDetalleCierreCaja=" + idDetalleCierreCaja + ", idDenominacion=" + idDenominacion + " ]";
    }
    
}
