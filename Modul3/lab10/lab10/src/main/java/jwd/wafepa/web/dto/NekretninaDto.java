package jwd.wafepa.web.dto;

public class NekretninaDto {

	private Long id;
	private int povrsina;
	private int cena;
	private String adresa;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getPovrsina() {
		return povrsina;
	}
	public void setPovrsina(int povrsina) {
		this.povrsina = povrsina;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	
}
