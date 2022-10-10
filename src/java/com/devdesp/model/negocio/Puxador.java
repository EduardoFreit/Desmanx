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
@Table(name = "puxador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puxador.findAll", query = "SELECT p FROM Puxador p")
    , @NamedQuery(name = "Puxador.findByCpf", query = "SELECT p FROM Puxador p WHERE p.cpf = :cpf")
    , @NamedQuery(name = "Puxador.findByNome", query = "SELECT p FROM Puxador p WHERE p.nome = :nome")
    , @NamedQuery(name = "Puxador.findBySobrenome", query = "SELECT p FROM Puxador p WHERE p.sobrenome = :sobrenome")
    , @NamedQuery(name = "Puxador.findByTelefone", query = "SELECT p FROM Puxador p WHERE p.telefone = :telefone")
    , @NamedQuery(name = "Puxador.findByEndereco", query = "SELECT p FROM Puxador p WHERE p.endereco = :endereco")
    , @NamedQuery(name = "Puxador.findByEnderecoMae", query = "SELECT p FROM Puxador p WHERE p.enderecoMae = :enderecoMae")
    , @NamedQuery(name = "Puxador.findByQuantidadePrisoes", query = "SELECT p FROM Puxador p WHERE p.quantidadePrisoes = :quantidadePrisoes")
    , @NamedQuery(name = "Puxador.findByAnosExperiencia", query = "SELECT p FROM Puxador p WHERE p.anosExperiencia = :anosExperiencia")
    , @NamedQuery(name = "Puxador.findById", query = "SELECT p FROM Puxador p WHERE p.id = :id")})
public class Puxador implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "sobrenome")
    private String sobrenome;
    @Basic(optional = false)
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @Column(name = "endereco_mae")
    private String enderecoMae;
    @Basic(optional = false)
    @Column(name = "quantidade_prisoes")
    private int quantidadePrisoes;
    @Basic(optional = false)
    @Column(name = "anos_experiencia")
    private int anosExperiencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPuxador", fetch = FetchType.LAZY)
    private Collection<Cabrito> cabritoCollection;

    public Puxador() {
    }

    public Puxador(Integer id) {
        this.id = id;
    }

    public Puxador(Integer id, String cpf, String nome, String sobrenome, String telefone, String endereco, String enderecoMae, int quantidadePrisoes, int anosExperiencia) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.enderecoMae = enderecoMae;
        this.quantidadePrisoes = quantidadePrisoes;
        this.anosExperiencia = anosExperiencia;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEnderecoMae() {
        return enderecoMae;
    }

    public void setEnderecoMae(String enderecoMae) {
        this.enderecoMae = enderecoMae;
    }

    public int getQuantidadePrisoes() {
        return quantidadePrisoes;
    }

    public void setQuantidadePrisoes(int quantidadePrisoes) {
        this.quantidadePrisoes = quantidadePrisoes;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof Puxador)) {
            return false;
        }
        Puxador other = (Puxador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.devdesp.model.negocio.Puxador[ id=" + id + " ]";
    }
    
}
