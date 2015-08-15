<%-- 
    Document   : logueado
    Created on : Aug 8, 2015, 6:47:23 PM
    Author     : Soler
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>EasyBanking!</title>

        <style type="text/css">
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
            /* Fixes submit button height problem in Firefox */
            .ebbutton::-moz-focus-inner {
                border: 0;
            }
            .ebclear{
                clear:both;
            }
        </style>
    </head>
    <body id="ebsearch">

        <% Date d = new Date();%>

        <div id="ebsearch">

            <h1>Bienvenido,<br> <%= request.getParameter("userName")%>!</h1>
            Fecha de ingreso: <%=d%>

        </div>


        <div id="ebsearch">
            <form id="ebnewsearch" method="get" action="UserData">
                <input type="text" class="ebtextinput" name="search" size="21" maxlength="120"><input type="submit" value="Buscar" class="ebbutton">
            </form>
            <div class="ebclear"></div>

        </div>
            <table border="1">
<%
     ArrayList<String> lst = (ArrayList<String>) session.getAttribute("RESULT_CLIENT");
     if (lst != null) {
     for (String str : lst) {
%>
    <tr>
        <td><%=str%></td>
        <td><%=str%></td>
    </tr>        
<%
      }
     }
     session.removeAttribute("RESULT_CLIENT");
%>
</table>

        <h1>Presione en la transaccion que desea realizar</h1>
        <form action="newClient.jsp">
            <input type="submit" value="Agregar cliente" name="newClient" />    
        </form>
        <form action="createAccount.jsp">
            <input type="submit" value="Crear cuenta" name="createAccount" />
        </form>
    </body>

</html>
