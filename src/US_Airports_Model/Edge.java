package US_Airports_Model;

public class Edge implements Comparable<Edge> {
	
	

	private String destination;
    private int weight;
    
	public Edge(String destination, int weight) {
		super();
		this.destination = destination;
		this.weight = weight;
	}

	public String getDestination() {
		return destination;
	}

	public int getWeight() {
		return weight;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override
	public int compareTo(Edge other) {
		if(this.weight<other.getWeight()) {
			return 1;
		}
		if(this.weight==other.weight)
		return 0;
		
		return -1;
	} 
	
	@Override
	public String toString() {
		return String.format("Edge [destination=%s, weight=%s]", destination, weight);
	}
    
    
    
	
}
