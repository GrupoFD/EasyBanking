/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.logic;

import com.easybanking.banking.Bank;
import com.easybanking.banking.Legal;
import com.easybanking.banking.Person;
import com.easybanking.banking.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joss
 */
public class CreateUser extends HttpServlet {

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
        String paramLastname = request.getParameter("Lastname");
        String paramLastname02 = request.getParameter("Lastname02");
        String paramEmail = request.getParameter("email");
        //Investigar como recibir este parametro
        String paramBirtdate = request.getParameter("birthdate");
        String paramAddress = request.getParameter("address");
        String paramPhone = request.getParameter("phone");

        int paramSalary = Integer.parseInt(request.getParameter("salary"));
        String paramworkShift = request.getParameter("workShift");

        Person person = new Person();
        String paramPass = person.encriptPassword(paramName);

        Person user = new User(paramId, paramName, paramLastname, paramLastname02, paramEmail, paramPass, paramAddress, Calendar.getInstance(), paramPhone, paramSalary, paramworkShift);
        ud.bank.getListOfPersons().add(user);

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
