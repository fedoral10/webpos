/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datos.entidades;

import java.io.Serializable;
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
@Table(name = "ARTICULO_CLASIFICACION")
@NamedQueries({
    @NamedQuery(name = "ArticuloClasificacion.findAll", query = "SELECT a FROM ArticuloClasificacion a")})
public class ArticuloClasificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArticuloClasificacionPK articuloClasificacionPK;
    @JoinColumn(name = "ID_ARTICULO", referencedColumnName = "ID_ARTICULO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Articulo articulo;
    @JoinColumn(name = "ID_CLASIFICACION", referencedColumnName = "ID_CLASIFICACION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clasificacion clasificacion;

    public ArticuloClasificacion() {
    }

    public ArticuloClasificacion(ArticuloClasificacionPK articuloClasificacionPK) {
        this.articuloClasificacionPK = articuloClasificacionPK;
    }

    public ArticuloClasificacion(long idArticuloClasificacion, long idClasificacion, long idArticulo) {
        this.articuloClasificacionPK = new ArticuloClasificacionPK(idArticuloClasificacion, idClasificacion, idArticulo);
    }

    public ArticuloClasificacionPK getArticuloClasificacionPK() {
        return articuloClasificacionPK;
    }

    public void setArticuloClasificacionPK(ArticuloClasificacionPK articuloClasificacionPK) {
        this.articuloClasificacionPK = articuloClasificacionPK;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (articuloClasificacionPK != null ? articuloClasificacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticuloClasificacion)) {
            return false;
        }
        ArticuloClasificacion other = (ArticuloClasificacion) object;
        if ((this.articuloClasificacionPK == null && other.articuloClasificacionPK != null) || (this.articuloClasificacionPK != null && !this.articuloClasificacionPK.equals(other.articuloClasificacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datos.entidades.ArticuloClasificacion[ articuloClasificacionPK=" + articuloClasificacionPK + " ]";
    }
    
}
