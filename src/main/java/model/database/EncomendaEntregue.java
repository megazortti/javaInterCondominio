/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import controller.Ctrll_Encomenda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Entrega;

/**
 *
 * @author biaca
 */
public class EncomendaEntregue {
    public EncomendaEntregue(Entrega encomenda){ // utilizar a conexão recebida para cadastrar um dado usuário
            ConnectionBD bd = new ConnectionBD(); // 
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(bd.url,bd.user,bd.pass);
            System.out.println(conn);
            Statement selectStmt = conn.createStatement();
            String _query = String.format("INSERT INTO encomenda(porteiro_entregou,data_entregue) VALUES('%d', '%s');",encomenda.getIdPorteiroEntregou(), encomenda.getDataEntrega());
            selectStmt.executeUpdate(_query);
           
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ctrll_Encomenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
