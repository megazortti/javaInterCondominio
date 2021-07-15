/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Porteiro;
import model.Porteiro;

/**
 *
 * @author mazzo
 */
public class ConnectionBD { // Header da conexão
    public String state; // Por convenção, Connected ou Unconnected.
    public String url="jdbc:mysql://localhost:3306/banco?useTimezone=true&serverTimezone=UTC";
    public String user ="root";
    public String pass ="music4ever";
}


