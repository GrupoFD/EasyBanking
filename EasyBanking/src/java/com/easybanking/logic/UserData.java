/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.logic;

import com.easybanking.entity.Bank;
import com.easybanking.entity.Person;
import com.easybanking.banking.User;
import static com.easybanking.logic.Login.loggedUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class UserData extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //Login login = new Login();
    public static Bank bank = new Bank(1, "EASY BANK", "Costa Rica", 800800800);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);
        String type = request.getParameter("type");
        String searchedPerson = request.getParameter("search");
        String searchTransfer = request.getParameter("searchTransfer");

        //La logica para buscar el cliente y meter los resultados en la lista a retornar
        if (searchTransfer != null) {

                ArrayList<Person> listofPersonToTransfer = bank.searchedPerson(searchTransfer);
                session.setAttribute("RESULT_CLIENT2", listofPersonToTransfer);
                response.sendRedirect("banking.jsp");
    
        } else {

            ArrayList<Person> listofPerson = bank.searchedPerson(searchedPerson);
            session.setAttribute("RESULT_CLIENT", listofPerson);
            response.sendRedirect("loggedin.jsp");
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
