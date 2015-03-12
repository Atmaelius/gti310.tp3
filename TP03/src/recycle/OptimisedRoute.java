package recycle;

import gti310.tp3.data.Route;

import java.util.ArrayList;

/**
 * [ A RETRAVAILLER ]
 * Cette classe est la représentation logique des plus courts chemins trouvés
 * ESSENTIELLEMENT LA MÊME CHOSE QUE LA CLASSE GRAPH
 * 	-> arrayList de chemins
 * 	-> point de départ
 * 
 * <indice du sommet de départ>
 * <sommet de destination> <tabulation> <parent> <tabulation> <poids>
 * .....
 * 
 * @author eric
 */

public class OptimisedRoute {

	public int startPoint;
	public ArrayList<Route> routeArray;
	
	public OptimisedRoute() {
		// initialisation vide du array afin de pouvoir le remplir avec la méthode add
		routeArray = new ArrayList<Route>();
	}
	
	public OptimisedRoute(int startPoint, ArrayList<Route> routeArray) {
		super();
		this.startPoint = startPoint;
		this.routeArray = routeArray;
	}
	
	public int getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(int startPoint) {
		this.startPoint = startPoint;
	}

	public ArrayList<Route> getRouteArray() {
		return routeArray;
	}

	public void setRouteArray(ArrayList<Route> routeArray) {
		this.routeArray = routeArray;
	}
	
	/**
	 * Adds a route to the graph
	 * @param route A valid route to be added to the graph
	 */
	public void addRoute(Route route){
		routeArray.add(route);
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
