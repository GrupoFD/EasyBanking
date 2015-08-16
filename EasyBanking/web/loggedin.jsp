<%-- 
    Document   : logueado
    Created on : Aug 8, 2015, 6:47:23 PM
    Author     : Soler
--%>

<%@page import="com.easybanking.banking.User"%>
<%@page import="com.easybanking.banking.Person"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>EasyBanking!</title>

        <style type="text/css">
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
        </style>
    </head>
    <body id="ebsearch">

        <%
            Date d = new Date();
            User u = (User) session.getAttribute("USER");
        %>


        <div id="ebsearch">

            <h1>Bienvenido,<br> <%= u.getName()%>!</h1>
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
                ArrayList<Person> searchResult = (ArrayList<Person>) session.getAttribute("RESULT_CLIENT");

                if (searchResult != null) {

            %>
            <td align="center">Cedula</td>
            <td align="center">Nombre</td>
            <td align="center">Primer Apellido</td>
            <td align="center">Segundo Apellido</td>
            <td align="center">Correo Electronico</td>
            <%                if (searchResult != null) {
                    for (Person p : searchResult) {
            %>
            <tr>
                <td align="center"><%=p.getId()%></td>
                <td align="center"><%=p.getName()%></td>
                <td align="center"><%=p.getLastName()%></td>
                <td align="center"><%=p.getLastName2()%></td>
                <td align="center"><%=p.getEmail()%></td>
                <!--<td style="btn"><a href="banking.jsp?id=<%=p.getId()%>&name=<%=p.getName()%>">Ingresar</a></td>-->
                <td class="ebbutton"><a href="ClientInfo?id=<%=p.getId()%>&name=<%=p.getName()%>" style="color: #ffffff">Ingresar</a></td>
            </tr>        
            <%
                        }
                    }
                }

                session.removeAttribute("RESULT_CLIENT");
            %>
        </table>

        <h1>Presione en la transaccion que desea realizar</h1>
        <form action="newclient.jsp">
            <input type="submit" value="Agregar cliente" name="newclient" />    
        </form>

        <form action="createuser.jsp">
            <input type="submit" value="Agregar usuario" name="newUser" />
        </form>
    </body>


</html>
