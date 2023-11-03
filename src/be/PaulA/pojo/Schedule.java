package be.PaulA.pojo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Schedule {
	private ScheduleType type;
	private int actualRound;
	List<Match> matches = new ArrayList<Match>();
	private Tournament tournamenet;
	
	public Schedule(ScheduleType type,Tournament tournamenet) {
		this.type=type;
		this.tournamenet=tournamenet;
		if(type==ScheduleType.GentlemenSingle||type==ScheduleType.LadiesSingle) {
			for(int i =0;i<64;i++) {
				matches.add(new Match(180,1,this));
			}
		} else {
			for(int i =0;i<32;i++) {
				matches.add(new Match(180,1,this));
			}
		}
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
	public List<Match> getMatches() {
		return matches;
	}
	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
	public Tournament getTouramenet() {
		return tournamenet;
	}
	public void setTouramenet(Tournament touramenet) {
		this.tournamenet = touramenet;
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
