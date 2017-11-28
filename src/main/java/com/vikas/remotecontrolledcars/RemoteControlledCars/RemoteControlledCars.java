package com.vikas.remotecontrolledcars.RemoteControlledCars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoteControlledCars {

	private static final int GRID_MAX_BOUNDARY = 15;

	private static final String VALID_GRID_EXPRESSION = "([0-9]|1[0-5]),([0-9]|1[0-5]):([FLR]+)";

	private List<PositionCalc> positions = new ArrayList<PositionCalc>();

	public RemoteControlledCars(String input) {
		parsePosition(input);
		checkGridBoundary();
	}

	private void checkGridBoundary() {
		PositionCalc endPosition = getEndPosition();

		if (endPosition.getVerticalAxis() > GRID_MAX_BOUNDARY || endPosition.getVerticalAxis() < 0) {
			throw new OutOfGridException(endPosition);
		}

		if (endPosition.getHorizontalAxis() > GRID_MAX_BOUNDARY || endPosition.getHorizontalAxis() < 0) {
			throw new OutOfGridException(endPosition);
		}

	}

	private void parsePosition(String input) {
		Matcher matcher = Pattern.compile(VALID_GRID_EXPRESSION).matcher(input);

		if (!matcher.matches()) {
			throw new InvalidInputFormat(input, VALID_GRID_EXPRESSION);
		}

		int vertical = Integer.parseInt(matcher.group(1));

		int horizontal = Integer.parseInt(matcher.group(2));

		PositionCalc startPosition = new PositionCalc(vertical, horizontal);

		positions.add(startPosition);

		PositionCalc currentPosition = new PositionCalc(startPosition);
		String moves = matcher.group(3);

		for (int i = 0; i < moves.length(); i++) {

			currentPosition = new PositionCalc(currentPosition);

			char move = moves.charAt(i);

			if ('L' == move) {
				currentPosition.left();
			} else if ('R' == move) {
				currentPosition.right();
			} else {
				currentPosition.forward();
			}

			positions.add(currentPosition);
		}
	}

	public List<PositionCalc> getPositions() {
		return positions;
	}

	public PositionCalc getStartPosition() {
		return positions.get(0);
	}

	public PositionCalc getEndPosition() {
		return positions.get(positions.size() - 1);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your grid coordinate ::");

		String coordinate = sc.next();

		sc.close();

		if (coordinate == null || coordinate.isEmpty()) {
			System.out.println("Input must match the following regular expression: " + VALID_GRID_EXPRESSION);
			return;
		}
		RemoteControlledCars cars = new RemoteControlledCars(coordinate);

		System.out.println("REMOTE CAR START POSITION  : " + cars.getStartPosition().getVerticalAxis() + ","
				+ cars.getStartPosition().getHorizontalAxis());
		System.out.println("REMOTE CAR END POSITION : " + cars.getEndPosition().getVerticalAxis() + ","
				+ cars.getEndPosition().getHorizontalAxis());

	}
}
