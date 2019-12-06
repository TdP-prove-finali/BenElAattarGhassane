package US_Airports_Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

import US_Airports_DB.DAO;

public class Model {
	
	private List<Flight> voli_passeggeri=new ArrayList<>();
	private DAO dao;
	private int [] Visited;
	
	public Model(int year) {
		dao=new DAO();
		
		voli_passeggeri=dao.getFlights_Passengers(year);
		
	    Visited=new int[voli_passeggeri.size()+10];

	}
	
	
	 int search(int distance, List<Flight> input, int n,int visited[])
    {
    
   if (n == 0 || distance == 0)
       return 0;

 
    if (input.get(n-1).getDistance() >distance)
     {
      return search(distance, input, n-1,visited);
     }
   
   else {

       int v1[]=new int[visited.length];
       System.arraycopy(visited, 0, v1, 0, v1.length);
       int v2[]=new int[visited.length];
       System.arraycopy(visited, 0, v2, 0, v2.length);
       v1[n-1]=1;

       int ans1 = input.get(n-1).getAvg_passengers() + search(distance-input.get(n-1).getDistance(), input,n-1,v1);
       int ans2 = search(distance,input, n-1,v2);
       
       if(ans1>ans2){
           System.arraycopy(v1, 0, visited, 0, v1.length);
            return ans1;
           
       }
       else{
           System.arraycopy(v2, 0, visited, 0, v2.length);
           return ans2;
           
       }
   }   
   
     }
	
	public  void printAllBest(int distance) {
		
		int n=voli_passeggeri.size()-1;
	    System.out.println(search(distance,voli_passeggeri ,n, Visited));

		for(int i=0;i<n;i++)
	        if(Visited[i]==1) {
	         if(voli_passeggeri.get(i).getAvg_passengers()>0 && voli_passeggeri.get(i).getDistance()>0)
	        	System.out.println(voli_passeggeri.get(i));
		
	        }	
	}
	
	
	

}
