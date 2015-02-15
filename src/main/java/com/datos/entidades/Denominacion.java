/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datos.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "DENOMINACION")
@NamedQueries({
    @NamedQuery(name = "Denominacion.findAll", query = "SELECT d FROM Denominacion d")})
public class Denominacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DENOMINACION")
    private Long idDenominacion;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTO")
    private BigDecimal monto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "denominacion")
    private List<DetalleCierreCaja> detalleCierreCajaList;

    public Denominacion() {
    }

    public Denominacion(Long idDenominacion) {
        this.idDenominacion = idDenominacion;
    }

    public Long getIdDenominacion() {
        return idDenominacion;
    }

    public void setIdDenominacion(Long idDenominacion) {
        this.idDenominacion = idDenominacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public List<DetalleCierreCaja> getDetalleCierreCajaList() {
        return detalleCierreCajaList;
    }

    public void setDetalleCierreCajaList(List<DetalleCierreCaja> detalleCierreCajaList) {
        this.detalleCierreCajaList = detalleCierreCajaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDenominacion != null ? idDenominacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Denominacion)) {
            return false;
        }
        Denominacion other = (Denominacion) object;
        if ((this.idDenominacion == null && other.idDenominacion != null) || (this.idDenominacion != null && !this.idDenominacion.equals(other.idDenominacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datos.entidades.Denominacion[ idDenominacion=" + idDenominacion + " ]";
    }
    
}
