package org.usac.proyectosa.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esvux
 */
@WebServlet(name = "MigrationServlet", urlPatterns = {"/migrate"})
public class MigrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()) {
            out.println("Nothing to do here!!!");
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet for migrations";
    }

}
