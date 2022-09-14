package com.example.domains.core.entities.dtos;

import com.example.domains.entities.Actor;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ActorDto {
	@JsonProperty("id")
	private int actorId;
	@JsonProperty("nombre")
	private String firstName;
	@JsonProperty("apellidos")
	private String lastName;

	public static ActorDto from(Actor source) {
		return new ActorDto(
				source.getActorId(),
				source.getFirstName().toUpperCase(),
				source.getLastName()
				);
	}
	public static Actor from(ActorDto source) {
		var rslt = new Actor(source.getActorId());
		rslt.setFirstName(source.getFirstName());
		rslt.setLastName(source.getLastName());
		return rslt;
	}
}
