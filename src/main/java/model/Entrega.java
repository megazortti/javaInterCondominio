/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author biaca
 */
public class Entrega {
    private int idMorador;
    private int idPorteiro;
    private int idObjeto;
    private String dataEntrega;
    private String dataRecebido;

    /**
     * @return the idMorador
     */
    public int getIdMorador() {
        return idMorador;
    }

    /**
     * @param idMorador the idMorador to set
     */
    public void setIdMorador(int idMorador) {
        this.idMorador = idMorador;
    }

    /**
     * @return the idPorteiro
     */
    public int getIdPorteiro() {
        return idPorteiro;
    }

    /**
     * @param idPorteiro the idPorteiro to set
     */
    public void setIdPorteiro(int idPorteiro) {
        this.idPorteiro = idPorteiro;
    }

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
     * @return the dataEntrega
     */
    public String getDataEntrega() {
        return dataEntrega;
    }

    /**
     * @param dataEntrega the dataEntrega to set
     */
    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    /**
     * @return the dataRecebido
     */
    public String getDataRecebido() {
        return dataRecebido;
    }

    /**
     * @param dataRecebido the dataRecebido to set
     */
    public void setDataRecebido(String dataRecebido) {
        this.dataRecebido = dataRecebido;
    }
}
