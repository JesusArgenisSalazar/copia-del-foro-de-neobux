

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*" %>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sinc up</title>

        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>

    <body>
        <div id="contenedor"> 

            <div id = "barra">

                <ul>
                    <li>
                        <a href="Sinc_up.jsp">Registrate</a>  
                    </li>

                    <li>
                        <a href ="login.jsp">Login</a> 
                    </li>
                </ul>

            </div>

            <div id= "baner">

                <img width="282" height="47" src="images/baner1.png" alt="2">  

            </div>


            <div id="principal">

                <img width="294" height="85" src="images/viñeta.png" alt="2" id="imagen"></img>
                <h2>Registrate</h2>
                <form action="DateControlador5">

                    <input type = "hidden" name = "codigo"  value ="insertarUser">


                    <table width = "300" border = "0" style = "margin : 0 auto" id="tablaform"> 

                        <tr> 

                        <tr>
                            <td>
                                <label>Correo : </label> <br> <br>
                            </td>
                            <td>
                                <input type = "text" name = "correo" id="campoText"> <br> <br>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Pais de origen : </label> <br> <br>
                            </td>
                            <td>
                                <input type = "text" name = "paisOrigen" id = "campoText"> <br> <br>
                            </td>
                        </tr>

                        <td>
                            <label>Usuario : </label> <br> <br>
                        </td>
                        <td>
                            <input type = "text" name = "usuario" id = "campoText"> <br> <br>
                        </td>

                        <tr>
                            <td>
                                <label>Contrasena : </label> <br> <br>
                            </td>
                            <td>
                                <input type = "text" name = "contraseña" id = "campoText"> <br> <br>
                            </td>
                        </tr>
                        <tr>
                            <td colspan = "2" style="text-align: center">
                                <input type = "submit" name = "boton" value = "Enviar" id = "botonMin">
                            </td>
                        </tr>
                    </table>
                </form>
               
                 </div> 
                </div> 
                </body>
                </html>
