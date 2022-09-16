package com.example.application.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.domains.entities.dto.PeliculaCortaDTO;

@FeignClient(name = "CATALOGO-SERVICE") 
public interface CatalogoProxy {

	@GetMapping(path = "/v1/peliculas?mode=short")
	List<PeliculaCortaDTO> getPelis();
	@GetMapping(path = "/v1/peliculas/{id}?mode=short")
	PeliculaCortaDTO getOnePeli(@PathVariable int id);
	@GetMapping(path = "/")
	String getRaiz();
}
