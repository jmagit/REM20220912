package com.example.domains.core.entities.dtos;

import com.example.domains.entities.Actor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ActorDto {
	private int actorId;
	private String firstName;
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
