package be.PaulA.project.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import be.PaulA.pojo.Match;
import be.PaulA.pojo.Opponent;
import be.PaulA.pojo.Player;
import be.PaulA.pojo.ScheduleType;

public class OpponentDAO extends DAO<Opponent>{
	public OpponentDAO(Connection conn) {
		super(conn);
	}
	public boolean create(Opponent o) {
		Player[] players = o.getPlayer().stream().toArray(Player[]::new);
		String type = null;
		try{
			if(players[0].getGender()=='M'&&players[1].getGender()=='M') {
				type="DM";
			}else {
				if(players[0].getGender()=='F'&&players[1].getGender()=='F') {
					type="DF";
				}else {
					type="Dmi";
				}
			}
			Statement  st = this.connect.createStatement();
			st.executeUpdate("INSERT INTO duo(duo_type,duo_rank) VALUES('"+type+"',"+ o.getRank()+")");
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		try{
			int id=0,pid=0;
			ResultSet result = this.connect.createStatement(
					
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY	).executeQuery("SELECT duo_id FROM duo ORDER BY duo_id DESC LIMIT 1");
					while(result.next()) {
						id=result.getInt("duo_id");
					}
			result = this.connect.createStatement(		
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY	).executeQuery("SELECT pers_id FROM Personne WHERE pers_nom='"+players[0].getLastname()+"' and pers_prenom='" + players[0].getFirstname()+"' and pers_nationnalite='"+players[0].getNationnality()+"' ORDER BY pers_id DESC LIMIT 1");
					while(result.next()) {
						pid=result.getInt("pers_id");
					}
			Statement st = this.connect.createStatement();
			st.executeUpdate("INSERT INTO participant(FK_duo_Id,FK_pers_id) VALUES("+id+",+"+pid+")");
			
			result = this.connect.createStatement(		
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY	).executeQuery("SELECT pers_id FROM Personne WHERE pers_nom='"+players[1].getLastname()+"' and pers_prenom='" + players[1].getFirstname()+"' and pers_nationnalite='"+players[1].getNationnality()+"'  ORDER BY pers_id DESC LIMIT 1");
					while(result.next()) {
						pid=result.getInt("pers_id");
					}
			 st = this.connect.createStatement();
			st.executeUpdate("INSERT INTO participant(FK_duo_Id,FK_pers_id) VALUES("+id+",+"+pid+")");
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
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
	public Opponent find(int rank,Match m) {
		String type=null;
		switch(m.getSchedule().getType()){
		case GentlemenDouble: 
			type="DM";
			break;
		case LaidesDouble:
			type="DF";
			break;
		case MixedDouble:
			type="Dmi";
			break;
		
		}
		List<Player> p = new ArrayList<Player>();
		Opponent o= null;
		try{
			ResultSet result = this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY	).executeQuery("SELECT duo_rank,p.FK_pers_id FROM participant p INNER JOIN Duo d on d.duo_id=p.FK_duo_id WHERE duo_rank="+rank+" and duo_type='"+type+"'");
			while(result.next()) {
				PlayerDAO pDAO = new PlayerDAO(this.connect);
				p.add(pDAO.find(result.getInt("FK_pers_id")));
				o = new Opponent(p,result.getInt("duo_rank"));
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		if(o!=null)
		return o;
		else {
			ArrayList<Player> players = new ArrayList<Player>();
			Player p1 = new Player("null","null","null",0,'F');
			players.add(p1);
			return new Opponent(players,0);
		}
	}
}
