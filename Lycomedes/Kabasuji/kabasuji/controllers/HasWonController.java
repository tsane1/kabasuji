package kabasuji.controllers;

import java.awt.Color;

import javax.swing.ImageIcon;
//
import kabasuji.entities.LightningLevel;
import kabasuji.entities.PuzzleLevel;
import kabasuji.entities.ReleaseLevel;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;

/** 
 * 
 * @author Chase St. Laurent
 * 
 *
 */

public class HasWonController {
	SuperModel model;
	Application app;
	private Level level;
	private PuzzleLevel pl;
	private LightningLevel ll;
	private ReleaseLevel rl;
	
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
