package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.TipNekretnine;
import jwd.wafepa.web.dto.TipNekretnineDto;
@Component
public class TipNekretnineToTipNekretnineDto implements Converter<TipNekretnine, TipNekretnineDto> {

	NekretninaToNekretninaDto n2nDto= new NekretninaToNekretninaDto();
	@Override
	public TipNekretnineDto convert(TipNekretnine tipNekretnine) {
		TipNekretnineDto dto= new TipNekretnineDto();
		
		dto.setId(tipNekretnine.getId());
		dto.setNaziv(tipNekretnine.getNaziv());
		dto.setNekretnine(n2nDto.convert(tipNekretnine.getNekretnine()));
		return dto;
	}

	public List<TipNekretnineDto>convert(List<TipNekretnine>tipovi){
		List<TipNekretnineDto>dtos= new ArrayList<>();
		for(TipNekretnine tip:tipovi){
			dtos.add(convert(tip));
		}
		return dtos;
	}
}
