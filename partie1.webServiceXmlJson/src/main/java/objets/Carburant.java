package objets;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@XmlRootElement(name = "carburant")
@Entity
public class Carburant {
	@Id
	@GeneratedValue
	@Column(name="ID_carburant")
	private long id;

	@Column(name="Prix")
	private double prix;
	
	@Column(name="Nom")
	private String nom;
	
	@Column(name="dateMAJ")
	private String dateMAJ;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
	private PDV pdv;
	
	@XmlTransient
	public PDV getPdv() {
		return pdv;
	}
	public void setPdv(PDV pdv) {
		this.pdv = pdv;
	}
	
	public long getId() {
		return id;
	}
	
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDateMAJ() {
		return dateMAJ;
	}
	public void setDateMAJ(String dateMAJ) {
		this.dateMAJ = dateMAJ;
	}
	@Override
	public String toString() {
		return "Carburant [prix=" + prix + ", nom=" + nom + ", dateMAJ=" + dateMAJ + "]";
	}	
	
	
	
}
