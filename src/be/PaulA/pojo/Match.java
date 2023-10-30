package be.PaulA.pojo;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Match {
	private LocalDate date;
	private Duration duration;
	private int round;
	private Schedule schedule;
	private Court court;
	private List<Set> sets = new ArrayList<Set>();
	private Opponent opp1;
	private Opponent opp2;
	private Referee ref;
	
	public Match () {
		
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
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
	
	public Player getWinner() {
		return null;
	}
	public void play() {
		
	}

}
