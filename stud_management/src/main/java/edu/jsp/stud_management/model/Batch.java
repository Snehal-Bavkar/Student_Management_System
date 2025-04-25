package edu.jsp.stud_management.model;

import java.util.ArrayList;

public class Batch {
	
	private String batchCode;
	private String subject;
	private String trainer;
	
	private ArrayList<Student> students = new ArrayList();
	
	public ArrayList<Student> getStudents(){
		return students;
	}
	
	public void setStudents(ArrayList<Student> students){
		 this.students = students;
	}
	
	public String getBatchCode() {
		return batchCode;
	}
	
	public void setBatchCode(String batchCode) {
		  this.batchCode= batchCode;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		  this.subject= subject;
	}
	
	
	public String getTrainer() {
		return trainer;
	}
	
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

}
