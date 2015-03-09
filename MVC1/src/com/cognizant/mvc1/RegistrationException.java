package com.cognizant.mvc1;

public class RegistrationException extends Exception {

	private static final long serialVersionUID = 1L;

	public RegistrationException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	public RegistrationException(String arg0) {
		super(arg0);

	}

	public RegistrationException(Throwable arg0) {
		super(arg0);

	}

}
