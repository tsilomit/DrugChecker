/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.web;

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

/**
 *
 * @author rania
 */

public class search extends HttpServlet {
    
    private static String JDBC_DRIVER;
    private static String DB_URL;

    private static final String DBUSER = "root";
    private static final String DBPASS = "";

  public void doPost( HttpServletRequest request,
                      HttpServletResponse response)
                      throws IOException, ServletException {
    

    
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/drugchecker";



    
    String drug = request.getParameter("drug");
    
    HttpSession session = request.getSession();
    
    String username = (String) session.getAttribute("username");
    String apotelesma;
    String teliko2;
    
    //psaxnoume to id(rxcui) tis ousias apo to api tou rxnav  
    
    String s = "https://rxnav.nlm.nih.gov/REST/rxcui.json?name=" ;
    
    s += URLEncoder.encode(drug, "UTF-8");
    URL url = new URL(s);
 
    // read from the URL
    Scanner scan = new Scanner(url.openStream());
    String str = new String();
    while (scan.hasNext())
        str += scan.nextLine();
    scan.close();
 
    // build a JSON object
    JSONObject obj = new JSONObject(str);
 
    // get the first result
    JSONObject res = obj.getJSONObject("idGroup");
    System.out.println(res.getString("name"));
    
    //elegxoume an yparxei id gia tin ousia pou edwse o xristis,an oxi stelnoume stin arxiki
    if(!res.has("rxnormId")){
        RequestDispatcher view = request.getRequestDispatcher("wrong_drug.jsp");
        view.forward(request, response);
    }
    
    else{
    
        apotelesma = res.getJSONArray("rxnormId").getString(0);

        //ftiaxnoume to link gia na elegksoume an yparxoun sigkrouseis 
        //anamesa sta farmaka tou xristi kai tis kainourias ousias
        //to link einai tis morfis rxcuis=mpla+mpla2+mpla3
        String s2 = "https://rxnav.nlm.nih.gov/REST/interaction/list.json?rxcuis=";
        //prosthetoume to id tis kainourias ousias sto link
        s2 += URLEncoder.encode(apotelesma, "UTF-8");

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            Connection conn;

            conn = DriverManager.getConnection(DB_URL, DBUSER, DBPASS);
            //pernoume ta farmaka tou xristi kai prosthetoume sto link to id tous
            Statement stmt = conn.createStatement(); 
            String sql = "SELECT * FROM `drugs` WHERE user_id='" + username + "'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            System.setProperty("http.agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"); 

            while (rs.next()) {
                //Retrieve by column name
                String rxcui = rs.getString("rxcui");
                s2 += URLEncoder.encode(" "+rxcui, "UTF-8");

            }
            url = new URL(s2);

            // read from the URL
            scan = new Scanner(url.openStream());
            str = new String();
            while (scan.hasNext())
                str += scan.nextLine();
            scan.close();

            // build a JSON object
            JSONObject obj2 = new JSONObject(str);    
            //an yparxei sygkrousi sta farmaka tote sto json pou epestrepse to api yparxei to sygkekrimeno object
            if( obj2.has("fullInteractionTypeGroup")){

                JSONArray res2 = obj2.getJSONArray("fullInteractionTypeGroup");
                JSONObject res3 = res2.getJSONObject(0);
                JSONArray res4 = res3.getJSONArray("fullInteractionType");
                JSONObject res5 = res4.getJSONObject(0);
                JSONArray res6 = res5.getJSONArray("interactionPair");
                JSONObject res7 = res6.getJSONObject(0);
                //pernoume ti diagnwsi tis sygkrousis
                teliko2 = (String)(res7.get("description"));

            }
            else{

                teliko2 = "There is no conflict with this drug";
            }
            //pername tis metavlites sto jsp gia na perastoun sti vasi an kanei o xristis add
            session.setAttribute("d_name", drug);
            session.setAttribute("d_id", apotelesma);
            session.setAttribute("styles2", teliko2);
            RequestDispatcher view = request.getRequestDispatcher("search_drug.jsp");
            view.forward(request, response);

        } catch (ClassNotFoundException e) {
                        System.out.println(e.getMessage());
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }


    }
  }
}
