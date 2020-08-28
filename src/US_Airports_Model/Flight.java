package US_Airports_Model;

public class Flight {

	private int avg_passengers;
	private int distance;
	private String origin;
	private String destination;
	
	public Flight(String origin, String destination, int distance,int avg_passengers) {
		
		this.origin=origin;
		this.destination=destination;
		this.distance=distance;
		this.avg_passengers=avg_passengers;
	}
	
	public Flight(String origin,String destination,int distance) {
		
		this.origin=origin;
		this.destination=destination;
		this.distance=distance;
	}
	


	public int getAvg_passengers() {
		return avg_passengers;
	}


	public int getDistance() {
		return distance;
	}


	public String getOrigin() {
		return origin;
	}


	public String getDestination() {
		return destination;
	}


	public void setAvg_passengers(int avg_passengers) {
		this.avg_passengers = avg_passengers;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}


	public void setOrigin(String origin) {
		this.origin = origin;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	
	
	@Override
	public String toString() {
		return String.format("Origin=%s, Destination=%s,Avg_passengers=%s, Distance=%s",
				origin,destination,avg_passengers,distance);
	}
	

}
