package be.bstorm.akimts.demoee.servlets.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.getWriter().println(
                "<!DOCTYPE html>\n" +
                "<html lang=\"fr\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Contact</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Contact</h1>\n" +
                "    <div>\n" +
                "        <p><span>adresse:</span> 56 rue du Servlet, 1111 Jakarta </p>\n" +
                "        <p><span>num. tel.:</span> 0400/00.00.00</p>\n" +
                "        <p><span>email:</span> Garage Rafistole </p>\n" +
                "    </div>\n" +
                "    <a href=\"./get-all\">retour à la liste</a>\n" +
                "</body>\n" +
                "</html>"
        );

    }
}
