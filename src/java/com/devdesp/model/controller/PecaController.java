/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdesp.model.controller;

import com.devdesp.model.dao.ManagerDao;
import com.devdesp.model.negocio.Peca;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author lepf9
 */

@ManagedBean(name = "pcController")
@SessionScoped
public class PecaController {
    
    private Peca modelo;
    private Peca selPeca;
    
    @PostConstruct
    public void init(){
        this.modelo = new Peca();
    }
    
    public String inserir(){
        
        ManagerDao.getCurrentInstance().insert(this.modelo);
        
        this.modelo = new Peca();
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Peca cadastrado com sucesso!"));
        
        return "ApresentaPeca";
    }
    
    public List<Peca> readAllPeca(){
        this.selPeca = null;
        
        List<Peca> tipos = ManagerDao.getCurrentInstance()
                .read("select pc from Peca pc", 
                        Peca.class);
        return tipos;
    }
    
    public String alterar(){
        
        ManagerDao.getCurrentInstance().update(this.selPeca);
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Peca alterado com sucesso!"));
        
        return "ApresentaPeca";
        
    }
    
    public void deletar(){
        ManagerDao.getCurrentInstance().delete(this.selPeca);
    
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Peca deletado com sucesso!"));
    }

    public Peca getPeca() {
        return modelo;
    }

    public void setPeca(Peca modelo) {
        this.modelo = modelo;
    }

    public Peca getSelPeca() {
        return selPeca;
    }

    public void setSelPeca(Peca selPeca) {
        this.selPeca = selPeca;
    }
    
}
