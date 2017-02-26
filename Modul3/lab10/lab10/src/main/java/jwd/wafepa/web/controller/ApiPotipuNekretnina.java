package jwd.wafepa.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jwd.wafepa.service.NekretnineService;
import jwd.wafepa.service.TipNekretnineService;
import jwd.wafepa.web.dto.NekretninaDto;

@RestController
@RequestMapping(value="/api/tipnekretnine/{nekretninaId}/nekretnine")
public class ApiPotipuNekretnina {

	@Autowired
	NekretnineService nekretnineService;
	@Autowired
	TipNekretnineService tipService;
	
//	ResponseEntity<List<NekretnineDto>>get(@PathVariable Long nekretninaId){
//		
//		List<Nekretnina>nekretnine=nekretnineService.f
//	}
}
