package com.app.api.shared.domain;

import com.app.api.exceptions.CreditExceptions;

import lombok.Getter;

public class Credits {

	@Getter
	private final Integer credits;

	public Credits(Integer value) {
		try {
			this.credits = value;
			if (value < 0 || value > 4) {
				throw new CreditExceptions();
			}
		} catch (NullPointerException e) {
			throw new CreditExceptions();
		}
	}

}
