<%@page import="com.easybanking.banking.Transaction"%>
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
            border:1px solid #0076a3;
            border-top-left-radius: 5px 5px;
            border-bottom-left-radius: 5px 5px;
            border-top-right-radius: 5px 5px;
            border-bottom-right-radius: 5px 5px;
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
            }%>
        <br>
        <div><a href="createaccount.jsp?fromBanking=true"><button class="ebbutton" value="true" name="fromBanking">Agregar cuenta</button></a></div><div><a href="loggedin.jsp"><button class="ebbutton" value="true" name="fromBanking">Regresar</button></a></div>
        <br>
        <br>
        <br>

        <%
            if (transactionType != null & accountId != null) {
                if (transactionType.equals("deposit")) {%>

        <form action="ClientTransaction" >
            <div>
                <a>
                    Monto a depositar: <input type="text" name="amount" class="ebtextinput"/><br/>

                    <br>               

                    <input type="submit" name="execute" value="Depositar" class="ebbutton" style="width: 200px"/><br/>
                </a>
            </div>
        </form>

        <%
        } else if (transactionType.equals("withdraw")) { %>
        <form action="ClientTransaction" >
            <div>
                <a>
                    Monto a retirar: <input type="text" name="amount" class="ebtextinput"/><br/>

                    <br>               

                    <input type="submit" name="execute" value="Retirar" class="ebbutton" style="width: 200px"/><br/>
                </a>
            </div>
        </form>

        <% } else if (transactionType.equals("transfer")) {

            Person pToTransfer = (Person) session.getAttribute("TRANSFERING_TO_PERSON");

            ArrayList<Person> searchResult2 = (ArrayList<Person>) session.getAttribute("RESULT_CLIENT2");

            if (pToTransfer != null) {%>

            <h2>Transfiriendo a <%=pToTransfer.getName()%> <br> # de cedula: <%=pToTransfer.getId()%></h2>    

        <table border="1">
            <tr>
                <td align="center">  # Cuenta  </td>
                <td align="center">  Moneda  </td>
            </tr> 
            <%  for (BankAccount ba : pToTransfer.getListOfBankAccounts()) {%>

            <tr>
                <td align="center"><%=ba.getId()%></td>
                <td align="center"><%=ba.currencyFormat(ba.getCurrency())%></td>
            </tr>    

            <%}
            %>
        </table> 

        <%
        } else if (searchResult2 != null) {

        %>
        <div><h1> Listado de personas a transferir </h1></div>
        <table border="1">
            <tr>
                <td align="center">Cedula</td>
                <td align="center">Nombre</td>
                <td align="center">Primer Apellido</td>
                <td align="center">Segundo Apellido</td>
                <td align="center">Correo Electronico</td>
            </tr>
            <%                if (searchResult2 != null) {
                    for (Person s : searchResult2) {
            %>
            <tr>
                <td align="center"><%=s.getId()%></td>
                <td align="center"><%=s.getName()%></td>
                <td align="center"><%=s.getLastName()%></td>
                <td align="center"><%=s.getLastName2()%></td>
                <td align="center"><%=s.getEmail()%></td>
                <td style="border: 1"><form action="ClientInfo"><button class="ebbutton"  value="<%=s.getId()%>" name="transaction">Ver cuentas</button></form></td>
            </tr> 

            <%
                    }
                }
                session.removeAttribute("RESULT_CLIENT2");
            } else { %>
        </table>
        <div><h1> Ingrese persona a transferir </h1></div>
        <div id="ebsearch">
            <form id="ebnewsearch" method="get" action="UserData">
                <input type="text" class="ebtextinput" name="searchTransfer" size="21" maxlength="120"><input type="submit" value="Buscar" class="ebbutton">
            </form>
            <div class="ebclear"></div>

        </div>

        <table border="1">


            <% }

            %>
        </table>



        <%} else if (transactionType.equals("history")) {

            ArrayList<Transaction> accountTransaction = (ArrayList<Transaction>) session.getAttribute("ACCOUNT_TRANSACTIONS");
            if (accountTransaction != null) {%>
            <h2>Historial de transacciones</h2>
            <br>
        <table border="1">
            <tr>
                <td align="center">  # Transaccion  </td>
                <td align="center">  Fecha  </td>
                <td align="center">  Monto  </td>
                <td align="center">  Tipo  </td>
            </tr>
            <%for (Transaction t : accountTransaction) {%>
            <tr>
                <td align="center"><%=t.getId()%></td>
                <td align="center"><%=sdf.format(t.getTimeStamp().getTime())%></td>
                <td align="center"><%=t.getAmountOfTransaction()%></td>
                <td align="center"><%=t.getTypeOfTransaction(t)%></td>
            </tr>

            <%
                }%>
        </table>
        <%

                    }

                }
            }
        %> 


    </body>
</html>
