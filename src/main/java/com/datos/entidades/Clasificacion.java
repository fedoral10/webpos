/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datos.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wesker
 */
@Entity
@Table(name = "CLASIFICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clasificacion.findAll", query = "SELECT c FROM Clasificacion c"),
    @NamedQuery(name = "Clasificacion.findByIdClasificacion", query = "SELECT c FROM Clasificacion c WHERE c.idClasificacion = :idClasificacion"),
    @NamedQuery(name = "Clasificacion.findByNombre", query = "SELECT c FROM Clasificacion c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Clasificacion.findByDescripcion", query = "SELECT c FROM Clasificacion c WHERE c.descripcion = :descripcion")})
public class Clasificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CLASIFICACION")
    private Long idClasificacion;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clasificacion", fetch = FetchType.LAZY)
    private List<ArticuloClasificacion> articuloClasificacionList;

    public Clasificacion() {
    }

    public Clasificacion(Long idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public Clasificacion(Long idClasificacion, String nombre) {
        this.idClasificacion = idClasificacion;
        this.nombre = nombre;
    }

    public Long getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(Long idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<ArticuloClasificacion> getArticuloClasificacionList() {
        return articuloClasificacionList;
    }

    public void setArticuloClasificacionList(List<ArticuloClasificacion> articuloClasificacionList) {
        this.articuloClasificacionList = articuloClasificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClasificacion != null ? idClasificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clasificacion)) {
            return false;
        }
        Clasificacion other = (Clasificacion) object;
        if ((this.idClasificacion == null && other.idClasificacion != null) || (this.idClasificacion != null && !this.idClasificacion.equals(other.idClasificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datos.entidades.Clasificacion[ idClasificacion=" + idClasificacion + " ]";
    }
    
}
