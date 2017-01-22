package com.example.model;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.uthldap.Uthldap;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rania
 */
public class SignUp extends HttpServlet {


    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        // JDBC driver name and database URL
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/drugchecker";

        //  Database credentials
        final String DBUSER = "root";
        final String DBPASS = "";

        String username = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password_confirm = request.getParameter("password_confirm");

      
        if (password.equals(password_confirm)) {
            
            try {
                // Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                // Open a connection
                Connection conn;

                conn = DriverManager.getConnection(DB_URL, DBUSER, DBPASS);

                Statement stmt = conn.createStatement();
                

                String sql = "INSERT INTO `users`"
                            + "(`username`, `name`, `surname`, "
                            + "`password`, `email`) VALUES "
                            + "('" + username + "','" + firstname + "','" + lastname + "',"
                            + "'" + password + "','"  + email + "')";
                
                System.out.println("insert query: " + sql);
                    
                stmt.executeUpdate(sql);
                System.out.println("Inserted user " + username + " into the system...");
            

                conn.close();


            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            request.setAttribute("username", username);
            RequestDispatcher view = request.getRequestDispatcher("result1.jsp");
            view.forward(request, response);
        
        }else {           
            RequestDispatcher view = request.getRequestDispatcher("wrong.jsp");
            view.forward(request, response);
        }

    }
}

