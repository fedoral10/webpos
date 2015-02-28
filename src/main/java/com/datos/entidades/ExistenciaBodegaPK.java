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
public class ExistenciaBodegaPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "ID_EXISTENCIA_BODEGA")
    private long idExistenciaBodega;
    @Basic(optional = false)
    @Column(name = "ID_BODEGA")
    private long idBodega;
    @Basic(optional = false)
    @Column(name = "ID_ARTICULO")
    private long idArticulo;

    public ExistenciaBodegaPK() {
    }

    public ExistenciaBodegaPK(long idExistenciaBodega, long idBodega, long idArticulo) {
        this.idExistenciaBodega = idExistenciaBodega;
        this.idBodega = idBodega;
        this.idArticulo = idArticulo;
    }

    public long getIdExistenciaBodega() {
        return idExistenciaBodega;
    }

    public void setIdExistenciaBodega(long idExistenciaBodega) {
        this.idExistenciaBodega = idExistenciaBodega;
    }

    public long getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(long idBodega) {
        this.idBodega = idBodega;
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
        hash += (int) idExistenciaBodega;
        hash += (int) idBodega;
        hash += (int) idArticulo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExistenciaBodegaPK)) {
            return false;
        }
        ExistenciaBodegaPK other = (ExistenciaBodegaPK) object;
        if (this.idExistenciaBodega != other.idExistenciaBodega) {
            return false;
        }
        if (this.idBodega != other.idBodega) {
            return false;
        }
        if (this.idArticulo != other.idArticulo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datos.entidades.ExistenciaBodegaPK[ idExistenciaBodega=" + idExistenciaBodega + ", idBodega=" + idBodega + ", idArticulo=" + idArticulo + " ]";
    }
    
}
