package be.bstorm.akimts.demoee.servlets.servlets.other;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Random;

@WebServlet("/other/random")
public class RandomServlet extends HttpServlet {

    private final Random random = new Random();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // récupérer les infos nécessaire
        int rdmized = random.nextInt(100)+1;
        // s'assurer que l'info arrive dans la jsp
        req.setAttribute( "rdmized", rdmized );
        // délèguer le reste du travail à la jsp. C'est à dire le travail d'affichage
        req.getRequestDispatcher( "/other/random.jsp" ).forward( req, resp );
    }
}
