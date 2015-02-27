package gti310.tp3.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import gti310.tp3.data.Graph;
import gti310.tp3.data.OptimisedRoute;
import gti310.tp3.data.Route;
import gti310.tp3.parser.FileParser;
import gti310.tp3.parser.Parser;
import gti310.tp3.solver.GraphSolver;
import gti310.tp3.solver.Solver;

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
	 * @throws IOException 
	 */
	public static void main(String args[]) throws IOException {
		System.out.println("Unreal Networks Solver !");
		/* 
		 * DIAG SEQ ENONCE
		 * 
		 * Application appelle le parser pour lire le fichier
		 * le parser lis le fichier et crée l'objet de stockage
		 * le parser retourne l'objet de stockage
		 * 
		 * L'application appelle le solver avec l'objet de stockage en parametre
		 * le solver consulte l'Objet de stockage et cree l'objet solution
		 * le solver retourne lobjet solution
		 * 
		 * l'application appelle le writer avec l'objet solution en parametre
		 * le writer consulte l'objet solution et écris le fichier
		 */
		
		Parser<Graph> parser = new FileParser();
		Graph routeGraph = parser.parse(args[0]);
		
		System.out.println(routeGraph.toString());
		routeGraph.displayAllRoutes();
		
		Solver<Graph,OptimisedRoute> solver = new GraphSolver(); 
		solver.solve(routeGraph);
		
		
		
/*
		// faire comme dans fichier vendeur-sol
		Route route1 = new Route(1, -1, 0);
		Route route2 = new Route(2, 1, 500);
		Route route3 = new Route(3, 1, 450);
		Route route4 = new Route(4, 3, 800);
		Route route5 = new Route(5, 7, 1090);
		Route route6 = new Route(6, 5, 1365);
		Route route7 = new Route(7, 1, 800);
*/
		
	
		
		
		
		
		
		
		
		
	}
}
