package mv.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mv.dao.NoleggioDAO;
import util.DbManager;

import java.io.IOException;
import java.sql.SQLException;


public class NoleggiaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NoleggioDAO noleggioDAO;
    
    public void init() throws ServletException {
         try {
             DbManager dbManager = new DbManager();
             noleggioDAO = new NoleggioDAO(dbManager.getConnection());
          }catch (SQLException e) {
              throw new ServletException(e);
          }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        int id_u = Integer.parseInt(request.getParameter("id_u"));
        int id_f = Integer.parseInt(request.getParameter("id_f"));
        try {
            noleggioDAO.createNoleggio(id_u, id_f);
            response.sendRedirect("catalogo");
        }catch (SQLException e) {
            throw new ServletException(e);
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}