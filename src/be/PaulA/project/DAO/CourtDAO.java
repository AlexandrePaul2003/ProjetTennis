package be.PaulA.project.DAO;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import be.PaulA.pojo.Court;
public class CourtDAO extends DAO<Court>{
	public CourtDAO(Connection conn) {
		super(conn);
	}
	public boolean create(Court court) {
		try{
			Statement  st = this.connect.createStatement();
			int covered = court.getCovered() ? 1 : 0;
			st.executeUpdate("INSERT INTO Cours(cours_nbrPlaces,cours_couverture) VALUES("+court.getNbSpectator()+","+covered+")");
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean delete(Court obj) {
		return true;
	}
	
	public boolean update(Court obj) {
		return true;
	}
	
	public Court find(int id) {
		return null;
	}
	public List<Court> find() {
		List<Court> courts = new ArrayList<Court>();
		try{
			ResultSet result = this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY	).executeQuery("SELECT * FROM Cours");
			while(result.next()) {
				Boolean covered = result.getInt("cours_couverture")==1 ? true  :false ;
				courts.add(new Court(result.getInt("cours_nbrPlaces"),covered));
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return courts;
	}
}
