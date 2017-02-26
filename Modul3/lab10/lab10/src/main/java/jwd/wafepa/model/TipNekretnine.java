package jwd.wafepa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
public class TipNekretnine {

	@Id
	@GeneratedValue
	private Long id;
	private String naziv;
	@OneToMany(mappedBy= "tipNekretnine", cascade=CascadeType.REMOVE)
	private List<Nekretnina>nekretnine= new ArrayList<>();
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public List<Nekretnina> getNekretnine() {
		return nekretnine;
	}
	public void setNekretnine(List<Nekretnina> nekretnine) {
		this.nekretnine = nekretnine;
	}
	
	
}
