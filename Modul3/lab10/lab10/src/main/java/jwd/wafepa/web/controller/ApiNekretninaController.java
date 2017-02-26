package jwd.wafepa.web.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.wafepa.model.Nekretnina;
import jwd.wafepa.service.NekretnineService;
import jwd.wafepa.support.NekretninaDtoToNekretnina;
import jwd.wafepa.support.NekretninaToNekretninaDto;
import jwd.wafepa.web.dto.NekretninaDto;

@RestController
@RequestMapping(value="/api/nekretnine")
public class ApiNekretninaController {
	
	@Autowired 
	NekretnineService nekretninaService;
	@Autowired
	NekretninaToNekretninaDto toDto;
	@Autowired
	NekretninaDtoToNekretnina toNekretnina;
	
	@RequestMapping(method= RequestMethod.GET, value= "/{id}")
	ResponseEntity<NekretninaDto>getNekretnina(@PathVariable Long id){
		Nekretnina nekretnina= nekretninaService.findOne(id);
		if(nekretnina==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(toDto.convert(nekretnina), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<NekretninaDto>>getAll(@RequestParam(defaultValue="0") int page){
		
		Page<Nekretnina>retval= nekretninaService.findAll(page);
		
		if(page>retval.getTotalPages()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<Nekretnina>nekretnine= retval.getContent();
		
		return new ResponseEntity<>(toDto.convert(nekretnine), HttpStatus.OK);
	}
	
	@RequestMapping(method= RequestMethod.POST, consumes="application/json")
	ResponseEntity<NekretninaDto>add(@RequestBody NekretninaDto nekretnina){
		
		Nekretnina saved= nekretninaService.save(toNekretnina.convert(nekretnina));
		
		return new ResponseEntity<>(toDto.convert(saved), HttpStatus.CREATED);
	}
	@RequestMapping(method= RequestMethod.PUT, consumes="application/json", value="/{id}")
	ResponseEntity<NekretninaDto>edit(@RequestBody NekretninaDto nekretnina, @PathVariable Long id){
		
		if(id!= nekretnina.getId()){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Nekretnina edited=nekretninaService.save(toNekretnina.convert(nekretnina));
		
		return new ResponseEntity<>(toDto.convert(edited),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	ResponseEntity<NekretninaDto>delete(@PathVariable Long id){
		
		nekretninaService.delete(id);
		return new ResponseEntity<>( HttpStatus.NO_CONTENT);
	}


}
