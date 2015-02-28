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
@Table(name = "ARTICULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a"),
    @NamedQuery(name = "Articulo.findByIdArticulo", query = "SELECT a FROM Articulo a WHERE a.idArticulo = :idArticulo"),
    @NamedQuery(name = "Articulo.findByDescripcion", query = "SELECT a FROM Articulo a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Articulo.findByPuntoReorden", query = "SELECT a FROM Articulo a WHERE a.puntoReorden = :puntoReorden"),
    @NamedQuery(name = "Articulo.findByExistenciaMinima", query = "SELECT a FROM Articulo a WHERE a.existenciaMinima = :existenciaMinima"),
    @NamedQuery(name = "Articulo.findByCosto", query = "SELECT a FROM Articulo a WHERE a.costo = :costo")})
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
    private float costo;
    @Column(name = "CODIGO_BARRA")
    private String codigoBarra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articulo", fetch = FetchType.LAZY)
    private List<ArticuloClasificacion> articuloClasificacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articulo", fetch = FetchType.LAZY)
    private List<ExistenciaBodega> existenciaBodegaList;
    @OneToMany(mappedBy = "idArticulo", fetch = FetchType.LAZY)
    private List<GastoEspontaneo> gastoEspontaneoList;
    @OneToMany(mappedBy = "idArticulo", fetch = FetchType.LAZY)
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

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	@XmlTransient
    public List<ArticuloClasificacion> getArticuloClasificacionList() {
        return articuloClasificacionList;
    }

    public void setArticuloClasificacionList(List<ArticuloClasificacion> articuloClasificacionList) {
        this.articuloClasificacionList = articuloClasificacionList;
    }

    @XmlTransient
    public List<ExistenciaBodega> getExistenciaBodegaList() {
        return existenciaBodegaList;
    }

    public void setExistenciaBodegaList(List<ExistenciaBodega> existenciaBodegaList) {
        this.existenciaBodegaList = existenciaBodegaList;
    }

    @XmlTransient
    public List<GastoEspontaneo> getGastoEspontaneoList() {
        return gastoEspontaneoList;
    }

    public void setGastoEspontaneoList(List<GastoEspontaneo> gastoEspontaneoList) {
        this.gastoEspontaneoList = gastoEspontaneoList;
    }

    @XmlTransient
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
