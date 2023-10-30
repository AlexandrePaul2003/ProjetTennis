package be.PaulA.pojo;

import java.io.Serializable;

public class Court implements Serializable{
	private static final long serialVersionUID = 3066075689176541330L;
	private Tournament touramenet;
	private Match currMatch;
	private int nbSpectator;
	private Boolean covered;
	
	public Court(){
		
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
	
	
	 
	
}
