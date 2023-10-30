package be.PaulA.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

	public class Opponent implements Serializable {
		private static final long serialVersionUID = 3066075689176541330L;
		private List<Player> players;
		private List<Match> matches = new ArrayList<Match>();
		private List<Set> sets = new ArrayList<Set>();
		
		public Opponent (List<Player> players) {
			this.players=players;
		}

		public List<Player> getPlayer() {
			return players;
		}

		public void setPlayer(List<Player> player) {
			this.players = player;
		}

		public List<Match> getMatches() {
			return matches;
		}

		public void setMatches(List<Match> matches) {
			this.matches = matches;
		}

		public List<Set> getSets() {
			return sets;
		}

		public void setSets(List<Set> sets) {
			this.sets = sets;
		}
		
	}
	
	
