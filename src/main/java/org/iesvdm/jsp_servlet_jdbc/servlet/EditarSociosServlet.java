package org.iesvdm.jsp_servlet_jdbc.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesvdm.jsp_servlet_jdbc.dao.SocioDAO;
import org.iesvdm.jsp_servlet_jdbc.dao.SocioDAOImpl;
import org.iesvdm.jsp_servlet_jdbc.model.Socio;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "EditarSociosServlet", value = "/EditarSociosServlet")
public class EditarSociosServlet extends HttpServlet {
    private SocioDAO socioDAO = new SocioDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //decirle a que enviar
        req.setAttribute("action", "EditarSociosServlet");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/formularioSocioB.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = null;
        Optional<Socio> optionalSocio = UtilServlet.validaGrabar(request);

        if (optionalSocio.isPresent()) {

            Socio socio = optionalSocio.get();
            socio.setSocioId(Integer.parseInt(request.getParameter("codigo")));
            //update despues de crear el socio con su id
            this.socioDAO.update(socio);
            dispatcher = request.getRequestDispatcher("ListarSocioServlet");
        } else {
            //decirle a que enviar
            request.setAttribute("action", "EditarSociosServlet");
            request.setAttribute("error", "Error de validación!");
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/formularioSocioB.jsp");
        }
        dispatcher.forward(request,response);    }
}

