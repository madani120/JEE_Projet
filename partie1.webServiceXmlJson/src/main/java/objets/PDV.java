package objets;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@XmlRootElement(name = "pdv")
@Entity 
public class PDV {
	
	@Id 
	@Column(name="ID_pdv")
	private int id;
	
	@Column(name="CodePostal")
	private String codeP;
	
	@Column(name="Ville")
	private String ville;
	
	@Column(name="Adresse")
	private String adresse;
	
	@JsonIgnore
	@XmlElement(name="carburant")
	@OneToMany(mappedBy = "pdv",cascade = {CascadeType.MERGE},fetch= FetchType.EAGER)
	private Collection<Carburant> Carburants;
	
	
	public PDV() {
		Carburants = new ArrayList<Carburant>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodeP() {
		return codeP;
	}
	public void setCodeP(String codeP) {
		this.codeP = codeP;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	
	public Collection<Carburant> getCarburants() {
		return Carburants;
	}
	@XmlTransient
	public void setCarburants(Collection<Carburant> carburants) {
		Carburants = carburants;
	}
	@Override
	public String toString() {
		return "PDV [id=" + id + ", codeP=" + codeP + ", ville=" + ville + ", adresse=" + adresse + ", Carburants="
				+ Carburants + "]";
	}
	
	
	

}
