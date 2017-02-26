package jwd.wafepa.web.dto;

import java.util.List;

public class TipNekretnineDto {

	private Long id;
	private String naziv;
	public List<NekretninaDto>nekretnine;
	
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
	public List<NekretninaDto> getNekretnine() {
		return nekretnine;
	}
	public void setNekretnine(List<NekretninaDto> nekretnine) {
		this.nekretnine = nekretnine;
	}
	
}
