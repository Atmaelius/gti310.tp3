package gti310.tp3.solver;

import java.util.ArrayList;
import java.util.Vector;
import gti310.tp3.data.*;

/**
 * Classe qui résolvera le problème de l'optimisation de route avec le graphe passée en paramètre
 * @author eric
 */

public class GraphSolver implements Solver<Graph, ResolutionTable>{
	
	ResolutionTable resTable = new ResolutionTable();
	
	/**
	 * Function to solve the problem at hand using dijkstra algorithm to find the shortest path to all the summits
	 */
	public ResolutionTable solve(Graph inputGraph) {

	// on initialise toutes nos structures
		resTable.initialise(inputGraph.getSummitsList());
		Vector<Integer> vectSommetsRestants = new Vector<Integer>();
		Vector<Integer> vectSommetsTraites = new Vector<Integer>();
		ArrayList<Route> routes = inputGraph.getRoutes();

		
	// etat initial
	// on ajoute tout les sommets le vecteur des sommets restants
		int sommetActuel = inputGraph.getStartPoint();
		vectSommetsRestants.addAll(inputGraph.getSummitsList());
		
	// initialiser le point de départ
		for (int i = 0; i < resTable.getSummitList().size(); i++) {
			if(sommetActuel == resTable.getSummitList().get(i)){
				resTable.getWeightList().set(i, 0);
			}
		}
		
		while (vectSommetsRestants.size() != 0) {
		// pour trouver tout les voisins du noeud actuel
			for (int j = 0; j < routes.size(); j++) {
				if(routes.get(j).getSource() == sommetActuel){
					for (int i = 0; i < resTable.getSummitList().size(); i++) {
						if(routes.get(j).getDestination() == resTable.getSummitList().get(i)){
							// on applique relaxer sur les voisins
							relaxer(sommetActuel, routes.get(j).getDestination(), routes.get(j).getWeight(),i);
						}
					}
				}
			}
			int indexSommetActuel = resTable.getCurrentSummitIndex(sommetActuel);
			vectSommetsRestants.remove((Integer)sommetActuel);
			vectSommetsTraites.add((Integer)sommetActuel);
			resTable.setVisitedAtIndex(indexSommetActuel, true);
			// on change le sommet actuel pour passer au prochain
			sommetActuel = resTable.getSummitFromSmallestWeight(vectSommetsRestants);
		}	
		
		return resTable;
	}
	
	/**
	 * 
	 * @param sommetActuel
	 * @param sommetDestination
	 * @param poid
	 * @param indexSommet
	 */
	private void relaxer(int sommetActuel, Integer sommetDestination, Integer poid, int indexSommet){

		int poidAuSommet = resTable.getWeightList().get(indexSommet);
		int sommePoid = resTable.getLineFromSummit(sommetActuel)[2] + poid;
		Integer[] array = new Integer[4];
		
		if(sommePoid < poidAuSommet){
			array = resTable.getLineFromSummit(sommetDestination);
			resTable.setWeightAtIndex(indexSommet, sommePoid);	
			resTable.setParentAtIndex(indexSommet, sommetActuel);
		}
	}
	
	
	public void showArray(Integer[] array){
		System.out.print("-> ");	
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
		System.out.println("");
	}
}
