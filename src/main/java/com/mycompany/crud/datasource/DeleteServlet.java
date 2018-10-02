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
public class DeleteServlet extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String sid = request.getParameter("id");
            int id = Integer.parseInt(sid);
            EmpDao.delete(id);
            response.sendRedirect("ViewServlet");
        
    }

    

}
