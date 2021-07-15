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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.database.ConnectionBD;
import model.Morador;
import model.Morador.tipoMorador;
import model.Pessoa.sexo;

public class Get_Moradores {
    ObservableList obsList = FXCollections.observableArrayList();
    String state="Unlogged";
    
    public ObservableList get_moradores() throws ClassNotFoundException, SQLException{
        Morador morador = new Morador();
        ConnectionBD bd = new ConnectionBD(); // 
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(bd.url,bd.user,bd.pass);
            System.out.println(conn);
            Statement selectStmt = conn.createStatement();
            bd.state="Connected"; // se chegou aqui, é porque a conexão obteve sucesso.
            String _query = String.format("SELECT * FROM morador");
            ResultSet rs = selectStmt.executeQuery(_query);
            while(rs.next()) //
            {
                morador.setCpf(rs.getString(1)); // retorna o CPF
                morador.setNome_completo(rs.getString(2)); // Retorna o nome completo
                morador.setDataNascimento(rs.getString(3).toString()); // retorna a data de nascimento;;
                morador.setNumCasa(rs.getInt(4)); // retornao numero da casa do morador
                sexo sex;
                if(rs.getString(5).equals("Masculino")){ // retorna o sexo do morador
                    sex=sexo.Masculino;
                }else{
                    sex=sexo.Feminino;
                }
                morador.setSexo(sex);
                
                tipoMorador tpMorador;
                if(rs.getString(6).equals("Proprietário")){ // retorna o tipo do morador.
                    tpMorador = tipoMorador.Proprietário;
                }else if(rs.getString(6).equals("Morador")){
                    tpMorador = tipoMorador.Morador;
                }else{
                    tpMorador = tipoMorador.Inquilino;
                }
                obsList.add(morador);
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
            bd.state="Unconnected";
        }
        return obsList;
        

    }
    public String getState(){ 
        return this.state;
    }
    // Não deve ter set..
}
