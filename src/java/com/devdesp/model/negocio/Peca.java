/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdesp.model.negocio;

import java.io.Serializable;
import java.util.Collection;
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
 * @author lepf9
 */
@Entity
@Table(name = "peca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Peca.findAll", query = "SELECT p FROM Peca p")
    , @NamedQuery(name = "Peca.findById", query = "SELECT p FROM Peca p WHERE p.id = :id")
    , @NamedQuery(name = "Peca.findByNome", query = "SELECT p FROM Peca p WHERE p.nome = :nome")
    , @NamedQuery(name = "Peca.findByFuncao", query = "SELECT p FROM Peca p WHERE p.funcao = :funcao")
    , @NamedQuery(name = "Peca.findByTipo", query = "SELECT p FROM Peca p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "Peca.findByObs", query = "SELECT p FROM Peca p WHERE p.obs = :obs")})
public class Peca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "funcao")
    private String funcao;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "obs")
    private String obs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPeca", fetch = FetchType.LAZY)
    private Collection<ItemPeca> itemPecaCollection;

    public Peca() {
    }

    public Peca(Integer id) {
        this.id = id;
    }

    public Peca(Integer id, String nome, String funcao, String tipo, String obs) {
        this.id = id;
        this.nome = nome;
        this.funcao = funcao;
        this.tipo = tipo;
        this.obs = obs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
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
        if (!(object instanceof Peca)) {
            return false;
        }
        Peca other = (Peca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.devdesp.model.negocio.Peca[ id=" + id + " ]";
    }
    
}
