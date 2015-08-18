<%-- 
    Document   : createaccount
    Created on : Aug 17, 2015, 11:29:48 PM
    Author     : Soler
--%>
<%@page import="com.easybanking.banking.BankAccount"%>
<%@page import="com.easybanking.banking.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%

        String param = request.getParameter("fromBanking");

        if (param.equals("true")) {

            Person p = (Person) session.getAttribute("CLIENT");
            session.setAttribute("NEW_CLIENT", p);
    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Cuenta</title>
    </head>

    <body>
        <form action="CreateAccount">

            <h1>Ingrese la información que se le solicita</h1>
            Numero de cedula:<%=p.getId()%>
            <br>
            Moneda          : 
            <select name="currency"><br/>
                <option value="colon">Colon</option>
                <option value="dolar">Dolar</option>
                <option value="euro">Euro</option>
                <option value="credito">Credito Dolares</option>
            </select><br/>

            Monto a depositar:<input type="text" name="amount"/><br/>
            <br>

            <script type="text/javascript">

                function showMessage() {
                    alert("La cuenta ha sido creado con exito");
                }

            </script>

            <input type="submit" value="Agregar" name="newclient" onclick ="showMessage()" />

            <br/>

            <br/>


            <form/>
    </body>




    <% } else {

        Person p = (Person) session.getAttribute("NEW_CLIENT");
    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Cuenta</title>
    </head>

    <body>
        <form action="CreateAccount">

            <h1>Ingrese la información que se le solicita</h1>
            Numero de cedula:<%=p.getId()%>
            <br>
            Moneda          : 
            <select name="currency"><br/>
                <option value="colon">Colon</option>
                <option value="dolar">Dolar</option>
                <option value="euro">Euro</option>
                <option value="credito">Credito Dolares</option>
            </select><br/>

            Monto a depositar:<input type="text" name="amount"/><br/>
            <br>

            <script type="text/javascript">
                function showMessage() {
                    alert("La cuenta ha sido creado con exito");
                }
            </script>
            <input type="submit" value="Agregar" name="newclient" onclick ="showMessage()" />
            <br/>
            <br/>


            <form/>
    </body>


    <% }
    %>

</html>