/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.logic;

import com.easybanking.banking.BankAccount;
import com.easybanking.banking.Deposit;
import com.easybanking.banking.Manager;
import com.easybanking.banking.Person;
import com.easybanking.banking.Transaction;
import com.easybanking.banking.Transfer;
import com.easybanking.banking.User;
import com.easybanking.banking.Withdraw;
import java.io.IOException;
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
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    static User loggedUser;
    String paramId;
    String paramPass;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        paramId = request.getParameter("id");
        paramPass = request.getParameter("password");
        
        HttpSession session = request.getSession(true);
        UserData ud = new UserData();

        Person p = new Manager("123", "Carlos", "Asdrubal", "Pachano", "pachano@gmail.com", "123", "qwdqwd", Calendar.getInstance(), "123", 2500, "TARDE", 1500);
        Person p2 = new Person("3-223-552", "Glenn", "Joss", "Pancho", "solispancho@gmail.com", "456", "qwdqwd", Calendar.getInstance(), "123");
        Person p3 = new Person("75632", "Carlos", "Solis", "Pancho", "solispancho@gmail.com", "456", "qwdqwd", Calendar.getInstance(), "123");
        Person p4 = new Person("5542", "Carlos", "Solis", "Pancho", "solispancho@gmail.com", "456", "qwdqwd", Calendar.getInstance(), "123");

        ud.bank.getListOfPersons().add(p);
        ud.bank.getListOfPersons().add(p2);
        ud.bank.getListOfPersons().add(p3);
        ud.bank.getListOfPersons().add(p4);
        
        BankAccount date = new BankAccount();

        BankAccount a = new BankAccount("200-000001", 2, 1500, Calendar.getInstance(), date.expirationDate());
        BankAccount b = new BankAccount("300-000002", 3, 2000, Calendar.getInstance(), date.expirationDate());
        BankAccount c = new BankAccount("400-000003", 4, 3500, Calendar.getInstance(), date.expirationDate());
        BankAccount e = new BankAccount("200-000004", 2, 1500, Calendar.getInstance(), date.expirationDate());
        BankAccount f = new BankAccount("300-000005", 3, 2000, Calendar.getInstance(), date.expirationDate());
        BankAccount g = new BankAccount("400-000006", 4, 3500, Calendar.getInstance(), date.expirationDate());
        
        p.getListOfBankAccounts().add(a);
        p.getListOfBankAccounts().add(b);
        p.getListOfBankAccounts().add(c);
        
        p2.getListOfBankAccounts().add(e);
        p2.getListOfBankAccounts().add(f);
        p2.getListOfBankAccounts().add(g);

        Transaction t = new Deposit("1", Calendar.getInstance(), 3500);
        Transaction t2 = new Withdraw("2", Calendar.getInstance(), 500);
        Transaction t3 = new Transfer("3", Calendar.getInstance(), 2500, p.getName());
        
        a.getListOfTransactions().add(t);
        a.getListOfTransactions().add(t2);
        a.getListOfTransactions().add(t3);

        Person userDataFound = ud.bank.personValidation(paramId, paramPass);

        if (userDataFound instanceof User) {

            if (userDataFound != null) {

                loggedUser = (User) userDataFound;
                session.setAttribute("USER", loggedUser);
                response.sendRedirect("loggedin.jsp");

            } else {

                response.sendRedirect("error.jsp");
            }

        } else {

            response.sendRedirect("index.jsp");

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
