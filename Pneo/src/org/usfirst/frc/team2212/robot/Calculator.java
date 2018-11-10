package org.usfirst.frc.team2212.robot;
import java.util.ArrayList;

public class Calculator {
	public static final int MAX_TURNS = 20;
	private int buttonNum;
	private ArrayList<Integer> colorOrder;
	private int placeInTurn;
	private boolean printing;

	public Calculator(int buttonNum) {
		this.buttonNum = buttonNum;
		colorOrder = new ArrayList<>();
		chooseNextColor();
		placeInTurn = 0;
		printing = true;
	}
	
	public int getScore() {
		return colorOrder.size();
	}

	public int getNextColor() {
		if (colorOrder.size() == placeInTurn) {
			placeInTurn = 0;
			printing = false;
			return -1;
		}
		placeInTurn++;
		return colorOrder.get(placeInTurn - 1);
	}

	public int checkNextColor(int color) {
		int returnValue = 0;
		if (colorOrder.get(placeInTurn) == color) {
			placeInTurn++;
			returnValue = 1;
		}
		if (colorOrder.size() == placeInTurn) {
			if(colorOrder.size() == MAX_TURNS) {
				returnValue = 2;
			}
			placeInTurn = 0;
			printing = true;
			chooseNextColor();
			returnValue = -1;
		}
		if(returnValue == 0) {
		}
		return returnValue;
	}

	public void chooseNextColor() {
		colorOrder.add((int) (Math.random() * buttonNum));
	}
	
	public boolean isPrinting() {
		return printing;
	}

	public void resetGame() {
		colorOrder.clear();
		printing = true;
		chooseNextColor();
	}

}
