package com.evandropolo.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evandropolo.cursomc.domain.Categoria;
import com.evandropolo.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
		
	@Autowired
	private CategoriaService services;
	
	@RequestMapping	(value="/{id}", method=RequestMethod.GET)
		public ResponseEntity<?> find(@PathVariable Integer id){
		Categoria obj = services.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
