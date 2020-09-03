package US_Airports_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import US_Airports_DB.ConnectDB;
import US_Airports_Model.Flight;

public class DAO {

	public List<Flight> getFlights_Passengers(int year) {

		String sql = "SELECT Origin_city,Destination_city,AVG(Passengers) as p,AVG(Distance) as d  "
				+ "FROM US_Airports.airports " + "WHERE year(Fly_date)=? " + "GROUP BY Origin_city,Destination_city; ";

		List<Flight> flights = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, year);

			ResultSet res = st.executeQuery();

			while (res.next()) {

				Flight f = new Flight(res.getString("Origin_city"), res.getString("Destination_city"),
						(int) res.getDouble("d"), (int) res.getDouble("p"));
				flights.add(f);

			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return flights;

	}

}
