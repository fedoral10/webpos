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
public class ArticuloClasificacionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ARTICULO_CLASIFICACION")
    private long idArticuloClasificacion;
    @Basic(optional = false)
    @Column(name = "ID_CLASIFICACION")
    private long idClasificacion;
    @Basic(optional = false)
    @Column(name = "ID_ARTICULO")
    private long idArticulo;

    public ArticuloClasificacionPK() {
    }

    public ArticuloClasificacionPK(long idArticuloClasificacion, long idClasificacion, long idArticulo) {
        this.idArticuloClasificacion = idArticuloClasificacion;
        this.idClasificacion = idClasificacion;
        this.idArticulo = idArticulo;
    }

    public long getIdArticuloClasificacion() {
        return idArticuloClasificacion;
    }

    public void setIdArticuloClasificacion(long idArticuloClasificacion) {
        this.idArticuloClasificacion = idArticuloClasificacion;
    }

    public long getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(long idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public long getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(long idArticulo) {
        this.idArticulo = idArticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idArticuloClasificacion;
        hash += (int) idClasificacion;
        hash += (int) idArticulo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticuloClasificacionPK)) {
            return false;
        }
        ArticuloClasificacionPK other = (ArticuloClasificacionPK) object;
        if (this.idArticuloClasificacion != other.idArticuloClasificacion) {
            return false;
        }
        if (this.idClasificacion != other.idClasificacion) {
            return false;
        }
        if (this.idArticulo != other.idArticulo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datos.entidades.ArticuloClasificacionPK[ idArticuloClasificacion=" + idArticuloClasificacion + ", idClasificacion=" + idClasificacion + ", idArticulo=" + idArticulo + " ]";
    }
    
}
