package be.PaulA.pojo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Schedule {
	private ScheduleType type;
	private int actualRound=0;
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
		if(type==ScheduleType.GentlemenSingle) {
			return 3;
		}else {
			return 2;
		}
	}
	public void playNextRound() {
		actualRound++;
		Opponent temp=null;
		Boolean noCourts=false;
		Boolean noRef=false;
		for(Match m : matches) {
			if(m.getRound()==actualRound) {
				if(m.getCourt()!=null&&m.getRef()!=null) {
					m.play();
					if(temp==null) {
						temp=m.getWinner();
					}else {
						matches.add(new Match(180,actualRound+1,this));
						temp=null;
					}
					m.getRef().release();
					m.getCourt().release();
				}else {
					if(m.getCourt()==null&&noCourts==false) {
							Court c = getCourtAva();
							if(c!=null) {
								m.setCourt(c);
							}else {
								noCourts=true;
							}	
					}
					if(m.getRef()==null&&noRef==false) {
						Referee r = getRefAva();
						if(r!=null) {
							m.setRef(r);
						}else {
							noRef=true;
						}	
					}
				}
			}
		}
	}
	public Player getWinner(){
		return null;
	}
	private Referee getRefAva() {
		for(Referee r : tournamenet.getReferees()) {
			if(r.available()) {
				return r;
			}
		}
		return null;
	}
	private Court getCourtAva() {
		for(Court c : tournamenet.getCourts()) {
			if(c.available()) {
				return c;
			}
		}
		return null;
	}
	
	
}
