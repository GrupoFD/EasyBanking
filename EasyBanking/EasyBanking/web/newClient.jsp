<%-- 
    Document   : newClient
    Created on : 09-ago-2015, 21:49:22
    Author     : Joss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo cliente</title>
        <form action="CreatePerson">
             Cedula              :<input type="text" name="Id"/><br/>
             Nombre              :<input type="text" name="Name"/><br/>
             Contraseña          :<input type="text" name="password" /><br/>
             Feacha de nacimiento:<input type="date" name="birthdate">
             Direccion           :<input type="text" name="address"/><br/>
             Telefono          : <input type="text" name="phone"/>
             <br/>
             <h1>Seleccione el tipo de cliente </h1>
             Tipo de cliente: <select name="clientType" size="2">
                 <option>Jurídico</option>
                 <option>Físico</option>
             </select><br/>
         
         <input type="submit" value="Add" name="newClient" />
    </form>
    </head>
    <body>
        
    </body>
</html>
