package US_Airports_DB;

public class TestDAO {

	public static void main(String[] args) {

		DAO dao = new DAO();
		System.out.println(dao.getFlights_Passengers(1995,2000).get(0).getAvg_passengers());
	}

}
