package gti310.tp3.solver;
/**
 * Classe qui résolvera le problème de l'optimisation de route avec le graphe passée en paramètre
 * @author eric
 */
import gti310.tp3.data.Graph;
import gti310.tp3.data.OptimisedRoute;

public class GraphSolver implements Solver<Graph, OptimisedRoute>{

	
	@Override
	public OptimisedRoute solve(Graph inputGraph) {
		
		OptimisedRoute optRoute = new OptimisedRoute();
	
		// point de depart de la solution sera le point de depart de la premiere route
		optRoute.setStartPoint(inputGraph.getRoutes().get(0).getParent());
		for (int i = 0; i < inputGraph.getNbOfRoutes(); i++) {
			optRoute.addRoute(inputGraph.getRoutes().get(i));
		}
			
		return optRoute;
	}



}