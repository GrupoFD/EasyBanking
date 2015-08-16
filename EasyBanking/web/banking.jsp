<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : banking
    Created on : 11-ago-2015, 11:49:10
    Author     : Soler
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.easybanking.banking.BankAccount"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.easybanking.banking.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        Person p = (Person) session.getAttribute("CLIENT");
    %>

    <style type="text/css">

        body{background:#c3dfef}
        a {
            text-decoration:none;
        }

        #ebsearch{
            background-color:#c3dfef;
        }

        #ebnewsearch{
            float:center;
            padding:20px;
        }

        .ebtextinput{
            margin: 0;
            padding: 5px 15px;
            font-family: Arial, Helvetica, sans-serif;
            font-size:14px;
            border:1px solid #0076a3; border-right:0px;
            border-top-left-radius: 5px 5px;
            border-bottom-left-radius: 5px 5px;
        }

        .ebbutton {
            margin: 0;
            padding: 5px 15px;
            font-family: Arial, Helvetica, sans-serif;
            font-size:14px;
            outline: none;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            color: #ffffff;
            border: solid 1px #0076a3; border-right:0px;
            background: #0095cd;
            background: -webkit-gradient(linear, left top, left bottom, from(#00adee), to(#0078a5));
            background: -moz-linear-gradient(top,  #00adee,  #0078a5);
            border-top-left-radius: 5px 5px;
            border-bottom-left-radius: 5px 5px;
            border-top-right-radius: 5px 5px;
            border-bottom-right-radius: 5px 5px;
        }

        .ebbutton:hover {
            text-decoration: none;
            background: #007ead;
            background: -webkit-gradient(linear, left top, left bottom, from(#0095cc), to(#00678e));
            background: -moz-linear-gradient(top,  #0095cc,  #00678e);
        }

        .ebbutton::-moz-focus-inner {
            border: 0;
        }

        .ebclear{
            clear:both;
        }

        h1 { 
            alignment-adjust: central;
            margin: 0 auto; 
            width: 500px;
        }

        h2 { 
            margin: 0 auto; 
            width:270px;
        }

        table { 

            margin: 0 auto; 
            width:250px;
        }

        div { 
            alignment-adjust: central;
            margin: 0 auto; 
            width:690px;
        }

    </style>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Easy Banking!</title>
    </head>
    <body>
        <br>
        <br>
        <h1>Cliente ID: <%=p.getId()%> Nombre: <%=p.getName()%></h1>
        <br>
        <br>
        <br>
        <h2> Cuentas de ahorro</h2>
        <br>
        <table border="1">
            <td align="center">  # Cuenta  </td>
            <td align="center">  Moneda  </td>
            <td align="center">  Fecha Creacion  </td>
            <td align="center">  Fecha Expiracion  </td>
            <td align="center">  Monto  </td>
            <%

                String transactionType = (String) session.getAttribute("TYPE_OF_TRANSACTION");

                String accountId = (String) session.getAttribute("USER_TRANSACTION");

                ArrayList<BankAccount> personBankAccount = (ArrayList<BankAccount>) session.getAttribute("BANK_ACCOUNT");
                SimpleDateFormat sdf = new SimpleDateFormat("MM / yyyy");

                if (personBankAccount != null) {
                    for (BankAccount ba : personBankAccount) {
                        if (ba.getCurrency() != 4) {
            %>
            <tr>
                <td align="center"><%=ba.getId()%></td>
                <td align="center"><%=ba.currencyFormat(ba.getCurrency())%></td>
                <td align="center"><%=sdf.format(ba.getRegisteredDate().getTime())%></td>
                <td align="center"><%=sdf.format(ba.getExpirationDate().getTime())%></td>
                <td align="center"><%=ba.getAmount()%></td>
                <td style="border: 1"><form action="ClientTransaction"><button class="ebbutton" value="<%=ba.getId()%>" name="deposit">Deposito</button></form></td>
                <td style="border: 1"><form action="ClientTransaction"><button class="ebbutton" value="<%=ba.getId()%>" name="withdraw">Retiro</button></form></td>
                <td style="border: 1"><form action="ClientTransaction"><button class="ebbutton" value="<%=ba.getId()%>" name="transfer">Transferencia</button></form></td>
                <td style="border: 1"><form action="ClientTransaction"><button class="ebbutton" value="<%=ba.getId()%>" name="history">Historial</button></form></td>
            </tr>

            <% }
                }%></table>
        <br>
        <br>
        <br>
        <h2>Cuentas de credito</h2>
        <br>
        <table border="1">
            <td align="center">  # Cuenta  </td>
            <td align="center">  Moneda  </td>
            <td align="center">  Fecha Creacion  </td>
            <td align="center">  Fecha Expiracion  </td>
            <td align="center">  Monto  </td>
            <% for (BankAccount ba : personBankAccount) {
                    if (ba.getCurrency() == 4) {%>

            <tr>
                <td align="center"><%=ba.getId()%></td>
                <td align="center"><%=ba.currencyFormat(ba.getCurrency())%></td>
                <td align="center"><%=sdf.format(ba.getRegisteredDate().getTime())%></td>
                <td align="center"><%=sdf.format(ba.getExpirationDate().getTime())%></td>
                <td align="center"><%=ba.getAmount()%></td>
                <td style="border: 1"><form action="ClientTransaction"><button class="ebbutton" value="<%=ba.getId()%>" name="deposit">Deposito</button></form></td>
                <td style="border: 1"><form action="ClientTransaction"><button class="ebbutton" value="<%=ba.getId()%>" name="withdraw">Retiro</button></form></td>
                <td style="border: 1"><form action="ClientTransaction"><button class="ebbutton" value="<%=ba.getId()%>" name="transfer">Transferencia</button></form></td>
                <td style="border: 1"><form action="ClientTransaction"><button class="ebbutton" value="<%=ba.getId()%>" name="history">Historial</button></form></td>
            </tr>    
        </table>
        <% }
                }
            }

            if (transactionType != null & accountId != null) {
        %>

        <a> TIPO TRANSACCION<%=transactionType%>  y NUMERO CUENTA<%=accountId%> </a>

        <%}%> 
        <br>
        <br>
        
        <div><a href="createaccount.jsp"><button class="ebbutton" value="createaccount">Agregar cuenta</button></a></div>

    </body>
</html>
