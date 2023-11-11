package be.PaulA.pojo;

import java.util.Random;

public class TieBreak extends Set{

	public TieBreak(Match match) {
		super(match);
	}
		@Override
		public void play() {
			while(scoreJ1<6||scoreJ2<6) {
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
			}else {
				match.getOpp2().getSets().add(this);
			}
		}
		
		private void getJeuDecisif() {
			int sscoreJ1=0,sscoreJ2=0;
			Random rnd = new Random();
			while(Math.abs(sscoreJ1-sscoreJ2)<2) {
				if(rnd.nextInt(2)==1) {
					scoreJ1++;
				}else {
					scoreJ2++;
				}
			}
		
		}
	
	
}
