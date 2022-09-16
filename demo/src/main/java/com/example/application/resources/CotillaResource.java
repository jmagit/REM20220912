package com.example.application.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.application.proxies.CatalogoProxy;
import com.example.domains.entities.dto.PeliculaCortaDTO;

@RestController
@RequestMapping("/api/v1/cotilla")
public class CotillaResource {
	@Autowired
	RestTemplate srvRest;
	
	@GetMapping("/template/pelis")
	List<PeliculaCortaDTO> getPelisRT() {
		ResponseEntity<List<PeliculaCortaDTO>> response = srvRest.exchange(
				"lb://CATALOGO-SERVICE/v1/peliculas?mode=short", 
//				"http://192.168.1.156:8010/v1/peliculas?mode=short", 
				HttpMethod.GET,
				HttpEntity.EMPTY, 
				new ParameterizedTypeReference<List<PeliculaCortaDTO>>() {
				});
		return response.getBody();
	}
	@GetMapping("/template/pelis/{id}")
	PeliculaCortaDTO getPelisRT(@PathVariable int id) {
		return srvRest.getForObject("lb://CATALOGO-SERVICE/v1/peliculas/{id}?mode=short", PeliculaCortaDTO.class, id);
//		return srvRest.getForObject("http://192.168.1.156:8010/v1/peliculas/{id}?mode=short", PeliculaCortaDTO.class, id);
	}
	@GetMapping("/template/raiz")
	String getPelisRaizRT() {
//		return srvRest.getForObject("http://192.168.1.156:8010/", String.class);
		return srvRest.getForObject("lb://CATALOGO-SERVICE/", String.class);
	}
	
	@Autowired
	CatalogoProxy proxy;
	
	@GetMapping("/proxy/pelis")
	List<PeliculaCortaDTO> getPelisProxy() {
		return proxy.getPelis();
	}
	@GetMapping("/proxy/pelis/{id}")
	PeliculaCortaDTO getPelisProxy(@PathVariable int id) {
		return proxy.getOnePeli(id);
	}
	@GetMapping("/proxy/raiz")
	String getPelisRaizProxy() {
		return proxy.getRaiz();
	}
}
