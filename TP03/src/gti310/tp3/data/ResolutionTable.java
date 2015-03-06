package gti310.tp3.data;

import java.util.ArrayList;


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
	
	
	public void initialise(ArrayList<Integer> enteredSummitList){
		summitList = enteredSummitList;
		for (int i = 0; i < summitList.size(); i++) {
			parentList.add(null);
			weightList.add(INFINI);
			visitedList.add(false);
		}
	}

}
