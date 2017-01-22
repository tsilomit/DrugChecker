/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.web;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;



public class DB_interaction {

    private static String JDBC_DRIVER;
    private static String DB_URL;

    private static final String DBUSER = "root";
    private static final String DBPASS = "";

    private static Statement db_connect() throws ClassNotFoundException, SQLException {
        JDBC_DRIVER = "com.mysql.jdbc.Driver";
        DB_URL = "jdbc:mysql://localhost:3306/drugchecker";
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(DB_URL, DBUSER, DBPASS);
        Statement stmt = conn.createStatement();
        return stmt;
    }



    public static Map selectAll(String username) throws ClassNotFoundException, SQLException {
        Statement stmt = db_connect();

        String sql = "SELECT * FROM `users` WHERE username='" + username + "'";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);

        Map m = new HashMap();

        while (rs.next()) {
            //Retrieve by column name
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String email = rs.getString("email");


            m.put("name", name);
            m.put("surname", surname);
            m.put("email", email);
            
            System.out.println("username: " + username);
            System.out.println("name: " + name);
            System.out.println("surname: " + surname);
            System.out.println("email: " + email);

            
        }
        System.out.println("Done");

        return m;
    }
    
}
