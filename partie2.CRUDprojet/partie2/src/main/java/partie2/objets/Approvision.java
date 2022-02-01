package partie2.objets;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Approvision {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id_app")
	private int id;
	
	@Column(name="Dateapprov")
	private String dateapprov;
	
	@Column(name="Quantite")
	private double quantite;
	
	@Column(name="PrixUnitaire")
	private double prixUnitaire;
	
	@Column(name="Montant")
	private double montant;
	
	@ManyToOne(cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
	Vehicule vehi;
	


	@Override
	public String toString() {
		return "Approvision [id=" + id + ", dateapprov=" + dateapprov + ", quantite=" + quantite + ", prixUnitaire="
				+ prixUnitaire + ", montant=" + montant + "]";
	}

	public Vehicule getV() {
		return vehi;
	}

	public void setV(Vehicule v) {
		this.vehi = v;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateapprov() {
		return dateapprov;
	}

	public void setDateapprov(String dateapprov) {
		this.dateapprov = dateapprov;
	}

	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant() {
		this.montant = calulerMontant();
	}
	
	public double calulerMontant()
	{
		montant=prixUnitaire*quantite;
		return montant;
	}
	
	

}
