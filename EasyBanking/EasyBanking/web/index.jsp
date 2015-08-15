<%-- 
    Document   : index
    Created on : Aug 8, 2015, 7:18:08 PM
    Author     : Soler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <Style>
            body{background:#c3dfef}
        </style>
        <!--<script>
            function myFunction() {
                alert("Hello! I am an alert box!");
            }
        </script>-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EASY BANKING</title>
    </head>
    <body>
        <h1>Ingreso al Banco</h1>

        <form action="Login">

            ID Usuario: <input type="text" name="id"/><br/>

            Contraseña: <input type="password" name="password"/><br/>

            <input type="submit" name="send" value="Ingresar"/><br/>

            <!--<button onclick="myFunction()">Try it</button>--->

        </form>

    </body>
</html>
