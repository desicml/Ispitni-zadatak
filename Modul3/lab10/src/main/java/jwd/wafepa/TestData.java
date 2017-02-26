package jwd.wafepa;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jwd.wafepa.model.Nekretnina;
import jwd.wafepa.model.TipNekretnine;
import jwd.wafepa.service.NekretnineService;
import jwd.wafepa.service.TipNekretnineService;


@Component
public class TestData {

	
	@Autowired
	TipNekretnineService tipService;
	
	@Autowired
	NekretnineService nekretninaService;
	
	@PostConstruct
	public void init(){
		
		for(int i=1;i<=3;i++){
			TipNekretnine tip= new TipNekretnine();
			tip.setNaziv("Naziv "+i);
			tipService.save(tip);
			for(int j=1; j<20;j++){
				Nekretnina nekretnina= new Nekretnina();
				nekretnina.setAdresa("neka "+i);
				nekretnina.setCena(120);
				nekretnina.setPovrsina(50);
				
				nekretnina.setTipNekretnine(tip);
				
				nekretninaService.save(nekretnina);
			}
		}

	
	}
}
