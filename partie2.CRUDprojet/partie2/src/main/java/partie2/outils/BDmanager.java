package partie2.outils;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import partie2.objets.Approvision;
import partie2.objets.Vehicule;

public class BDmanager {

	
	private static final EntityManagerFactory   emf = Persistence.createEntityManagerFactory("pwa-mysql");;
	
	
	public BDmanager(){
		
		
	}
	
	
	public void AjouterVehicuke(Vehicule v) {
		EntityManager em =emf.createEntityManager(); 
		em.getTransaction().begin();
		em.persist(v);
		for(Approvision app:v.getAps()){ em.persist(app); }
		em.getTransaction().commit();
		em.close();
		
	}
	
	
	public void ModifierVehicuke(Vehicule v) { 
		EntityManager em =emf.createEntityManager(); 
		em.getTransaction().begin();
		em.merge(v);
		for(Approvision app:v.getAps()){ em.merge(app); }
		em.getTransaction().commit();
		System.out.println("Modifier  ");
		em.close();
		
	}
	
	public void SupprimerVehicuke(String ImVehicule) { 
		EntityManager em =emf.createEntityManager(); 
		em.getTransaction().begin();
		int p= em.createQuery( "DELETE FROM Approvision ap WHERE  ap.vehi.immatriculation=:Im")
				.setParameter("Im",  ImVehicule)
				.executeUpdate();
		int b = em.createQuery( "DELETE FROM Vehicule v  WHERE  v.immatriculation=:Im")
				.setParameter("Im",  ImVehicule)
				.executeUpdate();
		em.getTransaction().commit();
		em.close();
		System.out.println("Supprimer  " + b + " - "+p);
		
	}
	
	public List <Vehicule> ListVehicule() { 
		EntityManager em =emf.createEntityManager(); 
		List<Vehicule> l=  em.createQuery("from Vehicule", Vehicule.class).getResultList(); 
		em.close();
		
		return l;
		
		}
	
	public Vehicule getVehiculeByImm(String Im) { 
		EntityManager em =emf.createEntityManager();
		Vehicule v =  (Vehicule) em.createQuery("from Vehicule v where v.immatriculation=:Im",Vehicule.class)
				.setParameter("Im", Im)
				.getSingleResult();
		em.close();
		return v; 
	
	}
	
	public void AjouterApprovi(Approvision app) {
		EntityManager em =emf.createEntityManager(); 
		em.getTransaction().begin();
		em.merge(app);
		em.getTransaction().commit();
		em.close();
	}
	
	public List <Approvision> ListAppr(String Im) { 		
		EntityManager em =emf.createEntityManager(); 
		List <Approvision> l =  em.createQuery("from Approvision a where a.v.immatriculation =: Im ",Approvision.class)
				.setParameter("Im", Im)
				.getResultList();
		em.close();
		return l;
		
	
	}
	
	public Approvision getAppr(int Id) { 		
		EntityManager em =emf.createEntityManager(); 
		Approvision a =  em.createQuery("from Approvision a where  a.id =:id ",Approvision.class)
				.setParameter("id", Id)
				.getSingleResult();
		em.close();
		return a;
		
	
	}
	
	public void SupprimerApp(int id) {
		EntityManager em =emf.createEntityManager(); 
		em.getTransaction().begin();
		int p= em.createQuery( "DELETE FROM Approvision ap WHERE  ap.id=:Id")
				.setParameter("Id",  id)
				.executeUpdate();
		em.getTransaction().commit();
		em.close();
	}
	
	
	
}
