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
        <h1>Contáctenos</h1>
        <form name="contactenos" action="contactenos" method="POST">
            <span>Nombre</span><input type="text" name="nombre"/>
            <span>Teléfono</span><input type="text" name="telefono"/>
            <span>Dirección</span><input type="text" name="direccion"/>
                
            <button type="submit">guardar información</button>
        </form>
        <table>
            <tr>
                <th>Nombre</th>
                <th>Teléfono</th>
                <th>Dirección</th>
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
