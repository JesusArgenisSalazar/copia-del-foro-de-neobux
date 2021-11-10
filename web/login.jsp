

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*" %>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>

        <link type="text/css" rel="stylesheet" href="styles.css">
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
                
                <img  width="282" height="47" src="images/baner1.png" alt="2">  
               
            </div>
            
            <div id="principal">
                
                <img width="294" height="85" src="images/viñeta.png" alt="2" id="imagen"></img>
                <h2>Login</h2>

                <form action="DateControlador5">

                    <input type = "hidden" name = "codigo"  value ="comprovarUser">

                    <div style = "text-align: center">    
                        <table  border = 0 style = "margin: auto" id="tablaform"> 

                            <tr> 
                                <td>
                                    <label>Usuario :</label> <br> <br>
                                </td>
                                <td>
                                    <input type = "text" name = "usuario" id="campoText"> <br> <br>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Contraseña :</label> <br> <br>
                                </td>
                                <td>
                                    <input type = "text" name = "contraseña" id="campoText"> <br> <br>
                                </td>
                            </tr>
                            <tr>
                                <td colspan = "2" style="text-align: center">
                                    <input type = "submit" name = "boton" value = "Enviar" id="botonMin">
                                </td>
                            </tr>
                        </table>
                    </div>
                </form>
            </div>
        </div>

    </body>
</html>
