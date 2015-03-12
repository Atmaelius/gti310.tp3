package gti310.tp3.data;

import java.util.ArrayList;
import java.util.TreeSet;
import gti310.tp3.data.Route;

/**
 * Cette classe sera la représentation logique de ce qui sera lu dans le fichier.
 * LE graph possèdera les informations suivantes:
 * 		array de routes
 * 		point de depart
 * 		nombre de sommets
 * 		nombre de chemins
 * @author eric
 */

public class Graph {

	public int startPoint;
	public int nbOfSummits;
	public int nbOfRoutes;
	public ArrayList<Route> routeArray;
	
	public Graph() {
		// à la création du graphe on crée un array de routes vides, ainsi on peu utiliser la méthode addroute directement apres la création avec le constructeur sans paramètres
		routeArray = new ArrayList<Route>();
	}
	
	// on va setter le nombre de sommets et de routes a partir du array de routes directement
	public Graph(int startPoint, ArrayList<Route> routeArray, int nbOfSummits) {
		super();
		this.startPoint = startPoint;
		this.routeArray = routeArray;
		this.nbOfSummits = nbOfSummits;
		this.nbOfRoutes = routeArray.size();
	}

	public int getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(int startPoint) {
		this.startPoint = startPoint;
	}

	public void setNbOfSummits(int nbOfSummits) {
		this.nbOfSummits = nbOfSummits;
	}
	
	public int getNbOfSummits() {
		return nbOfSummits;
	}

	public int getNbOfRoutes() {
		return nbOfRoutes;
	}
	
	public ArrayList<Route> getRoutes() {
		return routeArray;
	}

	// on set le nb de routes en même temps que le graphe parce que le nb de routes est la grandeur du graphe
	public void setRoutes(ArrayList<Route> routes) {
		this.routeArray = routes;
		this.nbOfRoutes = routes.size();
	}

	/**
	 * A function that returns an arrayList containing all the summits of the current graph
	 * @return	arrayTemp 
	 */
	public ArrayList<Integer> getSummitsList(){
		TreeSet<Integer> tempSet = new TreeSet<Integer>(); 
		for (int i = 0; i < getNbOfRoutes(); i++) {
			tempSet.add(routeArray.get(i).getSource());
		}
		ArrayList<Integer> arrayTemp = new ArrayList<Integer>(tempSet);
		return arrayTemp;
	}
	
	/**
	 * A human-readable display of the graph
	 */
	public String toString() {
		return "Graph: [nbOfSummits: " + nbOfSummits + "] - [nbOfRoutes: " + nbOfRoutes + "] - [startPoint: " + startPoint + "]";
	}
	
	/**
	 * Adds a route to the graph
	 * @param route A valid route to be added to the graph
	 * 	nbOfRoutes is automatically incremented after the add
	 */
	public void addRoute(Route route){
		routeArray.add(route);
		nbOfRoutes++;
	}
	
	/**
	 * Displays all contained routes as[Destination: x; Parent: y; Weight: z;]
	 */
	public void displayAllRoutes(){
		for (Route route : routeArray) {
			System.out.println(route.toString());
		}
	}
}
