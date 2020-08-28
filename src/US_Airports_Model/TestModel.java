package US_Airports_Model;
import java.util.*;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		model.loadFlights(1990);
				
		
		model.printAll();
		
		model.createGraph();
		
		
		
//		boolean ans=model.isConnected("Los Angeles, CA", "San Francisco, CA");
//		
//		if(ans)System.out.println("Connected");
//		else System.out.println("Not connected");
//		

		
		
		
		
		
	}

}
