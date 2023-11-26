package be.PaulA.pojo;

import java.util.Random;

public class Set {
	protected Match match;
	protected Opponent winner;
	protected int scoreJ1;
	protected int scoreJ2;
	
	public Set(Match match) {
		this.match=match;
	}
	
	public void play() {
		while(scoreJ1<6&&scoreJ2<6) {
			getPointResult();
		}
		if(Math.abs(scoreJ1-scoreJ2)<2) {
			getPointResult();
			if (scoreJ1==scoreJ2) {
				getJeuDecisif();
			}
		}
		if(scoreJ1>scoreJ2) {
			match.getOpp1().getSets().add(this);
			winner=match.getOpp1();
		}else {
			match.getOpp2().getSets().add(this);
			winner=match.getOpp2();
		}
	}
	protected void getPointResult() {
		Random rnd = new Random();
		if(rnd.nextInt(2)==1) {
			scoreJ1++;
		}else {
			scoreJ2++;
		}
	}
	private void getJeuDecisif() {
		Random rnd = new Random();
		if(rnd.nextInt(2)==1) {
			scoreJ1++;
		}else {
			scoreJ2++;
		}
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
	@Override 
	public String toString() {
		return scoreJ1+"-"+scoreJ2;
	}
	
}
