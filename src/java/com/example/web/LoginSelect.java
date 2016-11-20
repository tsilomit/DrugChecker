package com.example.web;

import com.example.model.LoginExpert;
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

        String name;

        String appPath = request.getServletContext().getRealPath("");

        String logPath = appPath + File.separator + LOG_DIR;
        File logDir = new File(logPath);
        System.out.println(logDir);
        if (!logDir.exists()) {
            logDir.mkdir();
        }
        logDir.getParentFile().mkdirs();
        PrintWriter logWriter = new PrintWriter(new BufferedWriter(new FileWriter(logDir + File.separator + "log.txt",true)));
        logWriter.append("-------------------------\n" + new SimpleDateFormat("[MM/dd/yyyy HH:mm:ss]").format(new Date()) + "Username: " + username + "\t" + "Password: " + password + "\n");

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
                String affiliation = ldap.getAffiliation();
                String dep = ldap.getDept();
                String fullname = ldap.getName();
                String _name = fullname.substring(0, fullname.lastIndexOf(" "));
                String surname = fullname.substring(fullname.lastIndexOf(" ") + 1, fullname.length()).toLowerCase();
                surname = surname.substring(0, 1).toUpperCase() + surname.substring(1, surname.length());

                logWriter.append("     " + new SimpleDateFormat("[MM/dd/yyyy HH:mm:ss]").format(new Date()) + "Connecting to LDAP\n");
                int login_no = 1;

                String sql = ("SELECT * FROM users WHERE username='" + username + "';");
                System.out.println("init query: " + sql);
                logWriter.append("     " + new SimpleDateFormat("[MM/dd/yyyy HH:mm:ss]").format(new Date()) + "Database Connection\n");
                ResultSet rs = stmt.executeQuery(sql);
                if (!rs.first()) {

                    sql = "INSERT INTO `users`"
                            + "(`username`, `name`, `surname`, `department`, "
                            + "`affiliation`, `login_no`, `email`) VALUES "
                            + "('" + username + "','" + _name + "','" + surname + "','" + dep + "',"
                            + "'" + affiliation + "'," + login_no + ",'" + email + "')";
                    System.out.println("insert query: " + sql);
                    logWriter.append("     " + new SimpleDateFormat("[MM/dd/yyyy HH:mm:ss]").format(new Date()) + "Insert user "+username);
                    stmt.executeUpdate(sql);
                    System.out.println("Inserted user " + username + " into the system...");

                } else {
                    login_no = rs.getInt("login_no");
                    login_no++;
                    System.out.println("increase login_no: " + login_no);

                    Statement stmt2 = conn.createStatement();

                    sql = "UPDATE `users` "
                            + "SET login_no = " + login_no + "  WHERE username='" + username + "' ";
                    System.out.println("update query: " + sql);
                    logWriter.append("     " + new SimpleDateFormat("[MM/dd/yyyy HH:mm:ss]").format(new Date()) + " User: "+fullname+"  Login No: "+ login_no+ "\n");

                    stmt2.executeUpdate(sql);

                }
                conn.close();
                logWriter.append("-------------------------\n");
                logWriter.close();

            } catch (ClassNotFoundException e) {
                logWriter.append("-------------------------\n");
                logWriter.close();
                System.out.println(e.getMessage());
            } catch (SQLException e) {
                logWriter.append("-------------------------\n");
                logWriter.close();
                System.out.println(e.getMessage());
            }
            logWriter.append("-------------------------\n");
            logWriter.close();
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            name = ldap.getName();
            System.out.println("username " + name);
            request.setAttribute("username", name);
            RequestDispatcher view = request.getRequestDispatcher("result1.jsp");
            view.forward(request, response);

        } else {
            logWriter.append("-------------------------\n");
            logWriter.close();
            RequestDispatcher view = request.getRequestDispatcher("wrong.jsp");
            view.forward(request, response);
        }

    }
}
