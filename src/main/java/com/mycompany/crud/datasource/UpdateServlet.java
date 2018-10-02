/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crud.datasource;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Admin
 */
public class UpdateServlet extends HttpServlet {

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
             String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String password=request.getParameter("password");  
        String country=request.getParameter("country");  
        
        Emp e = new Emp();
        e.setId(id);
        e.setName(name);
        e.setEmail(email);
        e.setPassword(password);
        e.setCountry(country);
        
        int status = EmpDao.update(e);
        if(status >0) {
            response.sendRedirect("ViewServlet");
        }else {
            out.println("Sorry, record is not updated.");
        }
        }
    }

    

}
