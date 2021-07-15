/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intercondo.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author biaca
 */
public class Ctrll_Encomenda implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    public void Buscar() {
        System.out.print("Busca");
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
