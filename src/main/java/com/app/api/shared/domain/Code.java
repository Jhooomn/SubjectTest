package com.app.api.shared.domain;

import com.app.api.exceptions.CodeException;

import lombok.Getter;

public class Code {

	@Getter
	private final String code;

	public Code(String value) {
		try {
			this.code = value;
			if (value.length() < 5 || value.length() > 10) {
				throw new CodeException();
			}

		} catch (NullPointerException e) {
			throw new CodeException();
		}
	}

}
