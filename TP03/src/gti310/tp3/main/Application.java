package gti310.tp3.main;

import java.util.ArrayList;
import gti310.tp3.data.Graph;
import gti310.tp3.data.Route;

/**
 * The Application class defines a template method to call the elements to
 * solve the problem Unreal-Networks is facing.
 * 
 * @author Francois Caron <francois.caron.7@ens.etsmtl.ca>
 */
public class Application {

	/**
	 * The Application's entry point.
	 * 
	 * The main method makes a series of calls to find a solution to the
	 * problem. The program awaits two arguments, the complete path to the
	 * input file, and the complete path to the output file.
	 * 
	 * @param args The array containing the arguments to the files.
	 */
	public static void main(String args[]) {
		System.out.println("Unreal Networks Solver !");

		// faire comme dans fichier vendeur-sol
		Route route1 = new Route(1, -1, 0);
		Route route2 = new Route(2, 1, 500);
		Route route3 = new Route(3, 1, 450);
		Route route4 = new Route(4, 3, 800);
		Route route5 = new Route(5, 7, 1090);
		Route route6 = new Route(6, 5, 1365);
		Route route7 = new Route(7, 1, 800);
	
		
		//Route[] routeArray = new Route[nbOfRoutes];
		ArrayList<Route> routeArray = new ArrayList<>();

		routeArray.add(route1);
		routeArray.add(route2);
		routeArray.add(route3);
		routeArray.add(route4);
		routeArray.add(route5);
		routeArray.add(route6);
		routeArray.add(route7);
		
		Graph graph = new Graph(1, routeArray, "C://User/eric/Mes Documents/ ...", "C://User/Eric/Mes Documents/ Ailleurs....");
		
		System.out.println(graph.toString());
		System.out.println(route2.toString());
		
		
		
		
		
		
	}
}
