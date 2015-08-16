/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.logic;

import com.easybanking.banking.Bank;
import com.easybanking.banking.BankAccount;
import com.easybanking.banking.Deposit;
import com.easybanking.banking.Person;
import com.easybanking.banking.Transaction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Soler
 */
public class ClientTransaction extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession(true);

            UserData ud = new UserData();
            Person p = (Person) session.getAttribute("CLIENT");

            String execute = request.getParameter("execute");

            String deposit = request.getParameter("deposit");
            String withdraw = request.getParameter("withdraw");
            String transfer = request.getParameter("transfer");
            String history = request.getParameter("history");

            if (deposit != null) {

                session.setAttribute("TYPE_OF_TRANSACTION", "deposit");
                session.setAttribute("USER_TRANSACTION", deposit);

            } else if (withdraw != null) {

                session.setAttribute("TYPE_OF_TRANSACTION", "withdraw");
                session.setAttribute("USER_TRANSACTION", withdraw);

            } else if (transfer != null) {

                session.setAttribute("TYPE_OF_TRANSACTION", "transfer");
                session.setAttribute("USER_TRANSACTION", transfer);

            } else if (history != null) {

                session.setAttribute("TYPE_OF_TRANSACTION", "history");
                session.setAttribute("USER_TRANSACTION", history);

                for (BankAccount ba : p.getListOfBankAccounts()) {
                    if (ba.getId().equals(history)) {

                        session.setAttribute("ACCOUNT_TRANSACTIONS", ba.getListOfTransactions());

                    }
                }
                
            }
            
            response.sendRedirect("banking.jsp");

//            switch (execute) {
//
//                case "deposit":
//                    double amount = Double.parseDouble(request.getParameter("amount"));
//                    Transaction t = new Deposit("1", Calendar.getInstance(), amount);
//                    for (BankAccount ba : p.getListOfBankAccounts()) {
//                        if (ba.getId().equals(deposit)) {
//
//                            ba.getListOfTransactions().add(t);
//                        }
//                    }
//                    break;
//            }

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
