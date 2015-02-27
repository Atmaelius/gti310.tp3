package gti310.tp3.parser;

import gti310.tp3.data.Graph;
import gti310.tp3.data.Route;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileParser implements Parser{

	@Override
	public Object parse(String filename) {
		
		// code pour le bufferedReader modifié depuis: http://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
		BufferedReader br = null;
		Graph routeGraph = new Graph();
		int lineNumber =0;
		String inputFile = filename;
		String[] currentSplittedLine;
		
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(inputFile));
			routeGraph.setSourcePath(inputFile);
			
			while ((sCurrentLine = br.readLine()) != null) {
				currentSplittedLine = sCurrentLine.split("\t", 0);
				
				if(lineNumber == 0){
					routeGraph.setNbOfSummits(Integer.parseInt(currentSplittedLine[0]));
					System.out.println("NB OF SUMMITS: " + routeGraph.getNbOfSummits());
				}
				else if(lineNumber == 1){
					routeGraph.setStartPoint(Integer.parseInt(currentSplittedLine[0]));
					System.out.println("STARTPOINT: " + routeGraph.getStartPoint());
				}
				else{
					if(currentSplittedLine[0].compareTo("$") != 0){
						Route route = new Route(Integer.parseInt(currentSplittedLine[0]), Integer.parseInt(currentSplittedLine[1]), Integer.parseInt(currentSplittedLine[2]));
						routeGraph.addRoute(route);
					}
					else{
						System.out.println("DONE READING !");
					}
				}
				lineNumber++;
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
		
		System.out.println(routeGraph.toString());
		
		routeGraph.displayAllRoutes();
		
		
		
		return routeGraph;
		
		
	}
}
