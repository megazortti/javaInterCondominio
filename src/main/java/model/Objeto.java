/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Morador;

/**
 *
 * @author biaca
 */
public class Objeto {
    private int idObjeto;
    private String descricao;
    private double peso;
    private Morador donoObjeto;
    private String state;
    // ENTREGUE = ENTREGUE AO DESTINATARIO
    // RECEBIDO = RECEBIDO PELA PORTARIA

    /**
     * @return the idObjeto
     */
    public int getIdObjeto() {
        return idObjeto;
    }

    /**
     * @param idObjeto the idObjeto to set
     */
    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the donoObjeto
     */
    public Morador getDonoObjeto() {
        return donoObjeto;
    }

    /**
     * @param donoObjeto the donoObjeto to set
     */
    public void setDonoObjeto(Morador m) {
        this.donoObjeto = m;
    }
    public void setState(String s){
        this.state = s;
    }
    public String getState(){
        return this.state;
    }
}

