/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.logic;

import com.easybanking.entity.Bank;
import com.easybanking.entity.BankAccount;
import com.easybanking.entity.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Joss
 */
public class CreateAccount extends HttpServlet {

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

        try {
            HttpSession session = request.getSession(true);
            Person p = (Person) session.getAttribute("NEW_CLIENT");
            String paramIdentificaTion = p.getId();
            UserData ud = new UserData();

            BankAccount ba = new BankAccount();
            //if (p != null) {
            String currency = request.getParameter("currency");
            String paramId = ba.createNewAccountNumber(currency);
            String paramCurrency = request.getParameter("currency");

            int paramCurrencyInt = ba.currencyToInt(paramCurrency);

            double paramAmount = 0;
            paramAmount = Double.parseDouble(request.getParameter("amount"));

            //cambiar la fecha de expiración
            Calendar expirationDate = ba.expirationDate();

            BankAccount account = new BankAccount(paramId, paramCurrencyInt, paramAmount, Calendar.getInstance(), expirationDate);

            p.getlistOfBankAccounts().add(account);

            session.removeAttribute("NEW_CLIENT");

            response.sendRedirect("loggedin.jsp");

        } catch (NumberFormatException e) {

            e.getMessage();

        }
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
