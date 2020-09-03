package US_Airports_Model;

import java.util.*;

public class Graph {
	int vertices;
   
	//la lista di adiacenza,che rappresenta il grafo,è riprodotta tramite Hashmap,che associa ad un nodo (stringa) i suoi vicini.
	private Map<String, List<Edge>> adjacencyList;

	public Graph() {
		adjacencyList = new HashMap<String, List<Edge>>();
	}
	
	//aggiunge un nuovo arco al grafo.

	public void addEdge(String source, String destination, int weight) {

		Edge edge = new Edge(destination, weight);

		if (!adjacencyList.containsKey(source)) {
			List<Edge> nuovaLista = new ArrayList<Edge>();
			nuovaLista.add(edge);
			adjacencyList.put(source, nuovaLista);
		} else {
			adjacencyList.get(source).add(edge);
		}

	}
   //Trova i nodi adiacenti ad uno selezionato. 
	public List<Edge> getNeighbours(String node) {

		if (!this.adjacencyList.containsKey(node)) {
			return new ArrayList<Edge>();
		}
		return adjacencyList.get(node);
	}

	public boolean containsVertex(String node) {
		if (adjacencyList.containsKey(node))
			return true;

		else
			return false;
	}

	public boolean containsEdge(String source, String destination) {

		if (containsVertex(source)) {
			for (Edge e : this.getNeighbours(source)) {
				if (e.getDestination().equals(destination))
					return true;
			}

		}
		return false;

	}

	public int getSize() {

		return this.adjacencyList.size();
	}

	@Override
	public String toString() {
		return String.format("Graph [adjacencyList=%s]", adjacencyList);
	}

}
