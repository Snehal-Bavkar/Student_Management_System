package edu.jsp.stud_management.model;

public class Student {
private int id;

public Student(int id, String name, char gen) {
    this.id = id;
    this.name = name;
    this.gen = gen;
}
	
	public Student() {
	
}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}

	public char getGen() {
		return gen;
	}
	public void setGen(char gen) {
		this.gen=gen;
	}

	 private String name;
	 private char gen;

}
