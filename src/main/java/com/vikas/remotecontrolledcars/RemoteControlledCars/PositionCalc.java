/**
 * 
 */
package com.vikas.remotecontrolledcars.RemoteControlledCars;

/**
 * Position by vertical, horizontal and direction
 * 
 * @author Vikas
 *
 */
public class PositionCalc {

	private int vertical = -1;
	private int horizontal = -1;
	private Direction direction = Direction.NORTH;

	public PositionCalc(int vertical, int horizontal) {
		this.vertical = vertical;
		this.horizontal = horizontal;
	}

	public PositionCalc(PositionCalc position) {
		this.vertical = position.getVerticalAxis();
		this.horizontal = position.getHorizontalAxis();
		this.direction = position.getDirection();
	}

	public int getVerticalAxis() {
		return vertical;
	}

	public int getHorizontalAxis() {
		return horizontal;
	}

	public Direction getDirection() {
		return direction;
	}

	void forward() {
		if (direction == Direction.NORTH) {
			vertical++;
		} else if (direction == Direction.SOUTH) {
			vertical--;
		} else if (direction == Direction.EAST) {
			horizontal++;
		} else { // Direction.WEST
			horizontal--;
		}
	}

	/**
	 * Rotates the direction by 90 degrees anti-clockwise.
	 */
	void left() {
		direction = Direction.values()[direction.ordinal() == 0 ? 3 : direction.ordinal() - 1];
	}

	/**
	 * Rotates the direction by 90 degrees clockwise.
	 */
	void right() {
		direction = Direction.values()[direction.ordinal() == 3 ? 0 : direction.ordinal() + 1];
	}
}
