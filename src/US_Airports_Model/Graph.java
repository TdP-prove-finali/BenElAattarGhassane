package US_Airports_Model;
import java.util.*;

public class Graph{
	        int vertices;
	        private Map<String,List<Edge>> adjacencyList;

	        Graph() {
	           adjacencyList = new HashMap<String,List<Edge>>();
	        }

	        public void addEdge(String source,String destination, int weight) {
	            Edge edge = new Edge(destination, weight);
	            
	            adjacencyList.get(source).add(edge);
	        }
	        
              public List<Edge> getNeighbours(String node){
	        	
	        	return adjacencyList.get(node);
	        }
              
	        public boolean containsVertex(String node) {
	        	if(adjacencyList.containsKey(node))
	        		return true;
	        	
	        	else return false;
	        }
	        
	        public boolean containsEdge(String source,String destination) {
	        	
	        	if(containsVertex(source)) {
	        		for(Edge e:this.getNeighbours(source)) {
	        			if(e.getDestination().equals(destination))
	        				return true;
	        		}
	        		
	        	}
	        	return false;
	        	
	        }
	        

	        
	  	}
	


