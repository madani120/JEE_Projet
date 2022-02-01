package patie2.controlleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import partie2.objets.Vehicule;
import partie2.outils.BDmanager;

/**
 * Servlet implementation class InitServlet
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final BDmanager BD  = new BDmanager();
    /**
     * Default constructor. 
     */
    public InitServlet() {
       
    }
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String suppIm= request.getParameter("supp");
        if (suppIm!=null)
		try {
			
			BD.SupprimerVehicuke(suppIm);
			
		}catch(Exception e) {
			request.setAttribute("erreur", e.getMessage());
			e.printStackTrace();
		}
		List<Vehicule> lv = BD.ListVehicule();
		request.setAttribute("vehicules", lv);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
