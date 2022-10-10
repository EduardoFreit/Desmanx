/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdesp.model.negocio;

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
 * @author lepf9
 */
@Entity
@Table(name = "item_peca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemPeca.findAll", query = "SELECT i FROM ItemPeca i")
    , @NamedQuery(name = "ItemPeca.findById", query = "SELECT i FROM ItemPeca i WHERE i.id = :id")
    , @NamedQuery(name = "ItemPeca.findByQtd", query = "SELECT i FROM ItemPeca i WHERE i.qtd = :qtd")
    , @NamedQuery(name = "ItemPeca.findByAvaria", query = "SELECT i FROM ItemPeca i WHERE i.avaria = :avaria")})
public class ItemPeca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "qtd")
    private int qtd;
    @Basic(optional = false)
    @Column(name = "avaria")
    private String avaria;
    @JoinColumn(name = "id_desmanx", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Desmanx idDesmanx;
    @JoinColumn(name = "id_peca", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Peca idPeca;

    public ItemPeca() {
    }

    public ItemPeca(Integer id) {
        this.id = id;
    }

    public ItemPeca(Integer id, int qtd, String avaria) {
        this.id = id;
        this.qtd = qtd;
        this.avaria = avaria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getAvaria() {
        return avaria;
    }

    public void setAvaria(String avaria) {
        this.avaria = avaria;
    }

    public Desmanx getIdDesmanx() {
        return idDesmanx;
    }

    public void setIdDesmanx(Desmanx idDesmanx) {
        this.idDesmanx = idDesmanx;
    }

    public Peca getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(Peca idPeca) {
        this.idPeca = idPeca;
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
        if (!(object instanceof ItemPeca)) {
            return false;
        }
        ItemPeca other = (ItemPeca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.devdesp.model.negocio.ItemPeca[ id=" + id + " ]";
    }
    
}
