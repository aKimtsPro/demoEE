package be.bstorm.akimts.demoee.servlets.servlets.voiture;

import be.bstorm.akimts.demoee.servlets.model.Voiture;
import be.bstorm.akimts.demoee.servlets.service.GarageService;
import be.bstorm.akimts.demoee.servlets.service.GarageServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddJSPServlet", value = "/voiture/add")
public class AddJSPServlet extends HttpServlet {

    private final GarageService service = GarageServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String marque = request.getParameter("marque");
        String modele = request.getParameter("modele");
        long id = Long.parseLong( request.getParameter("id") );
        double prix = Double.parseDouble( request.getParameter("prix") );

        Voiture v = new Voiture(id, marque, modele, prix);

        service.ajouter(v);

        response.sendRedirect("/demo/voiture/get-all.jsp");
    }
}
