package org.iesvdm.jsp_servlet_jdbc.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.iesvdm.jsp_servlet_jdbc.dao.SocioDAO;
import org.iesvdm.jsp_servlet_jdbc.dao.SocioDAOImpl;
import org.iesvdm.jsp_servlet_jdbc.model.Socio;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "ListarSocioServlet", value = "/ListarSocioServlet")
public class ListarSocioServlet extends HttpServlet {
    private SocioDAO socioDAO = new SocioDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Socio> listado = this.socioDAO.getAll();
        request.setAttribute("listado", listado);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pideNumeroSocio.jsp");

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Socio> listado = this.socioDAO.getAll();
        request.setAttribute("listado", listado);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pideNumeroSocio.jsp");

        dispatcher.forward(request, response);

    }

}