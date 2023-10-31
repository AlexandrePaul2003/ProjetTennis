package be.PaulA.pojo;

import be.PaulA.project.DAO.ProjectConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import be.PaulA.project.DAO.*;

public class Main {

	public static void main(String[] args) {
		PlayerDAO pDAO = new PlayerDAO(ProjectConnection.getInstance());
<<<<<<< HEAD
		System.out.println(pDAO.find(1));
		/*
=======
		RefereeDAO rDAO = new RefereeDAO(ProjectConnection.getInstance());
		CourtDAO cDAO = new CourtDAO(ProjectConnection.getInstance());
		OpponentDAO oDAO = new OpponentDAO(ProjectConnection.getInstance());
		
>>>>>>> feature/add_data_to_database
		String[] noms = {"Paul", "Pignes", "Poirreaux","Foret","Cappelen","Djokovic","Nadal","Federer","Messi","Ronaldo","Ibra","Neymar","Rony","Dayot"};		
		String[] prenoms = {"Alexandre", "Paul", "Hercule","Isabelle","Christiane","Novak","Rafa","Roger","Leo","Christiano","ZLATAN","Jean","GOAT","Upamecado"};
		String[] nat = {"Belge", "Francais", "Néérlandais","Allemand","Espagnol","Portugais","Italien","Ruskov","Argentin","Brésilien","Suédois","JeanBonBeurre","Américain","Canadien"};
		List<Player> p = new ArrayList<Player>();
<<<<<<< HEAD
		Random rnd = new Random();
		for(int i = 0;i<128;i++) {
			p.add(new Player(noms[rnd.nextInt(12)],prenoms[rnd.nextInt(12)],nat[rnd.nextInt(12)],i,"M"));
		}
		for(Player player : p) {
			System.out.println(player.getFirstname()+" " + player.getLastname()+" "+player.getNationnality()+" "+player.getRank());
		}*/
		pDAO.create(new Player("Paul","Alexandre","Belge",1,"M"));
=======
		
		Random rnd = new Random();
		for(int i = 0;i<128;i++) {
			p.add(new Player(noms[rnd.nextInt(12)],prenoms[rnd.nextInt(12)],nat[rnd.nextInt(12)],i,'M'));
		}
		for(int i = 0;i<128;i++) {
			p.add(new Player(noms[rnd.nextInt(12)],prenoms[rnd.nextInt(12)],nat[rnd.nextInt(12)],i,'F'));
		}
		Player[] players = p.stream().toArray(Player[]::new);
		for(Player player : p) {
			pDAO.create(player);
		}
		
		List<Referee> r = new ArrayList<Referee>();
		for(int i=0;i<16;i++) {
			r.add(new Referee(noms[rnd.nextInt(12)],"Referee"+i,"Belge"));
		}
		for(Referee ref : r) {
			rDAO.create(ref);
		}
		/*List<Court> c = new ArrayList<Court>();
		for(int i=0;i<8;i++) {
			c.add(new Court(i*100,false));
		}
		for(int i=0;i<8;i++) {
			c.add(new Court(i*100,true));
		}
		for(Court court : c) {
			cDAO.create(court);
		}*/
		List<Opponent> ops = new ArrayList<Opponent>();
		int j=127;
		for(int i=0;i<64;i++) {
			List<Player> pl = new ArrayList<Player>();
			pl.add(players[i]);
			pl.add(players[j]);
			ops.add(new Opponent(pl));
			j--;
			
		}
		j=255;
		for(int i=128;i<192;i++) {
			List<Player> pl = new ArrayList<Player>();
			pl.add(players[i]);
			pl.add(players[j]);
			ops.add(new Opponent(pl));
			j--;
		}
		j=255;
		for(int i=0;i<64;i++) {
			List<Player> pl = new ArrayList<Player>();
			pl.add(players[i]);
			pl.add(players[j]);
			ops.add(new Opponent(pl));
			j--;
		}
		for(Opponent o : ops) {
			oDAO.create(o);
		}
>>>>>>> feature/add_data_to_database
		
 	}

}
