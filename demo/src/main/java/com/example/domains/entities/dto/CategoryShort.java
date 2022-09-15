package com.example.domains.entities.dto;

import org.springframework.data.rest.core.config.Projection;

import com.example.domains.entities.Category;

@Projection(name = "categoriaAcortado", types = { Category.class }) 
public interface CategoryShort {
	int getCategoryId();
	String getName();
}
