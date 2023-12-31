package be.PaulA.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import be.PaulA.project.DAO.ProjectConnection;
import be.PaulA.project.DAO.RefereeDAO;

public class Referee extends Person implements Serializable {
	private static final long serialVersionUID = 3066075689177541330L;
	private Match currMatch;
	public Referee(String firstname, String lastname, String nationnality) {
		super(firstname,lastname,nationnality);
		
	}
	
	public Match getCurrMatch() {
		return currMatch;
	}

	public void setCurrMatch(Match currMatch) {
		this.currMatch = currMatch;
	}

	

	public boolean available() {
		return currMatch == null ? true : false;
	}
	public void release() {
		currMatch=null;
	}
	
	public static List<Referee> getAllRefs(){
		RefereeDAO rDAO = new RefereeDAO(ProjectConnection.getInstance());
		return rDAO.find();
	}
	@Override
	public String toString() {
		return super.toString();
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
