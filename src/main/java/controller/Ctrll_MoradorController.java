package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Morador;
import model.Pessoa;
import model._Morador;
import model.database.ConnectionBD;

/**
 * FXML Controller class
 *
 * @author mazzo
 */



public class Ctrll_MoradorController implements Initializable {
    ObservableList obsList = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @FXML
    private ListView<String> lista;
    @FXML
    private TextField id_morador;
    @FXML
    private TextField nome_morador;
    @FXML
    private TextField cpf_morador;
    @FXML
    private TextField casa_morador;
    @FXML
    private TextField tipo_morador;
    @FXML
    private TextField nascimento_morador;
    @FXML
    private Button btnBuscar;
    
    
    public void Buscar(){
            Morador morador = new Morador();
            ConnectionBD bd = new ConnectionBD(); // 
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(bd.url,bd.user,bd.pass);
            System.out.println(conn);
            Statement selectStmt = conn.createStatement();
            String _query = String.format("SELECT * FROM morador WHERE id_morador = %s", id_morador.getText());
            ResultSet rs = selectStmt.executeQuery(_query);
            while(rs.next()) //
            {
                morador.setId(rs.getInt(1));
                morador.setCpf(rs.getString(2)); // retorna o CPF
                morador.setNome_completo(rs.getString(3)); // Retorna o nome completo
                System.out.println(rs.getDate(4).toString());
                morador.setDataNascimento(rs.getDate(4).toString()); // retorna a data de nascimento;;
                morador.setNumCasa(rs.getInt(5)); // retornao numero da casa do morador
                Pessoa.sexo sex;
                if(rs.getString(6).equals("Masculino")){ // retorna o sexo do morador
                    sex=Pessoa.sexo.Masculino;
                }else{
                    sex=Pessoa.sexo.Feminino;
                }
                morador.setSexo(sex);
                
                Morador.tipoMorador tpMorador;
                if(rs.getString(7).equals("Proprietário")){ // retorna o tipo do morador.
                    tpMorador = Morador.tipoMorador.Proprietário;
                }else if(rs.getString(7).equals("Morador")){
                    tpMorador = Morador.tipoMorador.Morador;
                }else{
                    tpMorador = Morador.tipoMorador.Inquilino;
                }
                nome_morador.setText(morador.getNome_completo());
                cpf_morador.setText(morador.getCpf());
                casa_morador.setText(String.valueOf(morador.getNumCasa()));
                tipo_morador.setText(rs.getString(7));
                String nascimento = rs.getDate(4).toString();
                nascimento_morador.setText(nascimento);


            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ctrll_MoradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    @FXML
    public void Cadastrar(){
        System.out.println("BOTAO CADASTRAR PRESSIONADO!");
    }
    public void Deletar(){
        System.out.println("BOTAO DELETAR PRESSIONADO!");
    }
    
    @Override

    public void initialize(URL url, ResourceBundle rb) {
       
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
                morador.setId(rs.getInt(1));
                morador.setCpf(rs.getString(2)); // retorna o CPF
                morador.setNome_completo(rs.getString(3)); // Retorna o nome completo
                morador.setDataNascimento(rs.getString(4).toString()); // retorna a data de nascimento;;
                morador.setNumCasa(rs.getInt(5)); // retornao numero da casa do morador
                Pessoa.sexo sex;
                if(rs.getString(6).equals("Masculino")){ // retorna o sexo do morador
                    sex=Pessoa.sexo.Masculino;
                }else{
                    sex=Pessoa.sexo.Feminino;
                }
                morador.setSexo(sex);
                
                Morador.tipoMorador tpMorador;
                if(rs.getString(7).equals("Proprietário")){ // retorna o tipo do morador.
                    tpMorador = Morador.tipoMorador.Proprietário;
                }else if(rs.getString(7).equals("Morador")){
                    tpMorador = Morador.tipoMorador.Morador;
                }else{
                    tpMorador = Morador.tipoMorador.Inquilino;
                }
                obsList.add("|"+morador.getId() + "| -> " + morador.getNome_completo());


            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
            bd.state="Unconnected";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ctrll_MoradorController.class.getName()).log(Level.SEVERE, null, ex);
        }

        lista.getItems().addAll(obsList);
        System.out.println("FORM MORADOR INICIALIZADO!");
    }    
    
}
