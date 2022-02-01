package partie2.objets;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Vehicule {

	@Id 
	@Column(name="Immatriculation")
	private String immatriculation;
	
	@Column(name="Modele")
	private String modele;
	
	@Column(name="Kilometrage")
	private String kilometrage;
	
	@Column(name="Type") 
	private int type;
	
	@Column(name="NbPLace")
	private int nbPlace;
	
	@Column(name="TypeCarburant")
	private String typeCarburant;
	
	@Column(name="DateAchat")
	private String dateAchat;
	
	@Column(name="DateProchaineRevision")
	private String dateProchaineRevision;
	
	@OneToMany( cascade = {CascadeType.REMOVE},fetch= FetchType.EAGER,mappedBy = "vehi")
	private List<Approvision>aps;
	
	

	public String getImmatriculation() {
		return immatriculation;
	}

	public Vehicule() {
		aps = new ArrayList<Approvision>();
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}


	public String getModele() {
		return modele;
	}


	public void setModele(String modele) {
		this.modele = modele;
	}


	public String getKilometrage() {
		return kilometrage;
	}


	public void setKilometrage(String kilometrage) {
		this.kilometrage = kilometrage;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public int getNbPlace() {
		return nbPlace;
	}


	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}


	public String getTypeCarburant() {
		return typeCarburant;
	}


	public void setTypeCarburant(String typeCarburant) {
		this.typeCarburant = typeCarburant;
	}


	public String getDateAchat() {
		return dateAchat;
	}


	public void setDateAchat(String dateAchat) {
		this.dateAchat = dateAchat;
	}


	public String getDateProchaineRevision() {
		return dateProchaineRevision;
	}


	public void setDateProchaineRevision(String dateProchaineRevision) {
		this.dateProchaineRevision = dateProchaineRevision;
	}


	public List<Approvision> getAps() {
		return aps;
	}


	public void setAps(ArrayList<Approvision> apss) {
		for(Approvision ap : apss)
			addApp(ap);
	}
	
	public void addApp(Approvision a) {
	    this.aps.add(a);
	}

	@Override
	public String toString() {
		return "Vehicule [immatriculation=" + immatriculation + ", modele=" + modele + ", kilometrage=" + kilometrage
				+ ", type=" + type + ", nbPlace=" + nbPlace + ", typeCarburant=" + typeCarburant + ", dateAchat="
				+ dateAchat + ", dateProchaineRevision=" + dateProchaineRevision + ", aps=" + aps + "]";
	}

	
}
