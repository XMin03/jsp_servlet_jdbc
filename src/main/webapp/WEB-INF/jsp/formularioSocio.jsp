<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <!--desuso-->
    <h2>Introduzca los datos del nuevo socio:</h2>
    <form method="post" action="<%=request.getAttribute("action")%>">
      <input type="hidden" name="socioId" value="<%= request.getParameter("socioId")%>">
      Nombre <input type="text" name="nombre"/></br>
      Estatura <input type="text" name="estatura"/></br>
      Edad <input type="text" name="edad"/></br>
      Localidad <input type="text" name="localidad"/></br>
      <input type="submit" value="Aceptar">
    </form>

  <%
    String error = (String) request.getAttribute("error");
    if (error != null) {
      %>
      <div style="color: red"><%=error%></div>
    <%
      }
  %>

  </body>
</html>