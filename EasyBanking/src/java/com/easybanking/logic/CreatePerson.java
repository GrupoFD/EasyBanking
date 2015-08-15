/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.logic;

import com.easybanking.banking.Bank;
import com.easybanking.banking.Legal;
import com.easybanking.banking.Natural;
import com.easybanking.banking.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

/**
 *
 * @author Joss
 */
public class CreatePerson extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        
        UserData ud = new UserData();
        String paramId = request.getParameter("id");
        String paramName = request.getParameter("name");
        String paramLastname = request.getParameter("lastname");
        String paramLastname02 = request.getParameter("lastname02");
        String paramEmail = request.getParameter("email");
        //Investigar como recibir este parametro
        String paramBirtdate = request.getParameter("birthdate");
        String paramAddress = request.getParameter("address");
        String paramPhone = request.getParameter("phone");
        //String paramPass = request.getParameter("password");
        String paramResposable = request.getParameter("responsable");

        Person client = new Person();
        String paramPass = client.encriptPassword(paramName);
        if (request.getParameter("clientType").equals("juridico")) {
            client = new Legal(paramId, paramName, paramLastname, paramLastname02, paramEmail, paramPass, paramAddress, Calendar.getInstance(), paramPhone, paramResposable);
        } else if (request.getParameter("clientType").equals("fisico")) {
            client = new Natural(paramId, paramName, paramLastname, paramLastname02, paramEmail, paramPass, paramAddress, Calendar.getInstance(), paramPhone);
        }
        
        ud.bank.getListOfPersons().add(client);

        
        response.sendRedirect("createaccount.jsp");
    }

       
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
