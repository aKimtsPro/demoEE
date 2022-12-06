package be.bstorm.akimts.demoee.servlets;

import be.bstorm.akimts.demoee.servlets.model.Voiture;
import be.bstorm.akimts.demoee.servlets.service.GarageService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/add")
public class AddVoitureServlet extends HttpServlet {

    private GarageService service;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service.ajouter(new Voiture(0,null,null,5));
    }
}
