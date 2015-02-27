package gti310.tp3.data;

import java.util.ArrayList;
import gti310.tp3.data.Route;

/**
 * Cette classe sera la représentation logique de ce qui sera lu dans le fichier.
 * LE graph possèdera les informations suivantes:
 * 		array de routes
 * 		point de depart
 * 		nombre de sommets
 * 		nombre de chemins
 * 		path de source et destination -> voir si pertinent
 * @author eric
 */

public class Graph {

	public int startPoint;
	public int nbOfSummits;
	public int nbOfRoutes;
	public ArrayList<Route> routeArray;
	public String sourcePath;
	public String destinationPath;
	
	
	public Graph() {
		// à la création du graphe on crée un array de routes vides, ainsi on peu utiliser la méthode addroute directement apres la création avec le constructeur sans paramètres
		routeArray = new ArrayList<Route>();
	}
	
	// on va setter le nombre de sommets et de routes a partir du array de routes directement
	public Graph(int startPoint, ArrayList<Route> routeArray, int nbOfSummits, String sourcePath, String destinationPath) {
		super();
		this.startPoint = startPoint;
		this.routeArray = routeArray;
		this.nbOfSummits = nbOfSummits;
		this.nbOfRoutes = routeArray.size();
		this.sourcePath = sourcePath;
		this.destinationPath = destinationPath;
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

	/*
	 // pas besoin de setter le nb de routes puisque le set gu graph set le nb de routes aussi
	public void setNbOfRoutes(int nbOfRoutes) {
		this.nbOfRoutes = nbOfRoutes;
		// on verifie si la valeur du nombre de routes concorde avec la taille du array de routes.
		// 
		if((nbOfRoutes != routeArray.size()) && (routeArray.size() != 0)){
			nbOfRoutes = routeArray.size();
		}
	}
*/
	public ArrayList<Route> getGraph() {
		return routeArray;
	}

	// on set le nb de routes en même temps que le graphe parce que le nb de routes est la grandeur du graphe
	public void setGraph(ArrayList<Route> graph) {
		this.routeArray = graph;
		this.nbOfRoutes = graph.size();
	}

	public String getSourcePath() {
		return sourcePath;
	}

	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}

	public String getDestinationPath() {
		return destinationPath;
	}

	public void setDestinationPath(String destinationPath) {
		this.destinationPath = destinationPath;
	}
	
	/**
	 * A human-readable display of the graph
	 */
	public String toString() {
		return "Graph: [nbOfSummits: " + nbOfSummits + "] - [nbOfRoutes: " + nbOfRoutes + "] - [startPoint: " + startPoint + "] - [sourcePath: " + sourcePath + "] - [destinationPath: " + destinationPath + "]";
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
