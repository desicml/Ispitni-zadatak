package jwd.wafepa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Nekretnina;
import jwd.wafepa.repository.NekretninaRepository;
import jwd.wafepa.service.NekretnineService;
@Service
public class JpaNekretninaService implements NekretnineService {

	@Autowired
	NekretninaRepository nekretninaRepository;
	@Override
	public Nekretnina findOne(Long id) {
		// TODO Auto-generated method stub
		return nekretninaRepository.findOne(id);
	}

	@Override
	public Page<Nekretnina> findAll(int page) {
		// TODO Auto-generated method stub
		return nekretninaRepository.findAll(new PageRequest(page, 10));
	}

	@Override
	public Nekretnina save(Nekretnina nekretnina) {
		// TODO Auto-generated method stub
		return nekretninaRepository.save(nekretnina);
	}

	@Override
	public Nekretnina delete(Long id) {
		Nekretnina retval= nekretninaRepository.findOne(id);
		if(retval==null){
			throw new IllegalArgumentException("tried to delete nonexistant nekretnina");
		}
		nekretninaRepository.delete(id);
		return retval;
	}

}
