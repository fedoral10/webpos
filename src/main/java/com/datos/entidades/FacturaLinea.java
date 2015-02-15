/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datos.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "FACTURA_LINEA")
@NamedQueries({
    @NamedQuery(name = "FacturaLinea.findAll", query = "SELECT f FROM FacturaLinea f")})
public class FacturaLinea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FACTURA_LINEA")
    private Long idFacturaLinea;
    @Column(name = "LINEA")
    private Integer linea;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL")
    private BigDecimal total;
    @Column(name = "PRECIO_UNITARIO")
    private BigDecimal precioUnitario;
    @Column(name = "IVA")
    private BigDecimal iva;
    @JoinColumn(name = "ID_ARTICULO", referencedColumnName = "ID_ARTICULO")
    @ManyToOne
    private Articulo idArticulo;
    @JoinColumn(name = "ID_FACTURA", referencedColumnName = "ID_FACTURA")
    @ManyToOne
    private Factura idFactura;

    public FacturaLinea() {
    }

    public FacturaLinea(Long idFacturaLinea) {
        this.idFacturaLinea = idFacturaLinea;
    }

    public Long getIdFacturaLinea() {
        return idFacturaLinea;
    }

    public void setIdFacturaLinea(Long idFacturaLinea) {
        this.idFacturaLinea = idFacturaLinea;
    }

    public Integer getLinea() {
        return linea;
    }

    public void setLinea(Integer linea) {
        this.linea = linea;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public Articulo getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Articulo idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Factura getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Factura idFactura) {
        this.idFactura = idFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacturaLinea != null ? idFacturaLinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaLinea)) {
            return false;
        }
        FacturaLinea other = (FacturaLinea) object;
        if ((this.idFacturaLinea == null && other.idFacturaLinea != null) || (this.idFacturaLinea != null && !this.idFacturaLinea.equals(other.idFacturaLinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datos.entidades.FacturaLinea[ idFacturaLinea=" + idFacturaLinea + " ]";
    }
    
}
