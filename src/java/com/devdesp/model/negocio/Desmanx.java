/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdesp.model.negocio;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lepf9
 */
@Entity
@Table(name = "desmanx")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Desmanx.findAll", query = "SELECT d FROM Desmanx d")
    , @NamedQuery(name = "Desmanx.findById", query = "SELECT d FROM Desmanx d WHERE d.id = :id")
    , @NamedQuery(name = "Desmanx.findByDataDesmanche", query = "SELECT d FROM Desmanx d WHERE d.dataDesmanche = :dataDesmanche")
    , @NamedQuery(name = "Desmanx.findByQuemRoubou", query = "SELECT d FROM Desmanx d WHERE d.quemRoubou = :quemRoubou")})
public class Desmanx implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "data_desmanche")
    @Temporal(TemporalType.DATE)
    private Date dataDesmanche;
    @Basic(optional = false)
    @Column(name = "quem_roubou")
    private String quemRoubou;
    @JoinColumn(name = "id_cabrito", referencedColumnName = "id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Cabrito idCabrito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDesmanx", fetch = FetchType.LAZY)
    private Collection<ItemPeca> itemPecaCollection;

    public Desmanx() {
    }

    public Desmanx(Integer id) {
        this.id = id;
    }

    public Desmanx(Integer id, Date dataDesmanche, String quemRoubou) {
        this.id = id;
        this.dataDesmanche = dataDesmanche;
        this.quemRoubou = quemRoubou;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataDesmanche() {
        return dataDesmanche;
    }

    public void setDataDesmanche(Date dataDesmanche) {
        this.dataDesmanche = dataDesmanche;
    }

    public String getQuemRoubou() {
        return quemRoubou;
    }

    public void setQuemRoubou(String quemRoubou) {
        this.quemRoubou = quemRoubou;
    }

    public Cabrito getIdCabrito() {
        return idCabrito;
    }

    public void setIdCabrito(Cabrito idCabrito) {
        this.idCabrito = idCabrito;
    }

    @XmlTransient
    public Collection<ItemPeca> getItemPecaCollection() {
        return itemPecaCollection;
    }

    public void setItemPecaCollection(Collection<ItemPeca> itemPecaCollection) {
        this.itemPecaCollection = itemPecaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desmanx)) {
            return false;
        }
        Desmanx other = (Desmanx) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.devdesp.model.negocio.Desmanx[ id=" + id + " ]";
    }
    
}
