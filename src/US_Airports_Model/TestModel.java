package US_Airports_Model;
import java.util.*;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		model.loadFlights(1990);
				
		
		
		
		model.createGraph();
		
//		//Map<Long,List<String>>percorso=model.dijkstraShortestPath("Los Angeles, CA", "Bend, OR");
		
		//model.printAll();
		
	   System.out.println(model.getGraph());
		
		if(model.existVertex("Seattle, WA")) {
         System.out.println("YES");
		}		
		else {
			System.out.println("NO");
		}
		
		
//		boolean ans=model.isConnected("Los Angeles, CA", "Bend, OR");
//		
//		if(ans)System.out.println("Connected");
//		else System.out.println("Not connected");
//		

		
		
		
		
		
	}

}
