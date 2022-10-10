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
@Table(name = "modelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modelo.findAll", query = "SELECT m FROM Modelo m")
    , @NamedQuery(name = "Modelo.findById", query = "SELECT m FROM Modelo m WHERE m.id = :id")
    , @NamedQuery(name = "Modelo.findByNome", query = "SELECT m FROM Modelo m WHERE m.nome = :nome")
    , @NamedQuery(name = "Modelo.findByFabricante", query = "SELECT m FROM Modelo m WHERE m.fabricante = :fabricante")
    , @NamedQuery(name = "Modelo.findByTipo", query = "SELECT m FROM Modelo m WHERE m.tipo = :tipo")
    , @NamedQuery(name = "Modelo.findByPotenciaMotor", query = "SELECT m FROM Modelo m WHERE m.potenciaMotor = :potenciaMotor")
    , @NamedQuery(name = "Modelo.findByCilindradaMotor", query = "SELECT m FROM Modelo m WHERE m.cilindradaMotor = :cilindradaMotor")})
public class Modelo implements Serializable {

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
    @Column(name = "fabricante")
    private String fabricante;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "potencia_motor")
    private int potenciaMotor;
    @Basic(optional = false)
    @Column(name = "cilindrada_motor")
    private int cilindradaMotor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModelo", fetch = FetchType.LAZY)
    private Collection<Cabrito> cabritoCollection;

    public Modelo() {
    }

    public Modelo(Integer id) {
        this.id = id;
    }

    public Modelo(Integer id, String nome, String fabricante, String tipo, int potenciaMotor, int cilindradaMotor) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.tipo = tipo;
        this.potenciaMotor = potenciaMotor;
        this.cilindradaMotor = cilindradaMotor;
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

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(int potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    public int getCilindradaMotor() {
        return cilindradaMotor;
    }

    public void setCilindradaMotor(int cilindradaMotor) {
        this.cilindradaMotor = cilindradaMotor;
    }

    @XmlTransient
    public Collection<Cabrito> getCabritoCollection() {
        return cabritoCollection;
    }

    public void setCabritoCollection(Collection<Cabrito> cabritoCollection) {
        this.cabritoCollection = cabritoCollection;
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
        if (!(object instanceof Modelo)) {
            return false;
        }
        Modelo other = (Modelo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.devdesp.model.negocio.Modelo[ id=" + id + " ]";
    }
    
}
