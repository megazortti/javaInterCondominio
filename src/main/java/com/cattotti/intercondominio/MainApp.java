package com.cattotti.intercondominio;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.database.Get_Porteiro;
import model.Porteiro;
import model.Morador;
import model.database.Get_Moradores;


public class MainApp extends Application {

    
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("/view/frm_Login.fxml"));

        Parent root = FXMLLoader.load(getClass().getResource("/view/frm_Main.fxml"));
                
        Scene scene = new Scene(root);
        
        stage.setTitle("InterCondomínio - Login");
        stage.setScene(scene);

        stage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }

}
