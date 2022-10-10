/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdesp.model.controller;

import com.devdesp.model.dao.ManagerDao;
import com.devdesp.model.negocio.Modelo;
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

@ManagedBean(name = "mdController")
@SessionScoped
public class ModeloController {
    
    private Modelo modelo;
    private Modelo selModelo;
    
    @PostConstruct
    public void init(){
        this.modelo = new Modelo();
    }
    
    public String inserir(){
        
        ManagerDao.getCurrentInstance().insert(this.modelo);
        
        this.modelo = new Modelo();
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Modelo cadastrado com sucesso!"));
        
        return "ApresentaModelo";
    }
    
    public List<Modelo> readAllModelo(){
        
        List<Modelo> tipos = ManagerDao.getCurrentInstance()
                .read("select md from Modelo md", 
                        Modelo.class);
        return tipos;
    }
    
    public String alterar(){
        
        ManagerDao.getCurrentInstance().update(this.selModelo);
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Modelo alterado com sucesso!"));
        
        return "ApresentaModelo";
        
    }
    
    public void deletar(){
        ManagerDao.getCurrentInstance().delete(this.selModelo);
    
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Modelo deletado com sucesso!"));
    }
    
    public String telaInicial(){
        return "/";
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Modelo getSelModelo() {
        return selModelo;
    }

    public void setSelModelo(Modelo selModelo) {
        this.selModelo = selModelo;
    }
    
}
