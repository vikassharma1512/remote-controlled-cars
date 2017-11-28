package com.vikas.remotecontrolledcars.RemoteControlledCars;

/**
 * @author Vikas
 *
 */
public class InvalidInputFormat extends RuntimeException {

	private static final long serialVersionUID = 4115001235624723921L;

	public InvalidInputFormat(String input, String expression) {
		super(input + " does not meet the regular expression: " + expression);
	}
}
