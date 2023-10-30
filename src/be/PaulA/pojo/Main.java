package be.PaulA.pojo;

import be.PaulA.project.DAO.ProjectConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import be.PaulA.project.DAO.*;

public class Main {

	public static void main(String[] args) {
		PlayerDAO pDAO = new PlayerDAO(ProjectConnection.getInstance());
		System.out.println(pDAO.find(1));
		/*
		String[] noms = {"Paul", "Pignes", "Poirreaux","Foret","Cappelen","Djokovic","Nadal","Federer","Messi","Ronaldo","Ibra","Neymar","Rony","Dayot"};		
		String[] prenoms = {"Alexandre", "Paul", "Hercule","Isabelle","Christiane","Novak","Rafa","Roger","Leo","Christiano","ZLATAN","Jean","GOAT","Upamecado"};
		String[] nat = {"Belge", "Francais", "Néérlandais","Allemand","Espagnol","Portugais","Italien","Ruskov","Argentin","Brésilien","Suédois","JeanBonBeurre","Américain","Canadien"};
		List<Player> p = new ArrayList<Player>();
		Random rnd = new Random();
		for(int i = 0;i<128;i++) {
			p.add(new Player(noms[rnd.nextInt(12)],prenoms[rnd.nextInt(12)],nat[rnd.nextInt(12)],i,"M"));
		}
		for(Player player : p) {
			System.out.println(player.getFirstname()+" " + player.getLastname()+" "+player.getNationnality()+" "+player.getRank());
		}*/
		pDAO.create(new Player("Paul","Alexandre","Belge",1,"M"));
		
 	}

}
