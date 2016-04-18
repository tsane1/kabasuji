package kabasuji.controllers;

public abstract class Move {

	/*
	 * Temp methods we can change/use later
	 */
	public abstract boolean execute();
	
	public abstract boolean undo();
	
	public abstract boolean valid();
}
