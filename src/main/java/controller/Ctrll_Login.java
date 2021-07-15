/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import model.database.Get_Porteiro;
import model.Porteiro;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.database.ConnectionBD;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author biaca
 */
public class Ctrll_Login implements Initializable {
    @FXML
    private TextField tf_Cpf;
    @FXML
    private TextField tf_Senha;
    @FXML
    private Button btn_Logar;
    
    
    @FXML
    private void logar() throws ClassNotFoundException, SQLException, IOException{
        Get_Porteiro gp = new Get_Porteiro();
        Porteiro p = new Porteiro();
        p = gp.get_porteiro(tf_Cpf.getText(),tf_Senha.getText());
        if(p.getCpf() == null){ // Se cair dentro dessa condição, o usuário não conseguiu logar.
            System.out.println("Não foi encontrado esse usuário.");

        }else{ // Se cair dentro dessa condição, o usuário conseguiu logar.
            System.out.println("Dado seu CPF, seu nome é:"+ p.getNome_completo());
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/view/frm_Main.fxml"));
            Scene scene = new Scene(root);  
            stage.setTitle("InterCondomínio - Login");
            stage.setScene(scene);
            Stage actualStage = (Stage) tf_Cpf.getScene().getWindow(); // Apenas pegando a cena atual..
            actualStage.close();
            stage.show();
            
        }
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
