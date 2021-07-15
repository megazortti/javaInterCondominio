
//
package model.database;

import controller.Ctrll_Porteiro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Porteiro;
import model.database.ConnectionBD;

public class CadastrarPorteiro{
    public CadastrarPorteiro(Porteiro p){ // utilizar a conexão recebida para cadastrar um dado usuário
            ConnectionBD bd = new ConnectionBD(); // 
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(bd.url,bd.user,bd.pass);
            System.out.println(conn);
            Statement selectStmt = conn.createStatement();
            String _query = String.format("INSERT INTO porteiro(cpf,nomeCompleto,dataNascimento,sexo) VALUES ('%s','%s','%s','%s')",p.getCpf(),p.getNome_completo(),p.getDataNascimento(),p.getSexo());
            selectStmt.executeUpdate(_query);
           
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ctrll_Porteiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}