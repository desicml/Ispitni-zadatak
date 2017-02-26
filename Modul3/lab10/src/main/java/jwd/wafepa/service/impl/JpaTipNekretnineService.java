package jwd.wafepa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.TipNekretnine;
import jwd.wafepa.repository.TipNekretnineRepository;
import jwd.wafepa.service.TipNekretnineService;
@Service
public class JpaTipNekretnineService implements TipNekretnineService {

	@Autowired
	TipNekretnineRepository tipNekretnineRepository;
	@Override
	public Page<TipNekretnine> findAll(int page) {
		// TODO Auto-generated method stub
		return tipNekretnineRepository.findAll(new PageRequest(page, 3));
	}
	@Override
	public TipNekretnine save(TipNekretnine tipNekretnine) {
		// TODO Auto-generated method stub
		return tipNekretnineRepository.save(tipNekretnine);
	}
//	@Override
//	public Page<TipNekretnine> findByTipNekretnineId(Long nekretninaId) {
//		// TODO Auto-generated method stub
//		return tipNekretnineRepository.findByTipNekretnineId(nekretninaId);
//	}

}
