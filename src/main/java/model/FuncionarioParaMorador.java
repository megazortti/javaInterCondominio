/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import model.Funcionario;
import model.Morador;

/**
 *
 * @author mazzo
 */
public class FuncionarioParaMorador {
    public Morador FuncionarioParaMorador(Funcionario f){
        Morador m = new Morador();
        m.setCpf(f.getCpf());
        m.setNome_completo(f.getNome_completo());
        m.setDataNascimento(f.getDataNascimento());
        return m;
    }
}
