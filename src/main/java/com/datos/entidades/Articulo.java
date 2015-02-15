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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Wesker
 */
@Entity
@Table(name = "ARTICULO")
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a")})
public class Articulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ARTICULO")
    private Long idArticulo;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "PUNTO_REORDEN")
    private Integer puntoReorden;
    @Basic(optional = false)
    @Column(name = "EXISTENCIA_MINIMA")
    private int existenciaMinima;
    @Basic(optional = false)
    @Column(name = "COSTO")
    private int costo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articulo")
    private List<ArticuloClasificacion> articuloClasificacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articulo")
    private List<ExistenciaBodega> existenciaBodegaList;
    @OneToMany(mappedBy = "idArticulo")
    private List<GastoEspontaneo> gastoEspontaneoList;
    @OneToMany(mappedBy = "idArticulo")
    private List<FacturaLinea> facturaLineaList;

    public Articulo() {
    }

    public Articulo(Long idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Articulo(Long idArticulo, String descripcion, int existenciaMinima, int costo) {
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
        this.existenciaMinima = existenciaMinima;
        this.costo = costo;
    }

    public Long getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Long idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPuntoReorden() {
        return puntoReorden;
    }

    public void setPuntoReorden(Integer puntoReorden) {
        this.puntoReorden = puntoReorden;
    }

    public int getExistenciaMinima() {
        return existenciaMinima;
    }

    public void setExistenciaMinima(int existenciaMinima) {
        this.existenciaMinima = existenciaMinima;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public List<ArticuloClasificacion> getArticuloClasificacionList() {
        return articuloClasificacionList;
    }

    public void setArticuloClasificacionList(List<ArticuloClasificacion> articuloClasificacionList) {
        this.articuloClasificacionList = articuloClasificacionList;
    }

    public List<ExistenciaBodega> getExistenciaBodegaList() {
        return existenciaBodegaList;
    }

    public void setExistenciaBodegaList(List<ExistenciaBodega> existenciaBodegaList) {
        this.existenciaBodegaList = existenciaBodegaList;
    }

    public List<GastoEspontaneo> getGastoEspontaneoList() {
        return gastoEspontaneoList;
    }

    public void setGastoEspontaneoList(List<GastoEspontaneo> gastoEspontaneoList) {
        this.gastoEspontaneoList = gastoEspontaneoList;
    }

    public List<FacturaLinea> getFacturaLineaList() {
        return facturaLineaList;
    }

    public void setFacturaLineaList(List<FacturaLinea> facturaLineaList) {
        this.facturaLineaList = facturaLineaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticulo != null ? idArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.idArticulo == null && other.idArticulo != null) || (this.idArticulo != null && !this.idArticulo.equals(other.idArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datos.entidades.Articulo[ idArticulo=" + idArticulo + " ]";
    }
    
}
