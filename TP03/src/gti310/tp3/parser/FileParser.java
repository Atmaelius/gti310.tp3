package gti310.tp3.parser;

import gti310.tp3.data.Graph;
import gti310.tp3.data.Route;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe FileParser concret pour lire le fichier et générer le graphe qui sera renvoyé a l'application principale
 * @author eric
 */

public class FileParser implements Parser<Graph>{

	public Graph parse(String filename) {
		boolean startExists = false;
		
		Graph routeGraph = new Graph();
		// code pour le bufferedReader modifié depuis: http://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
		BufferedReader br = null;
		int lineNumber = 0;
		String[] currentSplittedLine;
		
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(filename));
			
			// on utilise la variable linenumber pour identifier les lignes.
			// la premiere ligne donne le nombre de sommets et la seconde le point de départ
			// le reste c'est les routes.
			while ((sCurrentLine = br.readLine()) != null) {
				currentSplittedLine = sCurrentLine.split("\t", 0);
				
				if((lineNumber == 0) && (currentSplittedLine.length == 1)){
					routeGraph.setNbOfSummits(Integer.parseInt(currentSplittedLine[0]));
				}
				else if((lineNumber == 1) && (currentSplittedLine.length == 1)){
					routeGraph.setStartPoint(Integer.parseInt(currentSplittedLine[0]));
				}
				else if(lineNumber > 1){
					if((currentSplittedLine[0].compareTo("$") != 0) && (currentSplittedLine.length == 3)){
						Route route = new Route(Integer.parseInt(currentSplittedLine[0]), Integer.parseInt(currentSplittedLine[1]), Integer.parseInt(currentSplittedLine[2]));
						routeGraph.addRoute(route);
					}
				}
				else{
					System.out.println("HOUSTON WE HAVE A PROBLEM");
				}
				
				lineNumber++;
			}
			
			for (Route route : routeGraph.getRoutes()) {
				if(routeGraph.getStartPoint() == route.getSource()){
					startExists = true;
				}
			}

			if(!startExists){
				System.out.println("LE POINT DE DÉPART N'EXISTE PAS DANS LES ROUTES");
				return null;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
				System.out.println(ex.getMessage());
			}
		}
		
		return routeGraph;
	}
}
