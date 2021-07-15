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
    private String donoEncomenda;
    private int numeroCasa;
    private int idPorteiroRecebeu;
    private int idPorteiroEntregou;
    private int idObjeto;
    private String dataEntrega;
    private String dataRecebido;

    /**
     * @return the donoEncomenda
     */
    public String getDonoEncomenda() {
        return donoEncomenda;
    }

    /**
     * @param donoEncomenda the donoEncomenda to set
     */
    public void setDonoEncomenda(String donoEncomenda) {
        this.donoEncomenda = donoEncomenda;
    }

    /**
     * @return the numeroCasa
     */
    public int getNumeroCasa() {
        return numeroCasa;
    }

    /**
     * @param numeroCasa the numeroCasa to set
     */
    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
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

    /**
     * @return the idPorteiroRecebeu
     */
    public int getIdPorteiroRecebeu() {
        return idPorteiroRecebeu;
    }

    /**
     * @param idPorteiroRecebeu the idPorteiroRecebeu to set
     */
    public void setIdPorteiroRecebeu(int idPorteiroRecebeu) {
        this.idPorteiroRecebeu = idPorteiroRecebeu;
    }

    /**
     * @return the idPorteiroEntregou
     */
    public int getIdPorteiroEntregou() {
        return idPorteiroEntregou;
    }

    /**
     * @param idPorteiroEntregou the idPorteiroEntregou to set
     */
    public void setIdPorteiroEntregou(int idPorteiroEntregou) {
        this.idPorteiroEntregou = idPorteiroEntregou;
    }
 
}
