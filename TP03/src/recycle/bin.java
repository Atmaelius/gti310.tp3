package recycle;

public class bin {

	/**
	 * Classe qui résolvera le problème de l'optimisation de route avec le graphe passée en paramètre
	 * @author eric
	 */
	/*
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Vector;

	import gti310.tp3.data.Graph;
	import gti310.tp3.data.OptimisedRoute;
	import gti310.tp3.data.ResolutionTable;
	import gti310.tp3.data.Route;


	public class GraphSolver implements Solver<Graph, OptimisedRoute>{


		
		// faire nouvel objet de stockage pour la sortie
		
		@Override
		public OptimisedRoute solve(Graph inputGraph) {

			ResolutionTable resolve = new ResolutionTable();
			
			
			Vector<Integer> vectSommetsTraites = new Vector<Integer>();
			Vector<Integer> vectSommetsRestants = new Vector<Integer>();

			int nbOfSummits = inputGraph.getNbOfSummits();
			int arrayDistances[] = new int[nbOfSummits];
			int arrayParent[] = new int[nbOfSummits];
			int sommetActuel = inputGraph.getStartPoint();
			int sommeDistance = 0;
			int distanceMin = 0;
			Integer pointDepart = inputGraph.getStartPoint();

			ArrayList<Route> routes = inputGraph.getRoutes();
			vectSommetsRestants.addAll(inputGraph.getSummitsList());
			Vector<Integer> vectSommets = (Vector<Integer>) vectSommetsRestants.clone();
			
			resolve.initialise(inputGraph.getSummitsList());

			
			
			
			
	// Debut de dijkstra
			// ITERATION 1
			// La première distance, du sommet initial vers sommet initial =0;l
			arrayDistances[0] = 0;
			
			// retirer le sommet de départ du vecteur des sommets restants
			if(vectSommetsRestants.contains(pointDepart)){
				vectSommetsRestants.remove(pointDepart);
			}
			
			// ajouter le sommet de départ au array de sommets traités
			vectSommetsTraites.add(pointDepart);
			System.out.println("Vecteur sommets traités: ");
			System.out.println(vectSommetsTraites);
			
			// ajouter toutes les distances du pt de depart vers pt destination dans arrayDistances
			// ajouter les sommets parents aux points ayant des distances
			for (int j = 0; j < routes.size(); j++) {
				if(routes.get(j).getSource() == pointDepart){
					for (int i = 0; i < vectSommets.size(); i++) {
						if(routes.get(j).getDestination() == vectSommets.get(i)){
							arrayDistances[i] = routes.get(j).getWeight();
							arrayParent[i] = routes.get(j).getSource();
						}
					}
				}
			}
			
			// changer la valeur en cours par le sommet ayant la plus petite distance 
			// && qui est encore dans le liste des sommets restants
			
				// trouver la plus petite distance différente de zero
				distanceMin = getMinValue(arrayDistances);
				
				// la somme des distances totales est mise a jour
				sommeDistance = distanceMin;
				
				System.out.println("VALEUR MIN !: " + distanceMin);
				System.out.println("sommet actuel: " + sommetActuel);

				// retrouver quel sommet possede la distance minimum avec le parent donné
				for (int k = 0; k < routes.size(); k++) {
					if((routes.get(k).getSource() == pointDepart) && (routes.get(k).getWeight() == distanceMin)){
						sommetActuel = routes.get(k).getDestination();
					}
				}
				printForAnthony(arrayDistances, arrayParent);

	// ITERATION 2	
		System.out.println(" ---- FIN ITERATION ---- ");
				
				System.out.println("sommet actuel: " + sommetActuel);
				
				vectSommetsRestants.remove((Object) sommetActuel);
				System.out.println("Vecteur sommets Restants: ");
				System.out.println(vectSommetsRestants);
				
				vectSommetsTraites.add(sommetActuel);
				System.out.println("Vecteur sommets traités: ");
				System.out.println(vectSommetsTraites);
				
				// trouver les voisins du sommet actuel
				
				for (int j = 0; j < routes.size(); j++) {
					if(routes.get(j).getSource() == sommetActuel){
						for (int i = 0; i < vectSommets.size(); i++) {
							if(routes.get(j).getDestination() == vectSommets.get(i)){
								
							//	arrayDistances[i] = routes.get(j).getWeight();
							//  arrayParent[i] = routes.get(j).getSource();
								System.out.println("Sommet: " + routes.get(j).getDestination());
								System.out.println("Distance: " + routes.get(j).getWeight());

								
							}
						}
					}
				}
				
				
				
				
				
				
				
			printForAnthony(arrayDistances, arrayParent);
			
			return null;
	}
		
		
		
		

		// Adapté depuis: http://stackoverflow.com/questions/18525474/java-minimum-and-maximum-values-in-array
		public static int getMinValue(int[] array){  
			int minValue = 99999999;  
			for(int i = 0; i < array.length; i++){  
				if(!(array[i] == 0)){
					if((array[i] < minValue)){  
						minValue = array[i];  
					}  
				}
			}  
			return minValue;  
		}  
		
		
		public void printForAnthony(int[] arrayDistance, int[] arrayParent){
			System.out.println("Print for Anthony");
			System.out.print("[");
			for (int i = 0; i < arrayDistance.length; i++) {
				System.out.print(arrayDistance[i] + ", ");
			}
			System.out.print("]");
			System.out.println();
			System.out.print("[");

			for (int i = 0; i < arrayParent.length; i++) {
				System.out.print(arrayParent[i] + ", ");
			}
			System.out.print("]");
			System.out.println();

		}

	}




	// selectionner un point puis afficher tout ses voisins
	/*
	System.out.println("NOS ROUTES");
	for (Route route : routes) {
		// si le pt source = pt depart; get les voisins du point
		if(route.getSource() == pointDepart){
			System.out.println(route.getDestination());
			System.out.println(route.getWeight());
		} 
	}

	*/		

	/*
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
	*/
	
}
