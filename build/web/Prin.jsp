<%-- 
    Document   : Principal
    Created on : 06-may-2010, 18:26:06
    Author     : Amaterasu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

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
                <div id = "ContenidoPrincipal">
                <img width="294" height="85" src="images/viñeta.png" alt="2" id="imagen"></img>
                <h2>Temas</h2>


                <table id="tablaTemas">
                    <thead>

                    <th colspan="2">
                        Contenido
                    </th>
                    <th>
                        Usuario
                    </th>
                    <th>
                        Fecha
                    </th>
                    <th>
                        Pais Origen
                    </th>

                    </thead>

                    <c:forEach var="tmp" items= "${listPrt}">

                        <c:url var="linkP" value="DateControlador5">

                            <c:param name = "codigo" value = "leerPRTSelection" ></c:param>
                            <c:param name="ID" value="${tmp.id_pregunta}"></c:param>
                            <c:param name ="user" value = "${tmp.username}"></c:param>
                            <c:param name = "pregunta" value = "${tmp.pregunta}" ></c:param>


                        </c:url>

                        <tr>
                            <td class="tdMini">
                                <img width="25" height="25" src="images/imgchat.png">

                            </td>
                            <td>
                                <a href="${linkP}">${tmp.pregunta}</a>  
                            </td>
                            <td>
                                ${tmp.username}
                            </td>
                            <td>
                                ${tmp.fecha}
                            </td>
                            <td>
                                ${tmp.pais_origen}
                            </td>


                        </tr>

                    </c:forEach>

                </table>
                <form method="get" action="DateControlador5">

                    <input type = "hidden" name = "codigo" value ="InsertarPRT" >
                    <input type = "hidden" name = "username" value ="${usuario.username}" >
                    <input type = "hidden" name = "pais" value ="${usuario.paisOrigen}" >


                   
                    <table style = "margin-top: 50px" id="tablaTemas" >

                        <thead>
                        <th colspan="2">
                            Nuevo Tema
                        </th>
                        </thead>
                        <tr>

                            <td>
                                Username: ${usuario.username}<br>
                                Pais : ${usuario.paisOrigen}
                            </td>
                            <td>
                                <textarea name ="PRT" id="campoText" width="400"></textarea>
                            </td>
                             <td>
                                 <input type = "submit" value="Enviar">
                            </td>
                        </tr>


                    </table>



                </form>
            </div>
        </div>
    </div>

</body>
</html>


