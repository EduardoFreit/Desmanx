/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdesp.model.negocio;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lepf9
 */
@Entity
@Table(name = "cabrito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cabrito.findAll", query = "SELECT c FROM Cabrito c")
    , @NamedQuery(name = "Cabrito.findById", query = "SELECT c FROM Cabrito c WHERE c.id = :id")
    , @NamedQuery(name = "Cabrito.findByPlaca", query = "SELECT c FROM Cabrito c WHERE c.placa = :placa")
    , @NamedQuery(name = "Cabrito.findByChassi", query = "SELECT c FROM Cabrito c WHERE c.chassi = :chassi")
    , @NamedQuery(name = "Cabrito.findByNumPortas", query = "SELECT c FROM Cabrito c WHERE c.numPortas = :numPortas")
    , @NamedQuery(name = "Cabrito.findByCor", query = "SELECT c FROM Cabrito c WHERE c.cor = :cor")
    , @NamedQuery(name = "Cabrito.findByTipoCambio", query = "SELECT c FROM Cabrito c WHERE c.tipoCambio = :tipoCambio")
    , @NamedQuery(name = "Cabrito.findByTipoCombustivel", query = "SELECT c FROM Cabrito c WHERE c.tipoCombustivel = :tipoCombustivel")
    , @NamedQuery(name = "Cabrito.findByObs", query = "SELECT c FROM Cabrito c WHERE c.obs = :obs")
    , @NamedQuery(name = "Cabrito.findByDataRoubo", query = "SELECT c FROM Cabrito c WHERE c.dataRoubo = :dataRoubo")})
public class Cabrito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "placa")
    private String placa;
    @Basic(optional = false)
    @Column(name = "chassi")
    private String chassi;
    @Column(name = "num_portas")
    private Integer numPortas;
    @Basic(optional = false)
    @Column(name = "cor")
    private String cor;
    @Basic(optional = false)
    @Column(name = "tipo_cambio")
    private String tipoCambio;
    @Basic(optional = false)
    @Column(name = "tipo_combustivel")
    private String tipoCombustivel;
    @Column(name = "obs")
    private String obs;
    @Basic(optional = false)
    @Column(name = "data_roubo")
    @Temporal(TemporalType.DATE)
    private Date dataRoubo;
    @JoinColumn(name = "id_desmanx", referencedColumnName = "id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Desmanx idDesmanx;
    @JoinColumn(name = "id_modelo", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Modelo idModelo;
    @JoinColumn(name = "id_puxador", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Puxador idPuxador;

    public Cabrito() {
    }

    public Cabrito(Integer id) {
        this.id = id;
    }

    public Cabrito(Integer id, String placa, String chassi, String cor, String tipoCambio, String tipoCombustivel, Date dataRoubo) {
        this.id = id;
        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
        this.tipoCambio = tipoCambio;
        this.tipoCombustivel = tipoCombustivel;
        this.dataRoubo = dataRoubo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Integer getNumPortas() {
        return numPortas;
    }

    public void setNumPortas(Integer numPortas) {
        this.numPortas = numPortas;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getDataRoubo() {
        return dataRoubo;
    }

    public void setDataRoubo(Date dataRoubo) {
        this.dataRoubo = dataRoubo;
    }

    public Desmanx getIdDesmanx() {
        return idDesmanx;
    }

    public void setIdDesmanx(Desmanx idDesmanx) {
        this.idDesmanx = idDesmanx;
    }

    public Modelo getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelo idModelo) {
        this.idModelo = idModelo;
    }

    public Puxador getIdPuxador() {
        return idPuxador;
    }

    public void setIdPuxador(Puxador idPuxador) {
        this.idPuxador = idPuxador;
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
        if (!(object instanceof Cabrito)) {
            return false;
        }
        Cabrito other = (Cabrito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.devdesp.model.negocio.Cabrito[ id=" + id + " ]";
    }
    
}
