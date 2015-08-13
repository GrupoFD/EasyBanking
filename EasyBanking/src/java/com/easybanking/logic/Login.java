/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.logic;

import com.easybanking.banking.Bank;
import com.easybanking.banking.BankAccount;
import com.easybanking.banking.Person;
import com.easybanking.banking.User;
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

        Person p = new User("123", "Carlos", "Asdrubal", "Pachano", "pachano@gmail.com", "123", "qwdqwd", Calendar.getInstance(), "123", 2500, "TARDE");
        Person p2 = new Person("452", "Carlos", "Solis", "Pancho", "solispancho@gmail.com", "456", "qwdqwd", Calendar.getInstance(), "123");
        Person p3 = new Person("75632", "Carlos", "Solis", "Pancho", "solispancho@gmail.com", "456", "qwdqwd", Calendar.getInstance(), "123");     
        Person p4 = new Person("5542", "Carlos", "Solis", "Pancho", "solispancho@gmail.com", "456", "qwdqwd", Calendar.getInstance(), "123");
        ud.bank.getListOfPersons().add(p);
        ud.bank.getListOfPersons().add(p2);
        ud.bank.getListOfPersons().add(p3);
        ud.bank.getListOfPersons().add(p4);
        BankAccount a = new BankAccount("123", 2, 1234, Calendar.getInstance(), Calendar.getInstance());
        BankAccount b= new BankAccount("123", 2, 1234, Calendar.getInstance(), Calendar.getInstance());
        BankAccount c = new BankAccount("123", 2, 1234, Calendar.getInstance(), Calendar.getInstance());
        p.getListOfBankAccounts().add(a);
        p.getListOfBankAccounts().add(b);
        p.getListOfBankAccounts().add(c);
        
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
