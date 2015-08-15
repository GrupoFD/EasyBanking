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
    <h1>Nuevo cliente </h1>
    <form action="CreatePerson">
        Cedula              :<input type="text" name="id"/><br/>
        Nombre              :<input type="text" name="name"/><br/>
        Primer apellido      :<input type="text" name="lastname"/><br/>
        Segundo apellido     :<input type="text" name="lastname02"/><br/>
        E-mail              :<input type="text" name="email" value="@"/><br/>
        Feacha de nacimiento:<input type="text" name="birthdate" value="00/00/0000"><br/>
        Direccion           :<input type="text" name="address"/><br/>
        Telefono          : <input type="text" name="phone" value="0000-00-00"/>
        <br/>

        Tipo de cliente: <select name="clientType">
            <option value="juridico">Jurídico</option>
            <option value="fisico">Físico</option>
        </select>
        <br/>

        Responsable          : <input type="text" name="responsable"/>
        <br/>
        <br/>

        <input type="submit" value="Agregar" name="newClient" />
        <br/>
        <br/>
    </form>

</head>
<body>

</body>
</html>
