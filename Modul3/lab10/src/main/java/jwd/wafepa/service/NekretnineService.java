package jwd.wafepa.service;

import org.springframework.data.domain.Page;

import jwd.wafepa.model.Nekretnina;

public interface NekretnineService {

	Nekretnina findOne(Long id);
	Page<Nekretnina>findAll(int page);
	Nekretnina save (Nekretnina nekretnina);
	Nekretnina delete(Long id);

}
