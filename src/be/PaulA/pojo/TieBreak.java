package be.PaulA.pojo;

import java.util.Random;

public class TieBreak extends Set{

	public TieBreak(Match match) {
		super(match);
	}
		@Override
		public void play() {
			while(scoreJ1<10&&scoreJ2<10) {
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
		
		private void getJeuDecisif() {
			getPointResult();
		
		}
	
	
}
