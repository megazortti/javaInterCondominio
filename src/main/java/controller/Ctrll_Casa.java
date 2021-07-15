/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Casa;
import model.Pessoa;
import model.Porteiro;
import model.database.ConnectionBD;

/**
 * FXML Controller class
 *
 * @author biaca
 */
public class Ctrll_Casa implements Initializable {
    ObservableList obsList = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ListView<String> lista;
    @FXML
    private TextField num_casa;
    @FXML
    private TextField proprietario_casa;
    @FXML
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Casa casa = new Casa();
        ConnectionBD bd = new ConnectionBD(); // 
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(bd.url,bd.user,bd.pass);
            System.out.println(conn);
            Statement selectStmt = conn.createStatement();
            bd.state="Connected"; // se chegou aqui, é porque a conexão obteve sucesso.
            String _query = String.format("SELECT * FROM casa");
            ResultSet rs = selectStmt.executeQuery(_query);
            while(rs.next()) //
            {
                casa.setNumDaCasa(rs.getInt(1));
                casa.setProprietario(rs.getString(2)); 
                
                obsList.add("|"+casa.getNumDaCasa() + "| -> " + casa.getProprietario());

            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
            bd.state="Unconnected";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ctrll_MoradorController.class.getName()).log(Level.SEVERE, null, ex);
        }

        lista.getItems().addAll(obsList);
        System.out.println("FORM CASA INICIALIZADO!");
    }   
    
    @FXML
    public void Buscar() {
        Casa casa = new Casa();
            ConnectionBD bd = new ConnectionBD(); // 
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(bd.url,bd.user,bd.pass);
            System.out.println(conn);
            Statement selectStmt = conn.createStatement();
            String _query = String.format("SELECT * FROM casa WHERE numero_casa = '%s'", num_casa.getText());
            ResultSet rs = selectStmt.executeQuery(_query);
            if(rs.next()) //
            {
                casa.setNumDaCasa(rs.getInt(1));
                casa.setProprietario(rs.getString(2));

            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ctrll_MoradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @FXML
    public void Cadastrar() {
        System.out.print("Cadastro");
    }
    
    @FXML
    public void Deletar() {
        System.out.print("Deleçao");
    }
    
}
