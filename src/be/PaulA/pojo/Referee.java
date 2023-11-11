package be.PaulA.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import be.PaulA.project.DAO.ProjectConnection;
import be.PaulA.project.DAO.RefereeDAO;

public class Referee extends Person implements Serializable {
	private static final long serialVersionUID = 3066075689177541330L;
	private Match currMatch;
	private List<Tournament> tournaments = new ArrayList<Tournament>();
	public Referee(String firstname, String lastname, String nationnality) {
		super(firstname,lastname,nationnality);
		
	}
	
	public Match getCurrMatch() {
		return currMatch;
	}

	public void setCurrMatch(Match currMatch) {
		this.currMatch = currMatch;
	}

	public List<Tournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}

	public boolean available() {
		return true;
	}
	public void release() {
		
	}
	
	public static List<Referee> getAllRefs(){
		RefereeDAO rDAO = new RefereeDAO(ProjectConnection.getInstance());
		return rDAO.find();
	}

}
