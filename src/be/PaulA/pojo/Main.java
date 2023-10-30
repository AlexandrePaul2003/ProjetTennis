package be.PaulA.pojo;

import be.PaulA.project.DAO.ProjectConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import be.PaulA.project.DAO.*;

public class Main {

	public static void main(String[] args) {
		PlayerDAO pDAO = new PlayerDAO(ProjectConnection.getInstance());
		RefereeDAO rDAO = new RefereeDAO(ProjectConnection.getInstance());
		
		String[] noms = {"Paul", "Pignes", "Poirreaux","Foret","Cappelen","Djokovic","Nadal","Federer","Messi","Ronaldo","Ibra","Neymar","Rony","Dayot"};		
		String[] prenoms = {"Alexandre", "Paul", "Hercule","Isabelle","Christiane","Novak","Rafa","Roger","Leo","Christiano","ZLATAN","Jean","GOAT","Upamecado"};
		String[] nat = {"Belge", "Francais", "Néérlandais","Allemand","Espagnol","Portugais","Italien","Ruskov","Argentin","Brésilien","Suédois","JeanBonBeurre","Américain","Canadien"};
		List<Player> p = new ArrayList<Player>();
		Random rnd = new Random();
		/*for(int i = 0;i<128;i++) {
			p.add(new Player(noms[rnd.nextInt(12)],prenoms[rnd.nextInt(12)],nat[rnd.nextInt(12)],i,"M"));
		}
		for(int i = 0;i<128;i++) {
			p.add(new Player(noms[rnd.nextInt(12)],prenoms[rnd.nextInt(12)],nat[rnd.nextInt(12)],i,"F"));
		}
		/*for(Player player : p) {
			pDAO.create(player);
		}*/
		
		List<Referee> r = new ArrayList<Referee>();
		for(int i=0;i<16;i++) {
			r.add(new Referee(noms[rnd.nextInt(12)],"Referee"+i,"Belge"));
		}
		for(Referee ref : r) {
			rDAO.create(ref);
		}
		
 	}

}
