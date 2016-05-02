package kabasuji.controllers;

<<<<<<< HEAD
import java.awt.Color;

import javax.swing.ImageIcon;
//
=======
>>>>>>> refs/remotes/origin/master
import kabasuji.entities.LightningLevel;
import kabasuji.entities.PuzzleLevel;
import kabasuji.entities.ReleaseLevel;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;

/** 
 * Controller for determining if the level is won.
 * @author Chase St. Laurent
<<<<<<< HEAD
 * 
 *
=======
>>>>>>> refs/remotes/origin/master
 */

public class HasWonController {
<<<<<<< HEAD
	SuperModel model;
	Application app;
	private Level level;
	private PuzzleLevel pl;
	private LightningLevel ll;
=======
	/** model being updated. */
	SuperModel model;
	/** Application being run. */
	Application app;
	/** Level being played. */
	private Level level;
	/** puzzle level instance. */
	private PuzzleLevel pl;
	/** lightning level instance. */
	private LightningLevel ll;
	/** release level instance. */
>>>>>>> refs/remotes/origin/master
	private ReleaseLevel rl;
	
<<<<<<< HEAD
=======
	/**
	 * Controller for the has won controller.
	 * @param app
	 * @param model
	 */
>>>>>>> refs/remotes/origin/master
	public HasWonController(Application app, SuperModel m) {
		this.level = m.getActiveLevel();
		this.model = m;
		this.app = app;
		pl = null; 
		rl = null; 
		ll = null;
		switch(level.getLevelType()) {
		case "Puzzle":
			pl = (PuzzleLevel)level;
			break;
		case "Lightning":
			ll = (LightningLevel)level;
			break;
		case "Release":
			rl = (ReleaseLevel)level;
			break;
		default:
			System.err.println("This level type is not yet supported.");
			break;				
		}
	}
	
<<<<<<< HEAD
	
=======
	/**
	 * Handles whether or not the level is won.
	 * @return boolean
	 */
>>>>>>> refs/remotes/origin/master
	public boolean hasWon(){
		boolean hasWon = false;

		switch(level.getLevelType()) { // add level-specific elements
		case "Puzzle":
			if((level.progress.updateProgressPuzzle()>=50 && pl.getMovesLeft()==0)
					|| (level.progress.updateProgressPuzzle()==100)){
				hasWon=true;
			}
			break;
		case "Lightning":
			if((level.progress.updateProgressLightning()>=50 && ll.getMinsLeft()==0 && ll.getSecsLeft()==0)
					|| (level.progress.updateProgressLightning()==100)){
				hasWon=true;
			}
			break;
		case "Release":
			if((level.progress.updateProgressRelease()<=32)
					||(level.progress.updateProgressRelease()==100)){
				hasWon=true;
			}
			break;
		default:
			System.err.println("This level type is not yet supported."); 
			return hasWon;			
		}
		
		return hasWon;
	}
}
