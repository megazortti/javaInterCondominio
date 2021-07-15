/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//
package model.database;
import controller.Ctrll_MoradorController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Morador;
import model.Morador;
import model.database.ConnectionBD;


/**
 *
 * @author mazzo
 */
public class CadastrarMorador{
    public CadastrarMorador(Morador m){ // utilizar a conexão recebida para cadastrar um dado usuário
            ConnectionBD bd = new ConnectionBD(); // 
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(bd.url,bd.user,bd.pass);
            System.out.println(conn);
            Statement selectStmt = conn.createStatement();
            String _query = String.format("INSERT INTO morador(cpf,nome_completo,nascimento,numero_casa,sexo,tipo_morador) VALUES ('%s','%s','%s','%d','%s','%s')",m.getCpf(),m.getNome_completo(),m.getDataNascimento(),m.getNumCasa(),m.getSexo(),m.getTipoMorador());
            selectStmt.executeUpdate(_query);
           
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ctrll_MoradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
