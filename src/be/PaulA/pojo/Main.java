package be.PaulA.pojo;

import be.PaulA.project.DAO.ProjectConnection;
import be.PaulA.project.DAO.*;

public class Main {

	public static void main(String[] args) {
		PlayerDAO eDAO = new PlayerDAO(ProjectConnection.getInstance());
		Player p = eDAO.find(1);
		System.out.println(p.getFirstname());

	}

}
