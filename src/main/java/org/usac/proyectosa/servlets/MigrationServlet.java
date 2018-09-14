package org.usac.proyectosa.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.usac.proyectosa.controllers.DepartamentoFacade;
import org.usac.proyectosa.models.Departamento;
import org.usac.proyectosa.models.Municipio;

/**
 *
 * @author esvux
 */
@WebServlet(name = "MigrationServlet", urlPatterns = {"/migrate"})
public class MigrationServlet extends HttpServlet {

    @Inject
    DepartamentoFacade departamentos;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Departamento depto = new Departamento(2, "El Progreso");
        depto.setMunicipios(new Municipio[]{
            new Municipio(201, "Guastatoya", depto),
            new Municipio(202, "Morazán", depto),
            new Municipio(203, "San Agustín Acasaguastlán", depto),
            new Municipio(204, "San Cristóbal Acasaguastlán", depto),
            new Municipio(205, "El Jícaro", depto),
            new Municipio(206, "Sansare", depto),
            new Municipio(207, "Sanarate", depto),
            new Municipio(208, "San Antonio la Paz", depto)
        });
        //departamentos.create(depto);
        try(PrintWriter out = response.getWriter()) {
            out.println("Departamento creado correctamente");
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet for migrations";
    }

}
