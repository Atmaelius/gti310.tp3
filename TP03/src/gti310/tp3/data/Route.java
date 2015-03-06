package gti310.tp3.data;
/**
 * Classe qui représente une route entre deux poIntegers
 * @author eric
 */
public class Route {

	public Integer source;
	public Integer destination;
	public Integer weight;
	
	public Route(Integer source, Integer destination, Integer weight) {
		super();
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
	
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public Integer getDestination() {
		return destination;
	}
	public void setDestination(Integer destination) {
		this.destination = destination;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	public String toString(){
		return "Source: " + source + "; Destination: " + destination + "; Weight: " + weight + ";";
	}
	
}
