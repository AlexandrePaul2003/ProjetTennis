package be.PaulA.project.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.PaulA.pojo.Opponent;
import be.PaulA.pojo.Player;
import be.PaulA.pojo.ScheduleType;

public class OpponentDAO extends DAO<Opponent>{
	public OpponentDAO(Connection conn) {
		super(conn);
	}
	public boolean create(Opponent obj) {
		return true;
	}
	
	public boolean delete(Opponent obj) {
		return true;
	}
	
	public boolean update(Opponent obj) {
		return true;
	}
	public Opponent find(int id) {
		return null;
	}
	public Opponent find(ScheduleType type) {
		List<Player> p = new ArrayList<Player>();
		try{
			ResultSet result = this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY	).executeQuery("SELECT pers_id FROM participant");
			while(result.next()) {
				PlayerDAO pDAO = new PlayerDAO(this.connect);
				p.add(pDAO.find(result.getInt("pers_id")));
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return new Opponent(p);
	}
}
