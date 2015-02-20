/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datos.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wesker
 */
@Entity
@Table(name = "GASTO_ESPONTANEO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GastoEspontaneo.findAll", query = "SELECT g FROM GastoEspontaneo g"),
    @NamedQuery(name = "GastoEspontaneo.findByIdGastoEspontaneo", query = "SELECT g FROM GastoEspontaneo g WHERE g.idGastoEspontaneo = :idGastoEspontaneo"),
    @NamedQuery(name = "GastoEspontaneo.findByObservaciones", query = "SELECT g FROM GastoEspontaneo g WHERE g.observaciones = :observaciones")})
public class GastoEspontaneo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_GASTO_ESPONTANEO")
    private Long idGastoEspontaneo;
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @JoinColumn(name = "ID_ARTICULO", referencedColumnName = "ID_ARTICULO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Articulo idArticulo;
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado idEmpleado;
    @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proveedor idProveedor;
    @JoinColumn(name = "ID_TIPO_GASTO_ESPONTANEO", referencedColumnName = "ID_TIPO_GASTO_ESPONTANEO")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoGastoEspontaneo idTipoGastoEspontaneo;

    public GastoEspontaneo() {
    }

    public GastoEspontaneo(Long idGastoEspontaneo) {
        this.idGastoEspontaneo = idGastoEspontaneo;
    }

    public Long getIdGastoEspontaneo() {
        return idGastoEspontaneo;
    }

    public void setIdGastoEspontaneo(Long idGastoEspontaneo) {
        this.idGastoEspontaneo = idGastoEspontaneo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Articulo getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Articulo idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public TipoGastoEspontaneo getIdTipoGastoEspontaneo() {
        return idTipoGastoEspontaneo;
    }

    public void setIdTipoGastoEspontaneo(TipoGastoEspontaneo idTipoGastoEspontaneo) {
        this.idTipoGastoEspontaneo = idTipoGastoEspontaneo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGastoEspontaneo != null ? idGastoEspontaneo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GastoEspontaneo)) {
            return false;
        }
        GastoEspontaneo other = (GastoEspontaneo) object;
        if ((this.idGastoEspontaneo == null && other.idGastoEspontaneo != null) || (this.idGastoEspontaneo != null && !this.idGastoEspontaneo.equals(other.idGastoEspontaneo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datos.entidades.GastoEspontaneo[ idGastoEspontaneo=" + idGastoEspontaneo + " ]";
    }
    
}
