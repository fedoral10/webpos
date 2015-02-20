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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CIERRE_CAJA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CierreCaja.findAll", query = "SELECT c FROM CierreCaja c"),
    @NamedQuery(name = "CierreCaja.findByIdCierreCaja", query = "SELECT c FROM CierreCaja c WHERE c.idCierreCaja = :idCierreCaja"),
    @NamedQuery(name = "CierreCaja.findByMontoTotalCierre", query = "SELECT c FROM CierreCaja c WHERE c.montoTotalCierre = :montoTotalCierre")})
public class CierreCaja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CIERRE_CAJA")
    private Long idCierreCaja;
    @Basic(optional = false)
    @Column(name = "MONTO_TOTAL_CIERRE")
    private long montoTotalCierre;
    @OneToMany(mappedBy = "idCierreCaja", fetch = FetchType.LAZY)
    private List<DetalleCierreCaja> detalleCierreCajaList;
    @JoinColumn(name = "ID_CAJA", referencedColumnName = "ID_CAJA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Caja idCaja;

    public CierreCaja() {
    }

    public CierreCaja(Long idCierreCaja) {
        this.idCierreCaja = idCierreCaja;
    }

    public CierreCaja(Long idCierreCaja, long montoTotalCierre) {
        this.idCierreCaja = idCierreCaja;
        this.montoTotalCierre = montoTotalCierre;
    }

    public Long getIdCierreCaja() {
        return idCierreCaja;
    }

    public void setIdCierreCaja(Long idCierreCaja) {
        this.idCierreCaja = idCierreCaja;
    }

    public long getMontoTotalCierre() {
        return montoTotalCierre;
    }

    public void setMontoTotalCierre(long montoTotalCierre) {
        this.montoTotalCierre = montoTotalCierre;
    }

    @XmlTransient
    public List<DetalleCierreCaja> getDetalleCierreCajaList() {
        return detalleCierreCajaList;
    }

    public void setDetalleCierreCajaList(List<DetalleCierreCaja> detalleCierreCajaList) {
        this.detalleCierreCajaList = detalleCierreCajaList;
    }

    public Caja getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(Caja idCaja) {
        this.idCaja = idCaja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCierreCaja != null ? idCierreCaja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CierreCaja)) {
            return false;
        }
        CierreCaja other = (CierreCaja) object;
        if ((this.idCierreCaja == null && other.idCierreCaja != null) || (this.idCierreCaja != null && !this.idCierreCaja.equals(other.idCierreCaja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datos.entidades.CierreCaja[ idCierreCaja=" + idCierreCaja + " ]";
    }
    
}
