package be.PaulA.pojo;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
	private String name;
	private Schedule[] schedules = new Schedule[5];
	private List<Court> courts = new ArrayList<Court>();
	private List<Referee> referees = new ArrayList<Referee>();
	
	public Tournament(String name) {
		this.name=name;
		schedules[0] = new Schedule(ScheduleType.GentlemenSingle,this);
		schedules[1] = new Schedule(ScheduleType.LadiesSingle,this);
		schedules[2] = new Schedule(ScheduleType.GentlemenDouble,this);
		schedules[3] = new Schedule(ScheduleType.LaidesDouble,this);
		schedules[4] = new Schedule(ScheduleType.MixedDouble,this);
		referees = Referee.getAllRefs();
		courts = Court.getAllCourt();
	}
	public void play() {
		for(Schedule s : schedules) {
			s.playNextRound();
		}
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
