package controleur;

import java.util.Collection;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import objets.Carburant;
import objets.PDV;

@WebService()
@Path("/station/")
public class WebServiceStation {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pwa-mysql");
	EntityManager em = emf.createEntityManager();

	@GET
	@Path("/all")
	@Produces({  MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<PDV> getAllPDV() {
		System.out.println("----All PDV---");
		em.getTransaction().begin();
		List<PDV> p= em.createQuery("from PDV", PDV.class).getResultList();
		System.out.println("[ok]\n");
		em.getTransaction().commit();
		return p;
	}

	@GET
	@Path("/ville/{codep}")
	@Produces({ MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON })
	public Collection<PDV> getPdvByVille(@PathParam("codep") long codep) {
		
		System.out.println("----PDV by code postal---" + codep );
		
		em.getTransaction().begin();
		List<PDV> p= em.createQuery("from PDV where CodePostal=:codep", PDV.class)
				.setParameter("codep", codep)
				.getResultList();
		System.out.println(p.get(0));
		em.getTransaction().commit();
		return p;
	}
	
	@GET
	@Path("/dep/{numdep}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Collection<PDV> getPdvByDep(@PathParam("numdep") int codep) {
		
		System.out.println("----PDV by departement---" + codep );
		
		em.getTransaction().begin();
		List<PDV> p= em.createQuery("from PDV where CodePostal like :numdep", PDV.class)
				.setParameter("numdep", codep+"%")
				.getResultList();
		System.out.println(p.get(0));
		em.getTransaction().commit();
		return p;
	}

	@DELETE
	@Path("/carburant/{idPDV}/{nom}")
	public Response deleteCarburant(@PathParam("idPDV") int idPDV, @PathParam("nom") String nom) {
		System.out.println("----invoking deleteCarburant, Carburant: " + idPDV);
		em.getTransaction().begin();
		int p= em.createQuery( "DELETE FROM Carburant c WHERE c.pdv.id= :id and Nom=:nom")
				.setParameter("id", idPDV)
				.setParameter("nom", nom)
				.executeUpdate();
		System.out.println(p);
		em.getTransaction().commit();
		return Response.ok().build();
	}
	
	
	@PUT
	@Path("/carburant/{idPDV}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response addBook(Carburant carbur,@PathParam("idPDV") int idPDV) {
		System.out.println("----invoking update pdv "+ idPDV + ", carburant: " + carbur);
		em.getTransaction().begin();
		int p= em.createQuery( "UPDATE Carburant c SET c.prix=:p  WHERE c.pdv.id= :id and Nom=:nom")
				.setParameter("id", idPDV)
				.setParameter("nom", carbur.getNom())
				.setParameter("p", carbur.getPrix())
				.executeUpdate();
		System.out.println(p);
		em.getTransaction().commit();
		return Response.ok(carbur).build();
	}
	

}
