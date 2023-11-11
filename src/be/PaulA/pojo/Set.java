package be.PaulA.pojo;

public class Set {
	private Match match;
	private Opponent winner;
	private int scoreJ1;
	private int scoreJ2;
	
	public Set(Match match) {
		this.match=match;
	}
	
	public void play() {
		
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Opponent getWinner() {
		return winner;
	}

	public void setWinner(Opponent winner) {
		this.winner = winner;
	}

	public int getScoreJ1() {
		return scoreJ1;
	}

	public void setScoreJ1(int scoreJ1) {
		this.scoreJ1 = scoreJ1;
	}

	public int getScoreJ2() {
		return scoreJ2;
	}

	public void setScoreJ2(int scoreJ2) {
		this.scoreJ2 = scoreJ2;
	}
	
}
