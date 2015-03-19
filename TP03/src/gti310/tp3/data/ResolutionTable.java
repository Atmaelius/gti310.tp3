package gti310.tp3.data;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Classe qui représente une table permettant d'effectuer les calculs pour la résolution du graphe
 * @author eric
 */

public class ResolutionTable {

	public final static int INFINI = 999999999;
	public ArrayList<Integer> summitList;
	public ArrayList<Integer> parentList;
	public ArrayList<Integer> weightList;
	public ArrayList<Boolean> visitedList;
	
	public ResolutionTable() {
		summitList = new ArrayList<Integer>();
		parentList = new ArrayList<Integer>();
		weightList = new ArrayList<Integer>();
		visitedList = new ArrayList<Boolean>();
	}

	public ResolutionTable(ArrayList<Integer> summitList,
			ArrayList<Integer> parentList, ArrayList<Integer> weightList,
			ArrayList<Boolean> visitedList) {
		super();
		this.summitList = summitList;
		this.parentList = parentList;
		this.weightList = weightList;
		this.visitedList = visitedList;
	}

	public ArrayList<Integer> getSummitList() {
		return summitList;
	}

	public ArrayList<Integer> getParentList() {
		return parentList;
	}
	
	public ArrayList<Integer> getWeightList() {
		return weightList;
	}
	
	/**
	 * Function to initialise the ResolutionTable to start working on the problem
	 * @param enteredSummitList A list of the graphs summits 
	 */
	public void initialise(ArrayList<Integer> enteredSummitList){
		summitList = enteredSummitList;
		for (int i = 0; i < summitList.size(); i++) {
			parentList.add(-1);
			weightList.add(INFINI);
			visitedList.add(false);
		}
	}
	
	/**
	 * Utility function to directly print the content of the ResolutionTable
	 */
	public void printContent(){
		System.out.println("");
		for (int i = 0; i < summitList.size(); i++) {
			System.out.print(summitList.get(i) + ",");
			System.out.print(parentList.get(i) + ",");
			System.out.print(weightList.get(i) + ",");
			System.out.print(visitedList.get(i));
			System.out.println();
		}
	}

	/**
	 * Function that returns a resolutionTable line's information chosen by index 
	 * @param index	the wanted index of the line
	 * @return array	an array containing the values of the chosen line
	 */
	public Integer[] getLineFromIndex(int index){
		
		int valeurIntBool = 0;
		boolean valeur = visitedList.get(index);
		Integer[] array = new Integer[4];
		
		if(valeur){
			valeurIntBool = 1;
		}
		array[0] = summitList.get(index);
		array[1] = parentList.get(index);
		array[2] = weightList.get(index);
		array[3] = valeurIntBool;
		
		return array;
	}
	
	/**
	 * Fonction that returns the chosen summit's line of information
	 * @param the summit of reference
	 * @return array an array containing the values of the chosen line
	 */
	public Integer[] getLineFromSummit(int sommet){
		
		int newIndex = -1;
		int valeurIntBool = 0;
		Integer[] array = new Integer[4];
		
		for (int i = 0; i < summitList.size(); i++) {
			if(summitList.get(i) == sommet){
				newIndex = i;
				boolean valeur = visitedList.get(newIndex);
				if(valeur){
					valeurIntBool = 1;
				}
				array[0] = summitList.get(newIndex);
				array[1] = parentList.get(newIndex);
				array[2] = weightList.get(newIndex);
				array[3] = valeurIntBool;
			}
		}
		return array;
	}
	
	/**
	 * Function that returns the summit that has the smallest weight and that is not set as visited from a vector of summits names
	 * @param vectSommetsRestants vector of summits to search into
	 * @return summit (int) the summit that was found, returns -1 if none was found
	 */
	public int getSummitFromSmallestWeight(Vector<Integer> vectSommetsRestants){
		int smallest = getMinNonVisitedValue(weightList);
		int summit = -1;
		
		for (int i = 0; i < weightList.size(); i++) {
			if((weightList.get(i) == smallest) && (visitedList.get(i) == false)){
				return summitList.get(i);
			}
		}
		return summit;			
	}
	
	/**
	 * Function that returns the index of the collection containing the chosen summit
	 * @param summitName the summit to be searched
	 * @return the index of the summit, if not found returns -1
	 */
	public int getCurrentSummitIndex(int summitName){
		int indexTrouve = -1;
		
		for (int i = 0; i < summitList.size(); i++) {
			if(summitList.get(i).intValue() == summitName){
				indexTrouve = i;
			}
		}
		return indexTrouve;
	}
	
	
	/**
	 * Returns the smallest value contained in a given array
	 * @param array A given array
	 * @return minValue The smallest value contained in the array
	 */
	// Adapté depuis: http://stackoverflow.com/questions/18525474/java-minimum-and-maximum-values-in-array
	public int getMinNonVisitedValue(ArrayList<Integer> list){  
		int minValue = INFINI;  
		for(int i = 0; i < list.size(); i++){  
			if(!(list.get(i) == 0)){
				if((list.get(i) < minValue) && (visitedList.get(i) == false)){  
					minValue = list.get(i);  
				}  
			}
		}  
		return minValue;  
	}

	
	public void setWeightAtIndex(int index, int weight){
		weightList.set(index, weight);
	}
	
	public void setVisitedAtIndex(int index, boolean visited){
		visitedList.set(index, visited);
	}
	
	public void setParentAtIndex(int index, int parent){
		parentList.set(index, parent);
	}
	
	
	/* fonction utilisées dans l'écriture dans le fichier */ 
	
	/**
	 * Function that returns the a formatted string of the ResolutionTable to be written directly to the file
	 * @param i the number of the line to be returned
	 * @return a string to be written to the file
	 */
	public String printLineToWrite(int i){
		String tab = "\t";
		String endline = "\n";
		return getSummitList().get(i) + tab + getParentList().get(i) + tab + getWeightList().get(i) + endline;
	}
	
	/**
	 * Function that returns the startPoint of the solved resolutionTable
	 * @return the starting point of the solution, returns -1 if no startpoint could be found
	 */
	public Integer getStartPoint() {
		for (int i = 0; i < summitList.size(); i++) {
			if(parentList.get(i) == -1){
				return summitList.get(i);
			}
		}
		return -1;
	}  
	
}
