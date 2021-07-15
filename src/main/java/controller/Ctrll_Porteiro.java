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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Pessoa;
import model.Porteiro;
import model.database.ConnectionBD;

/**
 * FXML Controller class
 *
 * @author biaca
 */
public class Ctrll_Porteiro implements Initializable {
    ObservableList obsList = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ListView<String> lista;
    @FXML
    private TextField id_porteiro;
    @FXML
    private TextField nome_porteiro;
    @FXML
    private TextField cpf_porteiro;
    @FXML
    private TextField nascimento_porteiro;
    @FXML
    private Button btnBuscar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Porteiro porteiro = new Porteiro();
        ConnectionBD bd = new ConnectionBD(); // 
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(bd.url,bd.user,bd.pass);
            System.out.println(conn);
            Statement selectStmt = conn.createStatement();
            bd.state="Connected"; // se chegou aqui, é porque a conexão obteve sucesso.
            String _query = String.format("SELECT * FROM porteiro");
            ResultSet rs = selectStmt.executeQuery(_query);
            while(rs.next()) //
            {
                porteiro.setIdPorteiro(rs.getInt(1));
                porteiro.setCpf(rs.getString(2)); // retorna o CPF
                porteiro.setNome_completo(rs.getString(3)); // Retorna o nome completo
                porteiro.setDataNascimento(rs.getString(4).toString()); // retorna a data de nascimento;;
                Pessoa.sexo sex;
                if(rs.getString(5).equals("Masculino")){ // retorna o sexo do morador
                    sex=Pessoa.sexo.Masculino;
                }else{
                    sex=Pessoa.sexo.Feminino;
                }
                porteiro.setSexo(sex);
                
                obsList.add("|"+porteiro.getIdPorteiro() + "| -> " + porteiro.getNome_completo());


            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
            bd.state="Unconnected";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ctrll_MoradorController.class.getName()).log(Level.SEVERE, null, ex);
        }

        lista.getItems().addAll(obsList);
        System.out.println("FORM PORTEIRO INICIALIZADO!");
    }
    

    @FXML
    public void Buscar() {
        Porteiro porteiro = new Porteiro();
            ConnectionBD bd = new ConnectionBD(); // 
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(bd.url,bd.user,bd.pass);
            System.out.println(conn);
            Statement selectStmt = conn.createStatement();
            String _query = String.format("SELECT * FROM porteiro WHERE id_porteiro = '%s'", id_porteiro.getText());
            ResultSet rs = selectStmt.executeQuery(_query);
            if(rs.next()) //
            {
                porteiro.setIdPorteiro(rs.getInt(1));
                porteiro.setCpf(rs.getString(2)); // retorna o CPF
                porteiro.setNome_completo(rs.getString(3)); // Retorna o nome completo
                porteiro.setDataNascimento(rs.getDate(4).toString()); // retorna a data de nascimento;;
                Pessoa.sexo sex;
                if(rs.getString(5).equals("Masculino")){ // retorna o sexo do morador
                    sex=Pessoa.sexo.Masculino;
                }else{
                    sex=Pessoa.sexo.Feminino;
                }
                porteiro.setSexo(sex);
                
                nome_porteiro.setText(porteiro.getNome_completo());
                cpf_porteiro.setText(porteiro.getCpf());
                String nascimento = rs.getDate(4).toString();
                nascimento_porteiro.setText(nascimento);

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
