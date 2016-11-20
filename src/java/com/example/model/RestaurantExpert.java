package com.example.model;

import java.util.*;

public class RestaurantExpert {
   public List getTypes(String type) {

    // List types = new ArrayList();
     List<String> types = new ArrayList();

     if (type.equals("Fast Food")) {
       types.add("Rainbow");
       types.add("Max Burger");
     }
     else if (type.equals("Ethnic")) {
       types.add("Noodle - Bar");
       types.add("Bakku Sushi Love");
       types.add("La Marimba");
     }
     else if (type.equals("Traditional")) {
       types.add("Mouries");
       types.add("Iolkos");
     }
     else if (type.equals("Family Restaurant")) {
       types.add("Brother's Pizza Bar");
       types.add("Svolos");
       types.add("Stafylos");
     }
     else {
       types.add("Vending Machine");
     }
     return(types);
   }
}