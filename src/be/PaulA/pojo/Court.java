package be.PaulA.pojo;

import java.io.Serializable;
import java.util.List;

import be.PaulA.project.DAO.CourtDAO;
import be.PaulA.project.DAO.ProjectConnection;

public class Court implements Serializable{
	private static final long serialVersionUID = 3066075689178541330L;
	private Tournament touramenet;
	private Match currMatch;
	private int nbSpectator;
	private Boolean covered;
	
	public Court(int nbSpectator,Boolean covered){
		this.nbSpectator=nbSpectator;
		this.covered=covered;
		
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
		return currMatch == null ? true : false;
	}
	public void release() {
		currMatch=null;
	}
	public static List<Court> getAllCourt() {
		CourtDAO cDAO = new CourtDAO(ProjectConnection.getInstance());
		return cDAO.find();
	}
	@Override
	public String toString() {
		return "Court : " + covered.toString()+ " nb spectateur " + nbSpectator +" ";
	}
	@Override 
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object o) {
		return this.toString().hashCode()==o.toString().hashCode() ? true : false;
	}
	 
	
}
