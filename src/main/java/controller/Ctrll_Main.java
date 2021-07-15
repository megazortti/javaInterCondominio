/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.PieChartModel;

/**
 * FXML Controller class
 *
 * @author mazzo
 */
public class Ctrll_Main implements Initializable {
    @FXML
    private PieChart pieChart;
    @FXML
    private Button btnCadastrarMorador;
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void iniciar_morador() throws IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/frm_Morador.fxml"));
        Scene scene = new Scene(root);  
        stage.setTitle("InterCondomínio - Morador");
        stage.setScene(scene);
//        Stage actualStage = (Stage) pieChart.getScene().getWindow(); // Apenas pegando a cena atual..
//        actualStage.close();
        stage.show();
    }
    @FXML
    private void iniciar_porteiro() throws IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/frm_Porteiro.fxml"));
        Scene scene = new Scene(root);  
        stage.setTitle("InterCondomínio - Porteiro");
        stage.setScene(scene);
//        Stage actualStage = (Stage) pieChart.getScene().getWindow(); // Apenas pegando a cena atual..;;
//        actualStage.close();
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PieChartModel pcc = new PieChartModel();
        pcc.setNumFuncionarios(22);
        pcc.setNumMoradores(88);
        pcc.initialize(pieChart);
         
        
    }    
}
