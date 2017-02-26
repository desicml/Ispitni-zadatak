package jwd.wafepa.service;

import java.util.List;

import org.springframework.data.domain.Page;

import jwd.wafepa.model.TipNekretnine;

public interface TipNekretnineService {

	Page<TipNekretnine>findAll(int page);
	TipNekretnine save(TipNekretnine tipNekretnine);
	//Page<TipNekretnine>findByTipNekretnineId(Long nekretninaId);
}
