package be.PaulA.pojo;

import be.PaulA.project.DAO.ProjectConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import be.PaulA.project.DAO.*;

public class Main {

	public static void main(String[] args) {
		PlayerDAO pDAO = new PlayerDAO(ProjectConnection.getInstance());
		
		//System.out.println(pDAO.find(1));

		RefereeDAO rDAO = new RefereeDAO(ProjectConnection.getInstance());
		CourtDAO cDAO = new CourtDAO(ProjectConnection.getInstance());
		OpponentDAO oDAO = new OpponentDAO(ProjectConnection.getInstance());
		
		String[] noms = {
	            "Pele", "Maradona", "Zidane", "Beckenbauer", "Cruyff", "Ronaldo", "Messi", "Di Stefano", "Platini", "Baresi", 
	            "Puskas", "Eusebio", "Garrincha", "Bergkamp", "Yashin", "Moore", "Best", "Maldini", "Charlton", "Zico", 
	            "Rush", "Cantona", "Bobby", "Zola", "Pirlo", "Kahn", "Cannavaro", "Iniesta", "Bergomi", "Matthaus", 
	            "Rivaldo", "Stoichkov", "Butragueno", "Cruiff", "Banks", "Roberto", "Gullit", "Raul", "Van Basten", "Xavi", 
	            "Nesta", "Desailly", "Klose", "Ballack", "Hierro", "Gascoigne", "Buffon", "Vidic", "Cafu", "Giggs"
	            
	        };		
		String[] prenomsF = {"Marta", "Alex", "Ada", "Sam", "Wendie", "Megan", "Carli", "Lucy", "Saki", "Dzsenifer", "Vivianne", "Pernille", "Tobin", "Rose", "Eugenie", "Amandine", "Lieke", "Vero", "Sara", "Christine", "Samantha", "Steph", "Guro", "Elin", "Barbara", "Nilla", "Danielle", "Giovanna", "Nikita", "Kosovare"};
		String[] prenomsM = {"Lionel", "Cristiano", "Neymar", "Kylian", "Mohamed", "Kevin", "Sergio", "Robert", "Eden", "Gareth", "Luis", "Sadio", "Antoine", "Paul", "Harry", "Raheem", "Marco", "Thiago", "Virgil", "Jan", "Toni", "Karim", "Thomas", "Romelu", "Trent", "Joshua", "Angel", "Jadon", "Marcos", "Mohammed"};
		String[] nat = {"Belge", "Francais", "Néérlandais","Allemand","Espagnol","Portugais","Italien","Ruskov","Argentin","Brésilien","Suédois","JeanBonBeurre","Américain","Canadien"};
		List<Player> p = new ArrayList<Player>();
		
		Random rnd = new Random();
		for(int i = 0;i<128;i++) {
			p.add(new Player(noms[rnd.nextInt(noms.length)],prenomsM[rnd.nextInt(prenomsM.length)],nat[rnd.nextInt(12)],i+1,'M'));
		}
		for(int i = 0;i<128;i++) {
			p.add(new Player(noms[rnd.nextInt(noms.length)],prenomsF[rnd.nextInt(prenomsF.length)],nat[rnd.nextInt(12)],i+1,'F'));
		}
		Player[] players = p.stream().toArray(Player[]::new);
		for(Player player : p) {
			pDAO.create(player);
		}
		
		List<Referee> r = new ArrayList<Referee>();
		for(int i=0;i<16;i++) {
			Referee ref = new Referee(noms[rnd.nextInt(12)],"Referee"+(i+1),"Belge");
			rDAO.create(ref);
		}
		
		for(int i=0;i<8;i++) {
			Court court = new Court(i*100,false);
			cDAO.create(court);
		}
		for(int i=0;i<8;i++) {
			Court court = new Court(i*100,true);
			cDAO.create(court);
		}
		
		List<Opponent> ops = new ArrayList<Opponent>();
		int j=127;
		int k=1;
		for(int i=0;i<64;i++) {
			List<Player> pl = new ArrayList<Player>();
			pl.add(players[i]);
			pl.add(players[j]);
			ops.add(new Opponent(pl,k));
			j--;
			k++;
		}
		j=255;
		k=1;
		for(int i=128;i<192;i++) {
			List<Player> pl = new ArrayList<Player>();
			pl.add(players[i]);
			pl.add(players[j]);
			ops.add(new Opponent(pl,k));
			j--;
			k++;
		}
		j=255;
		k=1;
		for(int i=0;i<64;i++) {
			List<Player> pl = new ArrayList<Player>();
			pl.add(players[i]);
			pl.add(players[j]);
			ops.add(new Opponent(pl,k));
			j--;
			k++;
		}
		for(Opponent o : ops) {
			oDAO.create(o);
		}
		
 	}

}
