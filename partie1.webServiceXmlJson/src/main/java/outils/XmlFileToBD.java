package outils;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import objets.Carburant;
import objets.PDV;

public class XmlFileToBD extends DefaultHandler{
	
	private ArrayList<PDV> pdvs;
	private PDV pdv;
	
	private String elementContent;
	
	public XmlFileToBD() {
		this.pdvs = new ArrayList<PDV>();
		elementContent=null;
		
	}
	
	@Override
	public void startElement(String uri, String name, String qname, Attributes attrs)
	{
		if (qname == "pdv")
		{
			pdv = new PDV();	
			pdv.setId(Integer.parseInt(attrs.getValue("id")));
			pdv.setCodeP(attrs.getValue("cp"));
		}
		else if (qname == "adresse" || qname == "ville")
		{
			elementContent = new String();
		}
		else if (qname == "prix")
		{
			Carburant carburant = new Carburant();
			carburant.setPdv(pdv);
			carburant.setNom(attrs.getValue("nom"));
			carburant.setPrix(Double.parseDouble(attrs.getValue("valeur")));
			carburant.setDateMAJ(attrs.getValue("maj"));
			
			pdv.getCarburants().add(carburant);
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qname)
	{
		if (qname == "pdv")
		{
			pdvs.add(pdv);
		}
		else if (qname == "adresse")
		{
			pdv.setAdresse(elementContent);
			elementContent = null;
		}
		else if (qname == "ville")
		{
			pdv.setVille(elementContent);
			elementContent = null;
		}
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
	{
		
		if (elementContent != null)
		{
			String chars = new String(ch, start, length);
			elementContent += chars;
		}
	}
	
	@Override
	public String toString()
	{
		String res = "";
		for (PDV pointDeVente : pdvs)
			res += pointDeVente + "\n";
		
		return res;
	}
	
	public void chargerFichier(String filePath) throws Exception
	{
	/*Parser les donnees xml avec nos classes PDV et carburant */
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse(new File(filePath), this);
		
	/*charger les données dans la BD PAR PERSISTANCEE HIBERNATE */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pwa-mysql");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	
		for(PDV pdv:pdvs)
		{
			em.persist(pdv);
			
			for(Carburant carbur:pdv.getCarburants()) {
				em.persist(carbur);
			}
		}
		em.getTransaction().commit();
		
		em.close();
	}
	
	
	
	
	
}
