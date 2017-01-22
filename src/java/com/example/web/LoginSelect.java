package com.example.web;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.uthldap.Uthldap;
import java.io.BufferedWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rania
 */
public class LoginSelect extends HttpServlet {

    private static final String LOG_DIR = "log";

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
        String password = request.getParameter("password");
        String epilogi = request.getParameter("epilogi");

        if (epilogi.equals("2")){
            String name;
            
            Uthldap ldap = new Uthldap(username, password);

            if (ldap.auth()) {

                try {
                    // Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    // Open a connection
                    Connection conn;

                    conn = DriverManager.getConnection(DB_URL, DBUSER, DBPASS);

                    Statement stmt = conn.createStatement();

                    String email = ldap.getMail();
                    String fullname = ldap.getName();
                    String _name = fullname.substring(0, fullname.lastIndexOf(" "));
                    String surname = fullname.substring(fullname.lastIndexOf(" ") + 1, fullname.length()).toLowerCase();
                    surname = surname.substring(0, 1).toUpperCase() + surname.substring(1, surname.length());

                   
                    String sql = ("SELECT * FROM users WHERE username='" + username + "';");
                    System.out.println("init query: " + sql);
                    ResultSet rs = stmt.executeQuery(sql);
                    if (!rs.first()) {

                        sql = "INSERT INTO `users`"
                            + "(`username`, `name`, `surname`, "
                            + "`password`, `email`) VALUES "
                            + "('" + username + "','" + _name + "','" + surname + "',"
                            + "'" + password + "','"  + email + "')";
                        
                        System.out.println("insert query: " + sql);
                        stmt.executeUpdate(sql);
                        System.out.println("Inserted user " + username + " into the system...");

                    } 
                    conn.close();

                } catch (ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                name = ldap.getName();
                System.out.println("username " + name);
                request.setAttribute("username", name);
                RequestDispatcher view = request.getRequestDispatcher("result1.jsp");
                view.forward(request, response);

            } else {
                RequestDispatcher view = request.getRequestDispatcher("wrong.jsp");
                view.forward(request, response);
            }
        }
        else{            
                try {
                        // Register JDBC driver
                        Class.forName("com.mysql.jdbc.Driver");

                        // Open a connection
                        Connection conn;

                        conn = DriverManager.getConnection(DB_URL, DBUSER, DBPASS);

                        Statement stmt = conn.createStatement();
                        
                        String sql = ("SELECT * FROM users WHERE username='" + username + "';");
                        
                        ResultSet rs = stmt.executeQuery(sql);
                        
                        if (rs.first()) {
                            
                            String check_password = rs.getString("password");
                            if(check_password.equals(password)){
                                conn.close();
                                HttpSession session = request.getSession();
                                session.setAttribute("username", username);
                                System.out.println("username " + username);
                                request.setAttribute("username", username);
                                RequestDispatcher view = request.getRequestDispatcher("result1.jsp");
                                view.forward(request, response);
                            }
                            else{
                                RequestDispatcher view = request.getRequestDispatcher("wrong.jsp");
                                view.forward(request, response);
                            }
                        }
                        else{
                                RequestDispatcher view = request.getRequestDispatcher("wrong.jsp");
                                view.forward(request, response);
                        }
                    }catch (ClassNotFoundException e) {
                        System.out.println(e.getMessage());
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                                                        
            }
        }

    }
}
