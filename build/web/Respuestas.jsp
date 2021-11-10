<%-- 
    Document   : Respuestas
    Created on : 06-may-2010, 1:18:29
    Author     : Amaterasu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    
    
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

        <h3>Tema : <span class="diferentcolor"><%= request.getParameter("pregunta")%></span></h3>
        
        <div id="principalTemas">
            
            
                
            <%--
            el form dentro del bucle envia los datos al formRPT q te permitar sitar la rpt actual
            la tabla se encuentra dentro del form para poder tener el boton type submit
            en ella y darle estetica a la pagina
            
            --%>
            <c:forEach var="varTmp" items="${ListRespuestas}">
                <div id = "Tema">
                
                <img width="200" height="42" src="images/viñetaMin.png" alt="2" id="imagen">
                 
                
                <form action="formRPT.jsp" method="get">


                    <input type = "hidden" name = "pregunta" value = "${pregunta}">
                    <input type = "hidden" name = "idPRT" value = "<%= request.getParameter("ID")%>">
                    <input type = "hidden" name = "usernamePRT" value = "<%= request.getParameter("user")%>">


                    <input type = "hidden" name = "idRPT" value = "${varTmp.id_respuesta}">
                    <input type = "hidden" name = "username" value = "${varTmp.username}">
                    <input type = "hidden" name = "fecha" value = "${varTmp.fecha}">
                    <input type = "hidden" name = "pais" value = "${varTmp.pais_origen}">
                    <input type = "hidden" name = "respuesta" value = "${varTmp.respuesta}">


                    <input type = "hidden" name = "MIpais" value = "${usuario.paisOrigen}">
                    <input type = "hidden" name = "MIusername" value = "${usuario.username}">

                    <table id="TablaRespuestas">
                        <tr>

                            <td width = 175px height = 60px >
                                
                                <span class = "username"> ${varTmp.username}</span>
                                ${varTmp.pais_origen}
                            </td>
                            <td class = "chat" width ="740px" height = 60px >
                                <img width = "786px" height="60px" src="images/chatTop.png" id="imgchatTop">
                                ${varTmp.fecha}<br>
                                ${varTmp.respuesta} 

                                <input type = "submit" name =  "botonCitar" style ="background: mediumseagreen" value ="Citar"> 
                                <img width = "780px" height="60px" src="images/chatbottom.jpg" id = "imgchatbottom"> 
                                
                            </td>
                        </tr>
                    </table>

                </form>
                               
                </div> 
            </c:forEach>


            
            <form method="get" action="DateControlador5">

                <input type = "hidden" name = "codigo" value ="InsertarRPT">
                <input type = "hidden" name = "ID" value  = "<%= request.getParameter("ID")%>">
                <input type = "hidden" name ="pregunta" value = "<%= request.getParameter("pregunta")%>"> 
                <input type = "hidden" name ="user" value = "<%= request.getParameter("user")%>">



                <table style=" text-align: left">       
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
                            <input type ="text" name = "username" value = "${usuario.username}">
                        </td>
                        <td>
                            <input type="text" name ="pais" value = "${usuario.paisOrigen}">
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
