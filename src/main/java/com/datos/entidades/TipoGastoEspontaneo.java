/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datos.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "TIPO_GASTO_ESPONTANEO")
@NamedQueries({
    @NamedQuery(name = "TipoGastoEspontaneo.findAll", query = "SELECT t FROM TipoGastoEspontaneo t")})
public class TipoGastoEspontaneo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_GASTO_ESPONTANEO")
    private Long idTipoGastoEspontaneo;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "idTipoGastoEspontaneo")
    private List<GastoEspontaneo> gastoEspontaneoList;

    public TipoGastoEspontaneo() {
    }

    public TipoGastoEspontaneo(Long idTipoGastoEspontaneo) {
        this.idTipoGastoEspontaneo = idTipoGastoEspontaneo;
    }

    public TipoGastoEspontaneo(Long idTipoGastoEspontaneo, String descripcion) {
        this.idTipoGastoEspontaneo = idTipoGastoEspontaneo;
        this.descripcion = descripcion;
    }

    public Long getIdTipoGastoEspontaneo() {
        return idTipoGastoEspontaneo;
    }

    public void setIdTipoGastoEspontaneo(Long idTipoGastoEspontaneo) {
        this.idTipoGastoEspontaneo = idTipoGastoEspontaneo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<GastoEspontaneo> getGastoEspontaneoList() {
        return gastoEspontaneoList;
    }

    public void setGastoEspontaneoList(List<GastoEspontaneo> gastoEspontaneoList) {
        this.gastoEspontaneoList = gastoEspontaneoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoGastoEspontaneo != null ? idTipoGastoEspontaneo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoGastoEspontaneo)) {
            return false;
        }
        TipoGastoEspontaneo other = (TipoGastoEspontaneo) object;
        if ((this.idTipoGastoEspontaneo == null && other.idTipoGastoEspontaneo != null) || (this.idTipoGastoEspontaneo != null && !this.idTipoGastoEspontaneo.equals(other.idTipoGastoEspontaneo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datos.entidades.TipoGastoEspontaneo[ idTipoGastoEspontaneo=" + idTipoGastoEspontaneo + " ]";
    }
    
}
