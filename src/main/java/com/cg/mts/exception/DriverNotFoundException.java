package com.cg.mts.exception;

public class DriverNotFoundException extends RuntimeException {

	public DriverNotFoundException(String string) {
		super(string);
	}

	public DriverNotFoundException() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 914569459626622748L;

}
