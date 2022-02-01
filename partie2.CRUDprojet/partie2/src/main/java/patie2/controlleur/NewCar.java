package patie2.controlleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import partie2.objets.Vehicule;
import partie2.outils.BDmanager;

/**
 * Servlet implementation class NewCar
 */
public class NewCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final BDmanager BD = new BDmanager();
   
    public NewCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("newcar.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Vehicule v = new Vehicule();
		v.setImmatriculation(request.getParameter("immatriculation"));
		v.setModele(request.getParameter("modele"));
		v.setDateAchat(request.getParameter("dateA"));
		v.setDateProchaineRevision(request.getParameter("dateR"));
		v.setKilometrage(request.getParameter("kilometrage"));
		v.setNbPlace(Integer.parseInt(request.getParameter("nbplace")));
		v.setType(Integer.parseInt(request.getParameter("type")));
		v.setTypeCarburant(request.getParameter("typeCarburant"));
		System.out.println(v);
		int check =1;
		try {
			
			BD.AjouterVehicuke(v);
			
		}catch(Exception e) {
			check=0;
			request.setAttribute("erreur", e.getMessage());
			e.printStackTrace();
		}
		 
		request.setAttribute("check", check);
		doGet(request, response);
	}

}
