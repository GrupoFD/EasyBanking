<%-- 
    Document   : createUser
    Created on : 11-ago-2015, 13:50:46
    Author     : Joss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Usuario</title>
    </head>
    <body>
        <h1>Nuevo usuario</h1>
        
        Ingrese los datos que se le solicitan:
        <form action="CreateUser">
             Cedula              :<input type="text" name="id"/><br/>
             Nombre              :<input type="text" name="name"/><br/>
             Primer apellido      :<input type="text" name="Lastname"/><br/>
             Segundo apellido     :<input type="text" name="Lastname"/><br/>
             E-mail              :<input type="text" name="email" value="@"/><br/>
             Feacha de nacimiento:<input type="text" name="birthdate" value="00/00/0000"><br/>
             Direccion           :<input type="text" name="address"/><br/>
             Telefono            : <input type="text" name="phone" value="0000-00-00"/><br/>
             Salario             :<input type="text" name="salary" value="" /><br/>
             Horario             :<input type="text" name="workShift" value="" /><br/>
             <input type="submit" value="Agregar" name="newUser" />   
             
             
             
        </form>
    </body>
</html>
