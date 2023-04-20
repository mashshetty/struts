package com.assignment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static final String[][] CITIES_BY_STATE = {
        {"Los Angeles", "San Francisco", "San Diego","Amnur","Akur Bosia"}, 
        {"New York City", "Albany", "Buffalo","Wall gate","Shai Shyio"}, 
        {"Houston", "Austin", "Dallas","Amini Ranur","Banko Bany"} 
    };

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String state = request.getParameter("state");
        String[] cities = getCitiesByState(state);
        
      
        StringBuilder options = new StringBuilder();
        for (String city : cities) {
            options.append("<option value=\"").append(city).append("\">").append(city).append("</option>");
        }
        
        
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(options.toString());
    }

    private String[] getCitiesByState(String state) {
        int stateIndex = -1;
        switch (state) {
            case "CA":
                stateIndex = 0;
                break;
            case "NY":
                stateIndex = 1;
                break;
            case "TX":
                stateIndex = 2;
                break;
        }
        
        if (stateIndex >= 0) {
            return CITIES_BY_STATE[stateIndex];
        } else {
            return new String[] {};
        }
    }
}
