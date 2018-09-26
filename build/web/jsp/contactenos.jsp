<%-- 
    Document   : contactenos
    Created on : 21/09/2018, 07:44:42 AM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contáctenos</title>
    </head>
    <body>
        <%@page import="java.util.List" %>
        <%@page import="modelos.Contactenos" %>
        <%
        List<Contactenos> listaContactenos = (List<Contactenos>) request.getAttribute("ListaDesa");
        %>
        <h1>CONTÁCTENOS</h1>
        <form name="contactenos" action="contactenos" method="POST">
            <span>nombre</span><input type="text" name="nombre"/>
            <span>telefono</span><input type="text" name="telefono"/>
            <span>direccion</span><input type="text" name="direccion"/>
                
            <button type="submit">guardar información</button>
        </form>
        <table>
            <tr>
                <th>nombre</th>
                <th>telefono</th>
                <th>direccion</th>
            </tr>
            <% 
                Contactenos c;
                for(int i = 0; i < listaContactenos.size(); i++){
                    c = listaContactenos.get(i);%>
                    <tr>
                        <td><%= c.nombre%></td>
                        <td><%= c.telefono%></td>
                        <td><%= c.direccion%></td>
                    </tr>
                    <%
            }%>
            
            
        </table>
    </body>
</html>
