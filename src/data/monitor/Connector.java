package data.monitor;

import java.sql.*;

/**
 * @author Christopher Lu
 * Connects to MySQL database.
 */

public class Connector {
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	public Connector() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/NBA_Players", "root", "");
			statement = connection.createStatement();
		
		} catch (Exception e) {
			System.out.println("error is: " + e);
		}
	}
	
	public void getData() {
		try {
			
			String query = "select * from NBA_Players";
			resultSet = statement.executeQuery(query);
			System.out.println("QUERY RESULT:");
			while (resultSet.next()) {
				String playerName = resultSet.getString("Name");
				String teamName = resultSet.getString("Team");
				float heightInches = resultSet.getFloat("Height");
				float weightPounds = resultSet.getFloat("Weight");
				float wingspanInches = resultSet.getFloat("Wingspan");
				float pointsPG = resultSet.getFloat("PPG");
				float assistsPG = resultSet.getFloat("APG");
				float reboundsPG = resultSet.getFloat("RPG");
				float stealsPG = resultSet.getFloat("SPG");
				float blocksPG = resultSet.getFloat("BPG");
				float fgPCT = resultSet.getFloat("FG");
				float threePCT = resultSet.getFloat("3PT");
				float ftPCT = resultSet.getFloat("FT");
				float turnOvers = resultSet.getFloat("TOs");
				System.out.println("Name: " + playerName);
				System.out.println("Team: " + teamName);
				System.out.println("Height (Inches): " + heightInches);
				System.out.println("Weight (Pounds): " + weightPounds);
				System.out.println("Wingspan (Inches): " + wingspanInches);
				System.out.println("PPG: " + pointsPG);
				System.out.println("APG: " + assistsPG);
				System.out.println("RPG: " + reboundsPG);
				System.out.println("SPG: " + stealsPG);
				System.out.println("BPG: " + blocksPG);
				System.out.println("FG: " + fgPCT);
				System.out.println("3PT: " + threePCT);
				System.out.println("FT: " + ftPCT);
				System.out.println("TOs: " + turnOvers);
			}
			
		} catch (Exception e) {
			System.out.println("error is: " + e);
		}
	}
}
