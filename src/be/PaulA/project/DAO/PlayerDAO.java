package be.PaulA.project.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import be.PaulA.pojo.Court;
import be.PaulA.pojo.Player;

public class PlayerDAO extends DAO<Player>{
	public PlayerDAO(Connection conn) {
		super(conn);
	}
	public boolean create(Player player) {
		try{
			Statement  st = this.connect.createStatement();
			st.executeUpdate("INSERT INTO Personne(pers_nom,pers_prenom,pers_nationnalite) VALUES('"+player.getLastname()+"','" + player.getFirstname()+"','"+player.getNationnality()+"')");
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		try{
			int id=0;
			ResultSet result = this.connect.createStatement(
					
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY	).executeQuery("SELECT pers_id FROM Personne WHERE pers_nom='"+player.getLastname()+"' and pers_prenom='" + player.getFirstname()+"' and pers_nationnalite='"+player.getNationnality()+"'");
					while(result.next()) {
						id=result.getInt("pers_id");
					}
			System.out.println(id);
			Statement st = this.connect.createStatement();
			st.executeUpdate("INSERT INTO Joueur(pers_id,pers_rank,pers_sexe) VALUES("+id+","+player.getRank()+",'"+player.getGender()+"')");
			
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean delete(Player obj) {
		return true;
	}
	
	public boolean update(Player obj) {
		return true;
	}
	
	public Player find(int id) {
		Player p = null;
		try{
			ResultSet result = this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY	).executeQuery("SELECT * FROM Joueur j INNER JOIN Personne p ON j.pers_id=p.pers_id WHERE j.pers_id="+id);
			while(result.next()) {
				p= new Player(result.getString("pers_nom"),result.getString("pers_prenom"),result.getString("pers_nationnalite"),result.getInt("pers_rank"),result.getString("pers_sexe").charAt(0));
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return p;
	}
}
