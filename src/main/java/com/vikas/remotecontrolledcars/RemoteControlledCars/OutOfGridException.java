package com.vikas.remotecontrolledcars.RemoteControlledCars;

/**
 * Exception thorwn when car goes out of grid boundary (15*15)
 *
 * @author Vikas
 *
 */
public class OutOfGridException extends RuntimeException {

	private static final long serialVersionUID = -1898030175111034912L;

	private PositionCalc position;

	public OutOfGridException(PositionCalc position) {
		super("Car out of grid boundary at position " + position.getHorizontalAxis() + "::"
				+ position.getVerticalAxis());
		this.position = position;
	}

	public PositionCalc getPosition() {
		return position;
	}
}