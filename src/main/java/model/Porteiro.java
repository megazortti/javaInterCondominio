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
public class Porteiro extends Pessoa{
    private int idPorteiro;
    private String dataNascimento;
    private String senha;
    private String cpf;
	
    @Override
    public String getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
