package be.PaulA.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import be.PaulA.project.DAO.PlayerDAO;
import be.PaulA.project.DAO.ProjectConnection;

public class Player extends Person implements Serializable {
	private static final long serialVersionUID = 3066075689176541330L;
	private int rank;
	private char gender;
	private List<Opponent> opponents = new ArrayList<Opponent>();
	public Player(String firstname, String lastname, String nationnality,int rank,char gender) {
		super(firstname, lastname, nationnality);
		this.rank=rank;
		this.gender=gender;
		// TODO Auto-generated constructor stub
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public List<Opponent> getOpponents() {
		return opponents;
	}
	public void setOpponents(List<Opponent> opponents) {
		this.opponents = opponents;
	}
	public static Player findPlayer(int nMatch,Match m) {
		Player p;
		PlayerDAO pDAO = new PlayerDAO(ProjectConnection.getInstance());
		if(m.getSchedule().getType()==ScheduleType.GentlemenSingle) {
			p=pDAO.find(nMatch,'M');
		} else {
			if(m.getSchedule().getType()==ScheduleType.LadiesSingle) {
				p=pDAO.find(nMatch,'F');
			} else {
				p=null;
			}
		}
		return p;
	}
	

	
}
