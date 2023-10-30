package be.PaulA.pojo;

import java.io.Serializable;

public class Court implements Serializable{
	private static final long serialVersionUID = 3066075689178541330L;
	private Tournament touramenet;
	private Match currMatch;
	private int nbSpectator;
	private Boolean covered;
	
	public Court(int nbSpectator,int covered){
		this.nbSpectator=nbSpectator;
		switch(covered) {
		case 0:
			this.covered=false;
			break;
		case 1:
			this.covered=true;
			break;
		case 2:
			this.covered=false;
			System.out.println("Erreur covered non reconnu");
			break;
		}
	}

	public Tournament getTouramenet() {
		return touramenet;
	}

	public void setTouramenet(Tournament touramenet) {
		this.touramenet = touramenet;
	}

	public Match getCurrMatch() {
		return currMatch;
	}

	public void setCurrMatch(Match currMatch) {
		this.currMatch = currMatch;
	}

	public int getNbSpectator() {
		return nbSpectator;
	}

	public void setNbSpectator(int nbSpectator) {
		this.nbSpectator = nbSpectator;
	}

	public Boolean getCovered() {
		return covered;
	}

	public void setCovered(Boolean covered) {
		this.covered = covered;
	}
	
	public boolean available() {
		return true;
	}
	public void release() {
		
	}
	 
	
}
