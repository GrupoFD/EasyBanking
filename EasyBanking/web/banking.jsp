<%-- 
    Document   : banking
    Created on : 11-ago-2015, 11:49:10
    Author     : Soler
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.easybanking.banking.BankAccount"%>
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
            margin: 0 auto; 
            width:255px;
        }
        table { 
            
            margin: 0 auto; 
            width:250px;
        }
    </style>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Easy Banking!</title>
    </head>
    <body>
        <h1>Cliente ID: <%=p.getId()%> Nombre: <%=p.getName()%></h1>
        <br>
        <br>
        <table border="1">
            <td align="center">  # Cuenta  </td>
            <td align="center">  Moneda  </td>
            <td align="center">Fecha Creacion</td>
            <td align="center">Fecha Expiracion</td>
            <td align="center">  Monto  </td>
            <%
                
                ArrayList<BankAccount> personBankAccount = (ArrayList<BankAccount>) session.getAttribute("BANK_ACCOUNT");
                SimpleDateFormat sdf = new SimpleDateFormat("MM / yyyy");

                if (personBankAccount != null) {
                    for (BankAccount ba : personBankAccount) {
            %>
            <tr>
                <td align="center"><%=ba.getId()%></td>
                <td align="center"><%=ba.currencyFormat(ba.getCurrency())%></td>
                <td align="center"><%=sdf.format(ba.getRegisteredDate().getTime())%></td>
                <td align="center"><%=sdf.format(ba.getExpirationDate().getTime())%></td>
                <td align="center"><%=ba.getAmount()%></td>
                <td style="border: 1"><button type="summit" class="ebbutton" onclick="myFunction()">Deposito</button></td>
                <td style="border: 1"><button class="ebbutton" onclick="myFunction()">Retiro</button></td>
                <td style="border: 1"><button class="ebbutton" onclick="myFunction()">Transferencia</button></td>
                <td style="border: 1"><button class="ebbutton" onclick="myFunction()">Historial</button></td>
            </tr>        
            <%
                    }
                }
                session.removeAttribute("RESULT_CLIENT");
            %>            
        </table>
        
        
    </body>
</html>
