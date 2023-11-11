package be.PaulA.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import be.PaulA.project.DAO.OpponentDAO;
import be.PaulA.project.DAO.ProjectConnection;

	public class Opponent implements Serializable {
		private static final long serialVersionUID = 3066075689176541330L;
		private List<Player> players;
		private List<Match> matches = new ArrayList<Match>();
		private List<Set> sets = new ArrayList<Set>();
		private int rank;
		
		public Opponent (List<Player> players,int rank) {
			this.players=players;
			this.rank=rank;
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
		public static Opponent getOpp(int nMatch,Match m) {
			List<Player> pl = new ArrayList<Player>();
			if(m.getSchedule().getType()==ScheduleType.GentlemenSingle||m.getSchedule().getType()==ScheduleType.LadiesSingle) {
				Player p = Player.findPlayer(nMatch,m);
				pl.add(p);
				return new Opponent(pl,p.getRank());
			} else {
				if(m.getSchedule().getType()==ScheduleType.GentlemenDouble||m.getSchedule().getType()==ScheduleType.LaidesDouble||m.getSchedule().getType()==ScheduleType.MixedDouble) {
					OpponentDAO oDAO = new OpponentDAO(ProjectConnection.getInstance());
					return oDAO.find(nMatch,m);
				} else {
					JOptionPane.showMessageDialog(null, "Opponent not found");
				}
			}
			return null;
		}
		@Override
		public String toString() {
			String re="";
			for(Player p : players) {
				re += p.getLastname()+" " + p.getFirstname();
				if(players.size()>1) {
					re = re +" & ";
				}
			}
			return re;
		}
		
	}
	
	
