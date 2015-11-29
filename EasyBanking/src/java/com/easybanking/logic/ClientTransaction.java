/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.logic;

import com.easybanking.banking.BankAccount;
import com.easybanking.banking.Deposit;
import com.easybanking.entity.Person;
import com.easybanking.banking.Transaction;
import com.easybanking.banking.Transfer;
import com.easybanking.banking.Withdraw;
import java.io.IOException;
import static java.lang.System.out;
import java.util.Calendar;
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

        HttpSession session = request.getSession(true);

        UserData ud = new UserData();
        Person p = (Person) session.getAttribute("CLIENT");

        String execute = request.getParameter("execute");

        String deposit = request.getParameter("deposit");
        String withdraw = request.getParameter("withdraw");
        String transfer = request.getParameter("transfer");
        String history = request.getParameter("history");
        String cancelTransaction = request.getParameter("cancelTransaction");

        if (deposit != null) {

            session.setAttribute("TYPE_OF_TRANSACTION", "deposit");
            session.setAttribute("USER_TRANSACTION", deposit);

        } else if (withdraw != null) {

            session.setAttribute("TYPE_OF_TRANSACTION", "withdraw");
            session.setAttribute("USER_TRANSACTION", withdraw);

        } else if (transfer != null) {

            session.setAttribute("TYPE_OF_TRANSACTION", "transfer");

            //cuenta del que transfiere.
            session.setAttribute("USER_TRANSACTION", transfer);

        } else if (history != null) {

            session.setAttribute("TYPE_OF_TRANSACTION", "history");
            session.setAttribute("USER_TRANSACTION", history);
            for (BankAccount ba : p.getListOfBankAccounts()) {
                if (ba.getId().equals(history)) {

                    session.setAttribute("ACCOUNT_TRANSACTIONS", ba.getListOfTransactions());

                }
            }

        } else if (cancelTransaction != null) {

            session.setAttribute("TYPE_OF_TRANSACTION", null);
            session.setAttribute("USER_TRANSACTION", null);

        }

        if (execute != null) {

            double amount = Double.parseDouble(request.getParameter("amount"));

            Transaction ta = new Deposit();

            String transferrerAccountId = (String) session.getAttribute("USER_TRANSACTION");

            Person beneficiary = (Person) session.getAttribute("TRANSFERING_TO_PERSON");

            String beneficiaryAccountId = request.getParameter("beneficiaryAccountId");

            switch (execute) {

                case "Depositar":

                    try {
                        for (BankAccount ba : p.getListOfBankAccounts()) {
                            if (ba.getId().equals(transferrerAccountId)) {
                                String idTransaction = "" + ta.createNewIdNumber(ba);
                                Deposit d = new Deposit(idTransaction, Calendar.getInstance(), amount);
                                if (d.depositAmount(p, ba)) {
                                    ba.getListOfTransactions().add(d);
                                } else {

                                    response.sendRedirect("index.jsp");
                                }

                            }
                        }
                        response.sendRedirect("banking.jsp");
                    } catch (NullPointerException e) {

                    }
                    break;

                case "Retirar":

                    for (BankAccount ba : p.getListOfBankAccounts()) {
                        if (ba.getId().equals(transferrerAccountId)) {
                            String idTransaction = "" + ta.createNewIdNumber(ba);
                            Withdraw w = new Withdraw(idTransaction, Calendar.getInstance(), amount);
                            if (w.withdrawAmount(p, ba)) {
                                ba.getListOfTransactions().add(w);
                            } else {

                                response.sendRedirect("index.jsp");
                            }

                        }
                    }
                    response.sendRedirect("banking.jsp");
                    break;

                case "Transferir":

                    for (BankAccount ba : p.getListOfBankAccounts()) {
                        if (ba.getId().equals(transferrerAccountId)) {
                            for (BankAccount bba : beneficiary.getListOfBankAccounts()) {
                                if (bba.getId().equals(beneficiaryAccountId)) {
                                    String idTransaction = "" + ta.createNewIdNumber(ba);
                                    Transfer t = new Transfer(idTransaction, Calendar.getInstance(), amount, beneficiary.getName());
                                    if (t.transferAmount(p, ba, beneficiary, bba)) {
                                        ba.getListOfTransactions().add(t);
                                    } else {
                                        response.sendRedirect("index.jsp");
                                        System.out.println("EXCEPTION");
                                    }
                                }
                            }
                        }
                    }
                    response.sendRedirect("banking.jsp");
                    break;

            }

        } else {

            response.sendRedirect("banking.jsp");

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
