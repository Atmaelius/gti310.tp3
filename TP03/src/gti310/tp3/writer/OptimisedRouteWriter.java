package gti310.tp3.writer;
/**
 * Classe qui va ecrire dans le fichier la route optimisee obtenue
 * @author eric
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import gti310.tp3.data.OptimisedRoute;
import gti310.tp3.data.Route;

public class OptimisedRouteWriter implements Writer<OptimisedRoute>{

	public void write(String outputFilename, OptimisedRoute outputRoute) {

		//modifié de http://www.mkyong.com/java/how-to-write-to-file-in-java-bufferedwriter-example/
		try{
			File file = new File(outputFilename);
			String tab = "\t\t";
			
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
	
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(String.valueOf(outputRoute.getStartPoint()) + "\n");
		/*	
			for (Route route : outputRoute.getRouteArray()) {
				System.out.println("writtenLine: "+ route.getDestination() + tab + route.getParent() + tab + route.getWeight());
				bw.write(route.getDestination() + tab + route.getParent() + tab + route.getWeight()+"\n");
			}
*/
			bw.close();
	
			System.out.println("SOLUTION A CET ENDROIT: " + outputFilename);
	
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
