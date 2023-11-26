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
	public Player(String firstname, String lastname, String nationnality,int rank,char gender) {
		super(firstname, lastname, nationnality);
		this.rank=rank;
		this.gender=gender;
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
	@Override
	public String toString() {
		return super.toString()+", "+nationnality + " rank :" + rank ;
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
