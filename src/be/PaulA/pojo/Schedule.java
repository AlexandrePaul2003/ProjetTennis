package be.PaulA.pojo;

public class Schedule {
	private ScheduleType type;
	private int actualRound;
	Queue<Match> matches = new Queue<Match>();
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
		
	}
	public void playNextRound() {
		
	}
	public Player getWinner(){
		
	}
	
	
}
