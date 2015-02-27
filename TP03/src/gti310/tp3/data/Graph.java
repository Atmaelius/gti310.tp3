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
	
	
	// on va setter le nombre de sommets et de routes a partir du array de routes directement
	public Graph(int startPoint, ArrayList<Route> routeArray, String sourcePath, String destinationPath) {
		super();
		this.startPoint = startPoint;
		this.routeArray = routeArray;
		this.nbOfSummits = 42;
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

	public int getNbOfSummits() {
		return nbOfSummits;
	}

	public int getNbOfRoutes() {
		return nbOfRoutes;
	}

	public void setNbOfRoutes(int nbOfRoutes) {
		this.nbOfRoutes = nbOfRoutes;
	}

	public ArrayList<Route> getGraph() {
		return routeArray;
	}

	// on set le nb de routes en même temps que le graphe parce que le nb de routes est la grandeur du graphe
	// on set le nombre de sommet ici parce que le graph donnera combien de sommet on à [A CALCULER]
	public void setGraph(ArrayList<Route> graph) {
		this.routeArray = graph;
		this.nbOfRoutes = graph.size();
		this.nbOfSummits = 42;
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
	
	public String toString() {
		return "Graph: [nbOfSummits: " + nbOfSummits + "] - [nbOfRoutes: " + nbOfRoutes + "] - [startPoint: " + startPoint + "] - [sourcePath: " + sourcePath + "] - [destinationPath: " + destinationPath + "]";
	}
	
}
