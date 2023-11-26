package be.PaulA.pojo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Schedule {
	private ScheduleType type;
	private int actualRound=1;
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
		
		Opponent temp=null;
		Boolean noCourts=false;
		Boolean noRef=false;
		Boolean hasPlayedAllMatches =false;
		int debug=0;
		System.out.println(actualRound);
		while(!hasPlayedAllMatches) {
			try {
			hasPlayedAllMatches = true;
			noRef=false;
			noCourts=false;
			for(Match m : matches) {
				//System.out.println("match playing");
				if(m.getRound()==actualRound&&m.getWinner()==null) {
					//System.out.println("actually playing");
					debug++;
					//System.out.println(debug);
					if(m.getCourt()!=null&&m.getRef()!=null) {
						//System.out.println("etered playing condition");
						m.play();
						if(temp==null) {
							temp=m.getWinner();
						}else {
							matches.add(new Match(180,actualRound+1,this,temp,m.getWinner()));
							temp=null;
						}
						m.getRef().release();
						m.getCourt().release();
					}else {
						if(m.getCourt()==null&&noCourts==false) {
								Court c = getCourtAva();
								if(c!=null) {
									m.setCourt(c);
									c.setCurrMatch(m);
								}else {
									noCourts=true;
								}	
						}
						if(m.getRef()==null&&noRef==false) {
							Referee r = getRefAva();
							if(r!=null) {
								m.setRef(r);
								r.setCurrMatch(m);
							}else {
								noRef=true;
							}	
						}
					}
					hasPlayedAllMatches=false;
				}else {
					if(m.getRound()<actualRound+1) {
						//System.out.println("round match removed"+m.getRound());
						//matches.remove(m);
					}
				}
			}
		
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		}
		actualRound++;
	}
	public Opponent getWinner() {
		/*System.out.println("Entrée dans getWinner");
		System.out.println("nbr matches "+matches.size());
		if(matches.size()==1) {
			System.out.println("Entrée dans cond de getWinner");
			for(Match m : matches) {
				return m.getWinner();
			}
		}else {
			return null;
		}
		return null;*/
		if(((type==ScheduleType.LadiesSingle||type==ScheduleType.GentlemenSingle)&&actualRound==8)||(actualRound==7&&(type==ScheduleType.GentlemenDouble||type==ScheduleType.LaidesDouble||type==ScheduleType.MixedDouble))) {
			Match[] strings = matches.toArray(Match[]::new);
			System.out.println("winner"+strings[strings.length-1].getWinner());
			return strings[strings.length-1].getWinner();
			/*Opponent o=null;
			for(Match m : matches) {
				o=m.getWinner();
			}
			System.out.println("winner "+o.toString());
			return o;*/
		}else {
			return null;
		}
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
