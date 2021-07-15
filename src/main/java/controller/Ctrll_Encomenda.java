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
import model.Entrega;
import model.Pessoa;
import model.Porteiro;
import model.database.ConnectionBD;

/**
 * FXML Controller class
 *
 * @author biaca
 */
public class Ctrll_Encomenda implements Initializable {
    ObservableList obsList = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ListView<String> lista;
    @FXML
    private TextField id_encomenda;
    @FXML
    private TextField porteiroRecebeu;
    @FXML
    private TextField dataRecebidoEncomenda;
    @FXML
    private TextField porteiroEntregou;
    @FXML
    private TextField dataEntregaEncomenda;
    @FXML
    private TextField donoEncomenda;
    @FXML
    private TextField numero_casa;
    @FXML
    
    public void iniciar_lista(){
        obsList.clear();
        Entrega encomenda = new Entrega();
            ConnectionBD bd = new ConnectionBD(); // 

            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(bd.url,bd.user,bd.pass);
                System.out.println(conn);
                Statement selectStmt = conn.createStatement();
                bd.state="Connected"; // se chegou aqui, é porque a conexão obteve sucesso.
                String _query = String.format("SELECT * FROM encomenda");
                ResultSet rs = selectStmt.executeQuery(_query);
                while(rs.next()) 
                {
                    encomenda.setIdObjeto(rs.getInt(1));
                    encomenda.setIdPorteiroRecebeu(rs.getInt(2));
                    encomenda.setIdPorteiroEntregou(rs.getInt(3));
                    encomenda.setDataRecebido(rs.getDate(4).toString());
                    encomenda.setDataEntrega(rs.getDate(5).toString());
                    encomenda.setDonoEncomenda(rs.getString(6));
                    encomenda.setNumeroCasa(rs.getInt(7));                    

                    obsList.add("|"+encomenda.getIdObjeto() + "| -> " + encomenda.getDonoEncomenda());

                }

            } catch (SQLException ex) {
                Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
                bd.state="Unconnected";
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Ctrll_MoradorController.class.getName()).log(Level.SEVERE, null, ex);
            }

            lista.getItems().addAll(obsList);
            System.out.println("FORM ENCOMENDA INICIALIZADO!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciar_lista();
    }    
    
    
    @FXML
    public void Buscar() {
        Entrega encomenda = new Entrega();
            ConnectionBD bd = new ConnectionBD(); // 
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(bd.url,bd.user,bd.pass);
            System.out.println(conn);
            Statement selectStmt = conn.createStatement();
            String _query = String.format("SELECT * FROM encomenda WHERE id_encomenda = '%s'", id_encomenda.getText());
            ResultSet rs = selectStmt.executeQuery(_query);
            if(rs.next()) //
            {
                encomenda.setIdObjeto(rs.getInt(1));
                encomenda.setIdPorteiroRecebeu(rs.getInt(2));
                //encomenda.setIdPorteiroEntregou(rs.getInt(3));
                encomenda.setDataRecebido(rs.getDate(4).toString());
                //encomenda.setDataEntrega(rs.getDate(5).toString());
                encomenda.setDonoEncomenda(rs.getString(6));
                encomenda.setNumeroCasa(rs.getInt(7)); 
                
                porteiroRecebeu.setText(String.valueOf(encomenda.getIdPorteiroRecebeu()));
                dataRecebidoEncomenda.setText(encomenda.getDataRecebido());
                donoEncomenda.setText(encomenda.getDonoEncomenda());
                numero_casa.setText(String.valueOf(encomenda.getNumeroCasa()));

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
    public void Entregue() {
        System.out.print("Entregue");
    }
}
