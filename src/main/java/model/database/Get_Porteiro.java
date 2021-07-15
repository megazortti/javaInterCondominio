/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import model.Porteiro;
import model.database.ConnectionBD;

public class Get_Porteiro {
    String state="Unlogged";
    public Porteiro get_porteiro(String cpf, String senha) throws ClassNotFoundException, SQLException{
        Porteiro porteiro = new Porteiro();
        ConnectionBD bd = new ConnectionBD(); // 
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(bd.url,bd.user,bd.pass);
            System.out.println(conn);
            Statement selectStmt = conn.createStatement();
            bd.state="Connected"; // se chegou aqui, é porque a conexão obteve sucesso.
            String _query = String.format("SELECT * FROM porteiro WHERE cpf='%s' AND senha = '%s'",cpf,senha);
            ResultSet rs = selectStmt.executeQuery(_query);
            if(rs.next()) //
            {
                porteiro.setCpf(rs.getString(1)); // retorna o CPF
                porteiro.setNome_completo(rs.getString(2)); // Retorna o nome completo
                porteiro.setDataNascimento(rs.getString(3)); // retorna a data de nascimento
                porteiro.setSenha(rs.getString(4)); // Retorna a senha do Porteiro

                this.state="Logged";
            }else{
                this.state="Unlogged";
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
            bd.state="Unconnected";
        }
        return porteiro;

    }
    public String getState(){ 
        return this.state;
    }
    // Não deve ter set..
}
