/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import javax.servlet.RequestDispatcher;
import org.json.*;
import java.net.URLEncoder;
import java.net.URL;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AddDrug extends HttpServlet {
    
    private static String JDBC_DRIVER;
    private static String DB_URL;

    private static final String DBUSER = "root";
    private static final String DBPASS = "";

  public void doPost( HttpServletRequest request,
                      HttpServletResponse response)
                      throws IOException, ServletException {
    

    
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/drugchecker";

        //  Database credentials

    String d_name = request.getParameter("d_name");
    String d_id = request.getParameter("d_id");
    
    HttpSession session = request.getSession();
    
    String username = (String) session.getAttribute("username");
    
    try {
        // Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        // Open a connection
        Connection conn;

        conn = DriverManager.getConnection(DB_URL, DBUSER, DBPASS);

        Statement stmt = conn.createStatement(); 
        
       
        String sql = "INSERT INTO `drugs`"
                    + "(`name`, `user_id`, `rxcui`) VALUES "
                    + "('" + d_name + "','" + username + "','" + d_id +"')";
        
        System.out.println(sql);
        stmt.executeUpdate(sql);
        
        conn.close();


        
    } catch (ClassNotFoundException e) {
                    System.out.println(e.getMessage());
    } catch (SQLException e) {
                    System.out.println(e.getMessage());
    }
    
    RequestDispatcher view = request.getRequestDispatcher("result1.jsp");
    view.forward(request, response);
    
  }
}
