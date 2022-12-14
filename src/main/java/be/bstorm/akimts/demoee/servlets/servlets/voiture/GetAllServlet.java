package be.bstorm.akimts.demoee.servlets.servlets.voiture;

import be.bstorm.akimts.demoee.servlets.model.Voiture;
import be.bstorm.akimts.demoee.servlets.service.GarageService;
import be.bstorm.akimts.demoee.servlets.service.GarageServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get-all")
public class GetAllServlet extends HttpServlet {

    private final GarageService service = GarageServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        resp.getWriter().println("<!DOCTYPE html>\n" +
                "                    <html lang=\"en\">\n" +
                "                    <head>\n" +
                "                        <meta charset=\"UTF-8\">\n" +
                "                        <title>Title</title>\n" +
                "                    </head>\n" +
                "                    <body>\n" +
                "                                    \n" +
                "                        <h1>La liste des voitures</h1>\n" +
                "                                    \n" +
                "                        <ul>");

        for (Voiture voiture : service.getAll()) {
            out.println("<li>["+ voiture.getId()+"] "+voiture.getMarque()+" - "+voiture.getModele()+" - "+voiture.getPrix()+" $</li>");
        }

        out.println("</ul>" +
                "<a href=\"/demo/contact\">vers la page de contact</a>" +
                "</body></html>");

    }
}
