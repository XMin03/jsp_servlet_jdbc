<%@ page import="java.sql.*" %>
<%@ page import="org.iesvdm.jsp_servlet_jdbc.model.Socio" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="estilos.css" />
  </head>
  <body>
    <table>
      <tr><th>Código</th><th>Nombre</th><th>Estatura</th><th>Edad</th><th>Localidad</th></tr>
    <%
        List<Socio> listado = (List<Socio>) request.getAttribute("listado");
        for(Socio socio: listado) {
          out.println("<tr><td>");
          out.println(socio.getSocioId() + "</td>");
          out.println("<td>" + socio.getNombre() + "</td>");
          out.println("<td>" + socio.getEstatura() + "</td>");
          out.println("<td>" + socio.getEdad() + "</td>");
          out.println("<td>" + socio.getLocalidad() + "</td>");
    %>
      <td>
      <form method="post" action="BorrarSociosServlet">
        <input type="hidden" name="socioId" value="<%=socio.getSocioId() %>"/>
        <input type="submit" value="borrar">
      </form>
      </td></tr>
    <%
      } // for
     %>
    </table>
  </body>
</html>