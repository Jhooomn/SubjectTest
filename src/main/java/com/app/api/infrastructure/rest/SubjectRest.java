package com.app.api.infrastructure.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRest {

	private String id;
	private String name;
	private String code;
	private Integer credits;

}
