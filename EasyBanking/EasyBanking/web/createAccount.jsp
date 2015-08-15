<%-- 
    Document   : createAccount
    Created on : 10-ago-2015, 5:01:39
    Author     : Joss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Cuenta</title>
    </head>
    
    <body>
        <form action="CreateAccount">
        
        <h1>Ingrese la información que se le solicita</h1>
        Numero de cedula:<input type="text" name="Identification"/><br/>
        Numero de cuenta:<input type="text" name="Account"/><br/>
        Moneda          : <select name="Currency"><br/>
           <option>Dolar</option>
           <option>Colon</option>
           <option>Euro</option>
       </select><br/>
       Monto a depositar:<input type="number" name="Amount"/><br/>
       <input type="submit" value="Crear cuenta" name="newAccount" />
       <br/>
       <form/>
    </body>
</html>
