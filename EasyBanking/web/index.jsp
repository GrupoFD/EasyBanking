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
                border-top-right-radius: 5px 5px;
                border-bottom-right-radius: 5px 5px;
                border-top-left-radius: 5px 5px;
                border-bottom-left-radius: 5px 5px;

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
                margin: 0 auto; 
                width:275px;
            }
            form { 
                margin: 0 auto; 
                width:250px;
            }
        </style>
    </style>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>EASY BANKING</title>
</head>
<body>
    <br>

    <br>

    <h1>Ingreso al Banco</h1>

    <br>

    <form action="Login" >

        ID Usuario: <input type="text" name="id" class="ebtextinput"/><br/>

        Contraseña: <input type="password" name="password" class="ebtextinput"/><br/>

        <br>               

        <input type="submit" name="send" value="Ingresar" class="ebbutton" style="width: 200px"/><br/>

    </form>


</body>
</html>
