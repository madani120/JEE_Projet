package patie2.controlleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import partie2.objets.Approvision;
import partie2.objets.Vehicule;
import partie2.outils.BDmanager;

/**
 * Servlet implementation class afficher
 */
public class afficher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final BDmanager BD = new BDmanager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public afficher() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Im= request.getParameter("inf");
		String supp= request.getParameter("supp");
		
	     
	       if (Im!=null)
			try {
				Vehicule v = new Vehicule();
				v=BD.getVehiculeByImm(Im);
				request.setAttribute("vehi", v);
				
			}catch(Exception e) {
				request.setAttribute("erreur", e.getMessage());
				e.printStackTrace();
			}
			
	       if (supp!=null)
				try {
					String im = BD.getAppr(Integer.parseInt(supp)).getV().getImmatriculation();
					
					BD.SupprimerApp(Integer.parseInt(supp));
					Vehicule v =BD.getVehiculeByImm(im);
					request.setAttribute("vehi", v);
					
				}catch(Exception e) {
					request.setAttribute("erreur", e.getMessage());
					e.printStackTrace();
				}
				
				
			request.getRequestDispatcher("affich.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    Approvision a = new Approvision();
	    Vehicule v = new Vehicule();
		v=BD.getVehiculeByImm(request.getParameter("Im"));
		
		a.setDateapprov(request.getParameter("dateap"));
		a.setPrixUnitaire(Double.parseDouble(request.getParameter("pu")));
		a.setQuantite(Double.parseDouble(request.getParameter("qte")));
		a.setV(v);
		a.setMontant();
		BD.AjouterApprovi(a);
		v=BD.getVehiculeByImm(request.getParameter("Im"));
		System.out.println(v);
		request.setAttribute("vehi", v);
		doGet(request, response);
	}

}
