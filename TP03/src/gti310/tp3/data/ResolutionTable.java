package gti310.tp3.data;

import java.util.ArrayList;
import java.util.Vector;

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

	public void setSummitList(ArrayList<Integer> summitList) {
		this.summitList = summitList;
	}

	public ArrayList<Integer> getParentList() {
		return parentList;
	}

	public void setParentList(ArrayList<Integer> parentList) {
		this.parentList = parentList;
	}

	public ArrayList<Integer> getWeightList() {
		return weightList;
	}

	public void setWeightList(ArrayList<Integer> weightList) {
		this.weightList = weightList;
	}

	public ArrayList<Boolean> getVisitedList() {
		return visitedList;
	}

	public void setVisitedList(ArrayList<Boolean> visitedList) {
		this.visitedList = visitedList;
	}
	
	/**
	 * Function to initialise the ResolutionTable to start working on the problem
	 * @param enteredSummitList A list of the graphs summits 
	 */
	public void initialise(ArrayList<Integer> enteredSummitList){
		summitList = enteredSummitList;
		for (int i = 0; i < summitList.size(); i++) {
			parentList.add(null);
			weightList.add(INFINI);
			visitedList.add(false);
		}
	}
	
	/**
	 * Utility function to show the content of the ResolutionTable
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
	
	

	public Integer[] getLineFromIndex(int sommet){
		
		int valeurIntBool = 0;
		boolean valeur = visitedList.get(sommet);
		Integer[] array = new Integer[4];
		
		if(valeur){
			valeurIntBool = 1;
		}
		array[0] = summitList.get(sommet);
		array[1] = parentList.get(sommet);
		array[2] = weightList.get(sommet);
		array[3] = valeurIntBool;
		
		return array;
	}
	
	
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
	
	
	public void setWeightAtIndex(int index, int weight){
		weightList.set(index, weight);
	}
	
	public void setVisitedAtIndex(int index, boolean visited){
		visitedList.set(index, visited);
	}
	
	public void setParentAtIndex(int index, int parent){
		parentList.set(index, parent);
	}
	
	public int getSummitFromSmallestWeight(Vector<Integer> vectSommetsRestants){
		
		int smallest = getMinNonVisitedValue(weightList);
		int index = -1;
		
		for (int i = 0; i < weightList.size(); i++) {
/*
			if(visitedList.get(i) == false){
				System.out.println("***************************************************");
			}
			System.out.println("------------------------------------------------"+visitedList.size());
	*/
			/*
			System.out.println("SMALLEST: " + smallest);
			System.out.println("WEIGHT: " + weightList.get(i) + "; VISITED: " + visitedList.get(i));
			System.out.println(summitList.get(i));
*/
			if((weightList.get(i) == smallest) && (visitedList.get(i) == false)){
				return summitList.get(i);
			}
			
		}
		return index;			
	}
	
	
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
		int minValue = 99999999;  
		for(int i = 0; i < list.size(); i++){  
			if(!(list.get(i) == 0)){
				if((list.get(i) < minValue) && (visitedList.get(i) == false)){  
					minValue = list.get(i);  
				}  
			}
		}  
		return minValue;  
	}  
	
}
