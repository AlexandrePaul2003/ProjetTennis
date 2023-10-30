package be.PaulA.project.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.PaulA.pojo.Court;
import be.PaulA.pojo.Player;

public class PlayerDAO extends DAO<Player>{
	public PlayerDAO(Connection conn) {
		super(conn);
	}
	public boolean create(Player obj) {
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
				p= new Player(result.getString("pers_nom"),result.getString("pers_prenom"),result.getString("pers_nationnalite"),result.getInt("pers_rank"),result.getString("pers_sexe"));
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return p;
	}
}
