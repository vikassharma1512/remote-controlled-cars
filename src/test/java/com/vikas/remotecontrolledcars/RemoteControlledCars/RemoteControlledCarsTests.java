package com.vikas.remotecontrolledcars.RemoteControlledCars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * @author Vikas
 */
public class RemoteControlledCarsTests {

	@Test(expected = InvalidInputFormat.class)
	public void invalid_input_format() {
		String input = "55RFLFRFLF";

		new RemoteControlledCars(input);

	}

	@Test(expected = InvalidInputFormat.class)
	public void invalid_start_position() {
		String input = "16,16:RFLFRFLF";

		new RemoteControlledCars(input);
	}

	@Test
	public void parses_start_position() {
		String input = "5,5:RFLFRFLF";

		RemoteControlledCars cars = new RemoteControlledCars(input);

		assertEquals(cars.getStartPosition().getVerticalAxis(), 5);
		assertEquals(cars.getStartPosition().getHorizontalAxis(), 5);
		assertEquals(cars.getStartPosition().getDirection(), Direction.NORTH);

	}

	@Test
	public void parses_end_position() {
		String input = "5,5:RFLFRFLF";

		RemoteControlledCars cars = new RemoteControlledCars(input);
		assertEquals(cars.getPositions().size(), 9);

		assertEquals(cars.getEndPosition().getVerticalAxis(), 7);
		assertEquals(cars.getEndPosition().getHorizontalAxis(), 7);
		assertEquals(cars.getEndPosition().getDirection(), Direction.NORTH);

	}

	@Test(expected = OutOfGridException.class)
	public void moves_out_of_bounds_north() {
		String input = "15,0:F";

		new RemoteControlledCars(input);
	}

	@Test(expected = OutOfGridException.class)
	public void moves_out_of_bounds_south() {
		String input = "0,0:RRF";

		new RemoteControlledCars(input);
	}

	@Test(expected = OutOfGridException.class)
	public void moves_out_of_bounds_east() {
		String input = "0,15:RF";

		new RemoteControlledCars(input);
	}

	@Test(expected = OutOfGridException.class)
	public void moves_out_of_bounds_west() {
		String input = "0,0:LF";

		new RemoteControlledCars(input);
	}

}
