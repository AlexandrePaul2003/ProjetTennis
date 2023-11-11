package be.PaulA.pojo;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Match {
	private LocalDate date;
	private int duration;
	private int round;
	private Schedule schedule;
	private Court court=null;
	private List<Set> sets = new ArrayList<Set>();
	private Opponent opp1;
	private Opponent opp2;
	private Referee ref=null;
	
	public Match (int duration,int round,Schedule schedule) {
		date=LocalDate.now();
		this.duration=duration;
		this.round=round;
		this.schedule=schedule;
		System.out.println(this.schedule.getMatches().size());
		opp1=Opponent.getOpp(this.schedule.getMatches().size()+1,this);
		if(schedule.getType()==ScheduleType.GentlemenSingle||schedule.getType()==ScheduleType.LadiesSingle) {
			opp2=Opponent.getOpp(128-this.schedule.getMatches().size()-1,this);
		}else {
			opp2=Opponent.getOpp(64-this.schedule.getMatches().size()-1,this);
		}
		
		
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Court getCourt() {
		return court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}

	public List<Set> getSets() {
		return sets;
	}

	public void setSets(List<Set> sets) {
		this.sets = sets;
	}

	public Opponent getOpp1() {
		return opp1;
	}

	public void setOpp1(Opponent opp1) {
		this.opp1 = opp1;
	}

	public Opponent getOpp2() {
		return opp2;
	}

	public void setOpp2(Opponent opp2) {
		this.opp2 = opp2;
	}

	public Referee getRef() {
		return ref;
	}

	public void setRef(Referee ref) {
		this.ref = ref;
	} 
	
	public Opponent getWinner() {
		int sJ1=0,sJ2=0;
		for(Set s : sets) {
			if(s.getWinner()==opp1) {
				sJ1++;
			}else {
				sJ2++;
			}
		}
		return sJ1>sJ2 ? opp1 : opp2;
	}
	public void play() {
		while(opp1.getSets().size()!=schedule.nbWinningSet()||opp2.getSets().size()!=schedule.nbWinningSet()) {
			if((schedule.getType()==ScheduleType.GentlemenSingle&&sets.size()==5)||(schedule.getType()!=ScheduleType.GentlemenSingle&&sets.size()==3)) {
				sets.add(new TieBreak(this));
			}else {
				sets.add(new Set(this));
			}
		}
	}

}
