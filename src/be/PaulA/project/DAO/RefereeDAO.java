package be.PaulA.project.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import be.PaulA.pojo.Court;
import be.PaulA.pojo.Referee;

public class RefereeDAO extends DAO<Referee>{
	public RefereeDAO(Connection conn) {
		super(conn);
	}
	public boolean create(Referee referee) {

		try{
			Statement  st = this.connect.createStatement();
			st.executeUpdate("INSERT INTO Personne(pers_nom,pers_prenom,pers_nationnalite) VALUES('"+referee.getLastname()+"','" + referee.getFirstname()+"','"+referee.getNationnality()+"')");
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		try{
			int id=0;
			ResultSet result = this.connect.createStatement(
					
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY	).executeQuery("SELECT pers_id FROM Personne WHERE pers_nom='"+referee.getLastname()+"' and pers_prenom='" + referee.getFirstname()+"' and pers_nationnalite='"+referee.getNationnality()+"'");
					while(result.next()) {
						id=result.getInt("pers_id");
					}
			Statement st = this.connect.createStatement();
			st.executeUpdate("INSERT INTO Arbitre(pers_id) VALUES("+id+")");
			
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean delete(Referee obj) {
		return true;
	}
	
	public boolean update(Referee obj) {
		return true;
	}
	
	public Referee find(int id) {
		return null;
	}
	public List<Referee> find() {
		List<Referee> refs = new ArrayList<Referee>();
		try{
			ResultSet result = this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY	).executeQuery("SELECT * FROM Arbitre a INNER JOIN Personne p ON a.pers_id=p.pers_id");
			while(result.next()) {
				refs.add(new Referee(result.getString("pers_nom"),result.getString("pers_prenom"),result.getString("pers_nationnalite")));
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return refs;
	}
}
