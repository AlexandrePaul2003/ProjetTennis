package be.PaulA.pojo;

import java.util.LinkedList;
import java.util.Queue;

public class Schedule {
	private ScheduleType type;
	private int actualRound;
	Queue<Match> matches = new LinkedList<Match>();
	private Tournament touramenet;
	
	public Schedule() {
		
	}
	
	
	
	public ScheduleType getType() {
		return type;
	}
	public void setType(ScheduleType type) {
		this.type = type;
	}
	public int getActualRound() {
		return actualRound;
	}
	public void setActualRound(int actualRound) {
		this.actualRound = actualRound;
	}
	public Queue<Match> getMatches() {
		return matches;
	}
	public void setMatches(Queue<Match> matches) {
		this.matches = matches;
	}
	public Tournament getTouramenet() {
		return touramenet;
	}
	public void setTouramenet(Tournament touramenet) {
		this.touramenet = touramenet;
	}
	
	
	public int nbWinningSet() {
		return 0;
	}
	public void playNextRound() {
		
	}
	public Player getWinner(){
		return null;
	}
	
	
}
