package gti310.tp3.data;
/**
 * Classe qui représente une route entre deux points
 * @author eric
 */
public class Route {

	public int destination;
	public int parent;
	public int weight;
	
	public Route(int destination, int parent, int weight) {
		super();
		this.destination = destination;
		this.parent = parent;
		this.weight = weight;
	}
	
	public int getDestination() {
		return destination;
	}
	public void setDestination(int destination) {
		this.destination = destination;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public String toString(){
		return "Destination: " + destination + "; Parent: " + parent + "; Weight: " + weight + ";";
	}
	
}
