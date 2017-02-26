package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.TipNekretnine;
import jwd.wafepa.repository.TipNekretnineRepository;
import jwd.wafepa.web.dto.TipNekretnineDto;
@Component
public class TipNekretnineDtoToTipNekretnine implements Converter<TipNekretnineDto, TipNekretnine> {

	@Autowired
	private TipNekretnineRepository tipNekretnineRepository;
	@Override
	public TipNekretnine convert(TipNekretnineDto dto) {
		TipNekretnine tip= new TipNekretnine();
		if(dto.getId()!=null){
			tip = tipNekretnineRepository.findOne(dto.getId());
			if(tip==null){
				throw new IllegalStateException("tried to modify nonexistant tip nekretnine");
			}
		}
		tip.setId(dto.getId());
		tip.setNaziv(dto.getNaziv());
		
		return tip;
	}
	
	private List<TipNekretnine>convert(List<TipNekretnineDto>dtos){
		List<TipNekretnine>tipovi= new ArrayList<>();
		
		for(TipNekretnineDto dt:dtos){
			tipovi.add(convert(dt));
		}
		return tipovi;
	}

}
