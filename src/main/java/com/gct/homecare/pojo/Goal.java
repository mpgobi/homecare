package com.gct.homecare.pojo;

public class Goal {

	private int patientID;
	private int goalID;
	private String goal;
	
	public Goal(){
		
	}
	
	public Goal(int patientID,int goalID,String goal){
		this.patientID = patientID;
		this.goalID = goalID;
		this.goal =goal;
	}
	
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public int getGoalID() {
		return goalID;
	}
	public void setGoalID(int goalID) {
		this.goalID = goalID;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
}
