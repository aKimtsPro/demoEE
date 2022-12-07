package be.bstorm.akimts.demoee.servlets.servlets;

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
import java.util.Optional;

@WebServlet("/get-one")
public class GetOneServlet extends HttpServlet {

    private final GarageService service = GarageServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String indexParam = req.getParameter("index");

        if( indexParam == null ){
            resp.sendError(400, "un param index devrait être donné");
            return;
        }

        try {
            int index = Integer.parseInt( indexParam );
            Voiture v = service.getOne( index );
            resp.getWriter().println(
                            "<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <title>Title</title>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "    <h1>Voiture d'id " + v.getId() + "</h1>\n" +
                            "    <div>\n" +
                            "        <p><span>id:</span> "+ v.getId() +" </p>\n" +
                            "        <p><span>marque:</span> " + v.getMarque() + " </p>\n" +
                            "        <p><span>modele:</span> " + v.getModele() + " </p>\n" +
                            "        <p><span>prix:</span> " + v.getPrix() + "$ </p>\n" +
                            "    </div>\n" +
                            "    <a href=\"./get-all\">retour à la liste</a>\n" +
                            "</body>\n" +
                            "</html>"
                    );

//            Optional<Voiture> optVoiture = service.getOne(id);
//
//            PrintWriter out = resp.getWriter();
//            optVoiture.ifPresentOrElse(
//                    v ->  out.println(
//                            "<!DOCTYPE html>\n" +
//                            "<html lang=\"en\">\n" +
//                            "<head>\n" +
//                            "    <meta charset=\"UTF-8\">\n" +
//                            "    <title>Title</title>\n" +
//                            "</head>\n" +
//                            "<body>\n" +
//                            "    <h1>Voiture d'id " + v.getId() + "</h1>\n" +
//                            "    <div>\n" +
//                            "        <p><span>id:</span> "+ v.getId() +" </p>\n" +
//                            "        <p><span>marque:</span> " + v.getMarque() + " </p>\n" +
//                            "        <p><span>modele:</span> " + v.getModele() + " </p>\n" +
//                            "        <p><span>prix:</span> " + v.getPrix() + "$ </p>\n" +
//                            "    </div>\n" +
//                            "\n" +
//                            "    <a href=\"./get-all\">retour à la liste</a>\n" +
//                            "\n" +
//                            "</body>\n" +
//                            "</html>"
//                    ),
//                    () -> {
//                        resp.setStatus(404);
//                        out.println("voiture not found");
//                    }
//            );
        }
        catch (NumberFormatException ex){
            resp.sendError(400, "param index invalide");
        }
        catch (RuntimeException ex){
            resp.sendError(404, "voiture non trouvé");
        }

    }
}
