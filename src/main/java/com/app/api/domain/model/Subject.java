package com.app.api.domain.model;

import com.app.api.shared.domain.Code;
import com.app.api.shared.domain.Credits;
import com.app.api.shared.domain.Id;
import com.app.api.shared.domain.Name;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Subject {
	private final Id id;
	private final Name name;
	private final Code code;
	private final Credits credits;

	public static Subject of(Id id, Name name, Code code, Credits credits) {
		return new Subject(id, name, code, credits);
	}

}
