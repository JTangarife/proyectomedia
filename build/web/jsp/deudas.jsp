<%-- 
    Document   : deudas
    Created on : 17/09/2018, 08:36:39 AM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deudas</title>
        <style>
            h1{
                color: blue;
            }  
            
        </style>
    </head>
    <body>
        <%@page import="java.util.List" %>
        <%@page import="modelos.Deudas" %>
        <%
        List<Deudas> listaDeudas = (List<Deudas>)request.getAttribute("listaDeu");
        %>
        <h1>Cuentas de deudas en la tienda</h1>
        <form name="deudas" action="deudas" method="POST">
            <span>idusuario</span><input type="text" name="idusuario" />
            <span>valor deudas</span><input type="number" name="valor_deudas" />
            
            
            <button type="submit">Confirmar deudas</button>
            <button type="submit">Confirmar paz y salvo</button>

        </form>
        
        <table border="1">
            <tr>
                <th>idusuario</th>
                <th>valor deudas</th>
            </tr>
            <%
            Deudas d;
            for(int i = 0; i < listaDeudas.size(); i++){
                d = listaDeudas.get(i);%>
                <tr>
                    <td><%= d.idusuario%></td>
                    <td><%= d.valor_deudas%></td>

                </tr>
            <%
            }%>
        </table>
    </body>
</html>
