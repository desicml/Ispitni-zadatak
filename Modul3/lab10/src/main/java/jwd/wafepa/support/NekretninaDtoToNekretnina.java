package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Nekretnina;
import jwd.wafepa.service.NekretnineService;
import jwd.wafepa.web.dto.NekretninaDto;
@Component
public class NekretninaDtoToNekretnina implements Converter<NekretninaDto, Nekretnina> {

	@Autowired
	NekretnineService nekretninaService;
	@Override
	public Nekretnina convert(NekretninaDto dto) {
		Nekretnina nekretnina= new Nekretnina();
		if(dto.getId()!=null){
			nekretnina= nekretninaService.findOne(dto.getId());
			if(nekretnina==null){
				throw new IllegalStateException("Tried to modify nonexistant nekretnina");
			}
		}
		nekretnina.setId(dto.getId());
		nekretnina.setCena(dto.getCena());
		nekretnina.setPovrsina(dto.getPovrsina());
		nekretnina.setAdresa(dto.getAdresa());
		
		return nekretnina;
	}
	
	public List<Nekretnina>convert(List<NekretninaDto>dtos){
		
		List<Nekretnina>nekretnine= new ArrayList<>();
		for(NekretninaDto dt:dtos){
			nekretnine.add(convert(dt));
			}
		return nekretnine;
	}

}
