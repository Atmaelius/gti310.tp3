package gti310.tp3.main;

import java.io.IOException;
import gti310.tp3.data.*;
import gti310.tp3.parser.*;
import gti310.tp3.solver.*;
import gti310.tp3.writer.*;

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
		
		// on lis le fichier et retourne le graphe des routes
		Parser<Graph> parser = new FileParser();
		Graph routeGraph = parser.parse(args[0]);
		
		System.out.println("READING FILE...");
		System.out.println("CREATING UNSOLVED GRAPH");
		routeGraph.displayAllRoutes();
		
		System.out.println("SOLVING THE GRAPH");
		// on envoie le graphe des routes dans le solveur qui retourne le chemin optimise
		Solver<Graph,ResolutionTable> solver = new GraphSolver(); 
		ResolutionTable resTable = solver.solve(routeGraph);
	
		System.out.println("WRITING SOLVED GRAPH TO FILE...");
		
		Writer<ResolutionTable> resTableWriter = new ResolutionTableWriter();
		resTableWriter.write(args[1], resTable);
		
		System.out.println("DONE");
		System.out.println("SOLVED FILE IS AVAILABLE AT THIS LOCATION: " + args[1]);
		
	}
}
