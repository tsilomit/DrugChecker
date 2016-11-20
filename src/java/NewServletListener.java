

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.*;
import javax.servlet.*;
import java.text.*;
import java.sql.*;


/**
 *
 * @author Rania
 */
public class NewServletListener implements HttpSessionListener {
    private static int users = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        synchronized (this) {
            users++;
            System.out.println(" Session Created ");
            System.out.println("Total Sessions: " + users);
        }
       
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        synchronized (this) {
            users--;
            System.out.println(" Session Destroyed ");
            System.out.println("Total Sessions: " + users);
        }
     
    }
}
