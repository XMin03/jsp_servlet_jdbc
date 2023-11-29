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

@WebServlet(name = "GrabarSociosServlet", value = "/GrabarSociosServlet")
public class GrabarSociosServlet extends HttpServlet {
    private SocioDAO socioDAO = new SocioDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //decirle a que enviar
        request.setAttribute("action", "GrabarSociosServlet");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/formularioSocio.jsp");

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = null;
        Optional<Socio> optionalSocio = UtilServlet.validaGrabar(request);

        if (optionalSocio.isPresent()) {

            Socio socio = optionalSocio.get();
            this.socioDAO.create(socio);

            List<Socio> listado = this.socioDAO.getAll();
            request.setAttribute("listado", listado);

            dispatcher = request.getRequestDispatcher("ListarSocioServlet");
        } else {
            //decirle a que enviar
            request.setAttribute("action", "GrabarSociosServlet");
            request.setAttribute("error", "Error de validación!");
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/formularioSocio.jsp");
        }
        dispatcher.forward(request,response);

    }

}