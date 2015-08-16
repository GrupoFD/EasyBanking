<%-- 
    Document   : createAccount
    Created on : 10-ago-2015, 5:01:39
    Author     : Joss
--%>

<%@page import="com.easybanking.banking.BankAccount"%>
<%@page import="com.easybanking.banking.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        Person p = (Person) session.getAttribute("CLIENT");
        BankAccount ba = new BankAccount();
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Cuenta</title>
    </head>

    <body>
        <form action="CreateAccount">

            <h1>Ingrese la información que se le solicita</h1>
            Numero de cedula:<%=p.getId()%>       
            Moneda          : 
            <select name="currency"><br/>
                <option value="colon">Colon</option>
                <option value="dolar">Dolar</option>
                <option value="euro">Euro</option>
                <option value="credito">Credito Dolares</option>
            </select><br/>
            <% String currency = request.getParameter("currency"); %>                     
            Monto a depositar:<input type="number" name="Amount"/><br/>
            <br>
            Numero de cuenta:<%= ba.createNewAccountNumber(ba.currencyToInt(currency))%>

            <script type="text/javascript">
                function showMessage() {
                    alert("La cuenta ha sido creado con exito");
                }
            </script>
            <input type="submit" value="Agregar" name="newClient" onclick ="showMessage()" />
            <br/>
            <br/>


            <form/>
    </body>
</html>

