package com.example.model;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rania
 */
public class LoginExpert {
     public List getUsernames(String username) {
          List<String> unames = new ArrayList();
          unames.add(username);
          return(unames);
     }
     
     public List getPasswords (String password) {
         List<String> pwords = new ArrayList();
         pwords.add(password);
         return(pwords);
     }
     
     
}
