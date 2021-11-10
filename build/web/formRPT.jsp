<%-- 
    Document   : formRPT
    Created on : 06-may-2010, 7:37:41
    Author     : Amaterasu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>


        <link rel ="stylesheet" type="text/css" href="styles.css">
    </head>
    <body >
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

            <h3>Tema : <span class="diferentcolor"><%= request.getParameter("pregunta")%></span></h3>

            <div id="principalTemas">

                <h1>Danos tu respuesta</h1>

                <div id="Tema">
                    
                    <img width="200" height="42" src="images/viñetaMin.png" alt="2" id="imagen">

                    <table id="TablaRespuestas" >
                        <tr>

                            <td width = 175px height = 60px>
                                   
                                <span class = "username">  <%= request.getParameter("username")%> </span>
                                
                                <%= request.getParameter("pais")%>



                            </td >
                            <td class = "chat" width ="740px" height = 60px>
                                <img width = "786px" height="60px" src="images/chatTop.png" id="imgchatTop">
                                
                                <%= request.getParameter("fecha")%> <br>
                                <%= request.getParameter("respuesta")%>


                                <input type = "submit" name =  "botonCitar" style ="background: mediumseagreen" value ="Citar"> 
                                <img width = "780px" height="60px" src="images/chatbottom.jpg" id = "imgchatbottom"> 

                            </td>
                        </tr>
                    </table>

                </div>

                <form method="get" action="DateControlador5">

                    <input type = "hidden" name = "pregunta" value  = "<%= request.getParameter("pregunta")%>">
                    <input type = "hidden" name = "ID" value  = "<%= request.getParameter("idPRT")%>">
                    <input type = "hidden" name = "user" value  = "<%= request.getParameter("usernamePRT")%>">

                    <input type = "hidden" name = "codigo" value ="InsertarRPT">
                    <input type = "hidden" name = "cita" value = "<%= request.getParameter("respuesta")%>">






                    <table >       
                        <thead>

                        <th>
                            Tu Respuesta :
                        </th>
                        <th>
                            Username
                        </th>
                        <th>
                            Pais
                        </th>
                        </thead>


                        <tr>
                            <td>
                                <input type="text" name = "RPT" size="50">
                            </td>
                            <td>
                                <input type ="text" name = "username" value =  <%= request.getParameter("MIusername")%> >
                            </td>
                            <td>
                                <input type="text" name ="pais" value = <%= request.getParameter("MIpais")%> >
                            </td>
                            <td>
                                <input type ="submit" name = "boton" value = "Enviar">
                            </td>
                        </tr>
                    </table>


                </form>
            </div>
        </div>

    </body>
</html>
