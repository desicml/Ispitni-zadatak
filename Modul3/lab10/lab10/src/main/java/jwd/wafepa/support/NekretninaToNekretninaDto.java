package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Nekretnina;
import jwd.wafepa.web.dto.NekretninaDto;
@Component
public class NekretninaToNekretninaDto implements Converter<Nekretnina, NekretninaDto> {

	@Override
	public NekretninaDto convert(Nekretnina nekretnina) {
		NekretninaDto dto= new NekretninaDto();
		dto.setId(nekretnina.getId());
		dto.setCena(nekretnina.getCena());
		dto.setPovrsina(nekretnina.getPovrsina());
		dto.setAdresa(nekretnina.getAdresa());
		return dto;
	}
	public List<NekretninaDto>convert(List<Nekretnina>nekretnine){
		List<NekretninaDto>dtos= new ArrayList<>();
		for(Nekretnina n:nekretnine){
			dtos.add(convert(n));
		}
		return dtos;
	}

}
