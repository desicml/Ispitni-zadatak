package jwd.wafepa.web.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import jwd.wafepa.model.TipNekretnine;
import jwd.wafepa.service.TipNekretnineService;
import jwd.wafepa.support.TipNekretnineToTipNekretnineDto;
import jwd.wafepa.web.dto.TipNekretnineDto;

@RestController
@RequestMapping(value="/api/tipnekretnine")
public class ApiTipNekretnineController {
	
	@Autowired
	TipNekretnineService tipNekretnineService;
	@Autowired
	TipNekretnineToTipNekretnineDto toDto;

	@RequestMapping(method= RequestMethod.GET)
	ResponseEntity<List<TipNekretnineDto>>getAll(@RequestParam(defaultValue="0") int page){
		
		Page<TipNekretnine>retval=tipNekretnineService.findAll(page);
		List<TipNekretnine>tipovi=retval.getContent();
		
		return new ResponseEntity<>(toDto.convert(tipovi),HttpStatus.OK);
		
	}
}
