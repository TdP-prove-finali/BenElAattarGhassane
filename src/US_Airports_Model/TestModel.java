package US_Airports_Model;
import java.util.*;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		model.loadFlights(2005);
				
		
		model.printAll();
		
		model.createGraph();
		
		Map<Long,List<String>>percorso=model.dijkstraShortestPath("Los Angeles, CA", "Bend, OR");
		
		System.out.println(percorso);
		
		
		
//		boolean ans=model.isConnected("Los Angeles, CA", "Bend, OR");
//		
//		if(ans)System.out.println("Connected");
//		else System.out.println("Not connected");
//		

		
		
		
		
		
	}

}
