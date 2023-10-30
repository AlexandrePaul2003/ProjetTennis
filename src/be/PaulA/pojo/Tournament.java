package be.PaulA.pojo;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
	private String name;
	private Schedule[] schedules = new Schedule[5];
	private List<Court> courts = new ArrayList<Courts>();
	private List<Referee> referees = new ArrayList<Referee>();
	
	public Tournament() {
		
	}
	public void Play() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Schedule[] getSchedules() {
		return schedules;
	}
	public void setSchedules(Schedule[] schedules) {
		this.schedules = schedules;
	}
	public List<Court> getCourts() {
		return courts;
	}
	public void setCourts(List<Court> courts) {
		this.courts = courts;
	}
	public List<Referee> getReferees() {
		return referees;
	}
	public void setReferees(List<Referee> referees) {
		this.referees = referees;
	} 
	
	
}
