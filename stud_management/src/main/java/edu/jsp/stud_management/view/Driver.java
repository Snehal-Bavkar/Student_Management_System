package edu.jsp.stud_management.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.jsp.stud_management.controller.Controller;
import edu.jsp.stud_management.model.Batch;
import edu.jsp.stud_management.model.Student;

public class Driver {

	static Scanner userInput = new Scanner(System.in);
	private static Student stud = new Student();
	private static Batch batch = new Batch();
	
	public static Batch getBatch() {
		return batch;
	}
	
	public static void setBatch(Batch batch) {
		Driver.batch= batch;
	}
	static {
		System.out.println("-------------Welcome--------------");
	}
	static {
		System.out.print("Enter batch code : ");
		batch.setBatchCode(userInput.nextLine());
		System.out.print("Enter Subject name : ");
		batch.setSubject(userInput.nextLine());
		System.out.print("Enter trainer name : ");
		batch.setTrainer(userInput.nextLine());
		System.out.println();
		
	}

	public static void main(String[] args) {
		do {
			System.out.println("Main Menu : ");
			System.out.println("1.Check Existing Students  ");
			System.out.println("2.Add Student");
			System.out.println("3.Add students\n4.Remove student  ");
			System.out.println("5.Update Student\n0.Exit");
	                System.out.print("Enter Num. respective to desired option : ");
	                byte userChoice = userInput.nextByte();
                userInput.nextLine();
                
                switch(userChoice) {
                    case 1: 
                    	checkExistingStudents();
                    	System.out.println();
                    	break;
                    
                    case 2:
                        if(Controller.addStudent(userInputForStudent())){
                           System.out.println("Student added successfully");
                        }else {
                        	 System.out.println("Unable to add student!");
                        }
                        System.out.println();
                        break;
                        
                    case 3:
                    	ArrayList<Student> studentsToAdd = new ArrayList<Student>();
                    	do {
                    		System.out.println("Provide student details");
                    		Student studentObjectToAdd = userInputForStudent();
                    		studentsToAdd.add(studentObjectToAdd);
                    	}while(toContinueAddingStudents());
//                    	System.out.println(studentsToAdd);//TEST
                    	if(Controller.addStudents(studentsToAdd)) {
                    		System.out.println("Students added successfully!");
                    	}else {
                    		System.out.println("Unable to add student!");
                    	}
                    	System.out.println();
                    	break;
                    	
                    case 4:
                        boolean checkExistingStudents =  checkExistingStudents();
                        if(checkExistingStudents){
                            System.out.print("Enter id of the student to be removed :");
                            int idToRemove = userInput.nextInt();
                            userInput.nextLine();
                            if(Controller.removeStudent(idToRemove)) {
                            	System.out.println("Removed!");
                            }else {
                            	System.out.println("Not Removed!");
                            }
                        }else{
                        	System.out.println("Remove operation can not be performed!");  
                        }
                        System.out.println();
                       break;
                       
                    case 5:
                    	if(checkExistingStudents()) {
                    		int idToUpdate = 0;
                    		do {
                    			System.out.println("Enter id of student you want to update :");
                    			idToUpdate=userInput.nextInt();
                    			userInput.hasNextLine();
                    		}while(!Controller.checkStudentExistById(idToUpdate));
                    		System.out.println("Press 1: to update gender\npress 2: to update name");
                    		byte fieldUpdateSelection = userInput.nextByte();
                    		userInput.nextLine();
                    		
                    		switch(fieldUpdateSelection) {
                    		case 1:
                    			char updatedGender ;   
                    			while (true) {
                    	            System.out.print("Enter gender to update(m/f):");
                    	            updatedGender = userInput.next().toLowerCase().charAt(0); 
                    	            if (updatedGender == 'm' || updatedGender == 'f') {
                    	                break; 
                    	            } else {
                    	                System.out.println("Invalid input! Gender must be 'm' or 'f'. Please try again.");
                    	            }
                    	        }
                    			userInput.nextLine();
                    			if(Controller.updateStudent(idToUpdate,fieldUpdateSelection,updatedGender)) {
                    				System.out.println("Student gender updated successfully");
                    			}else {
                    				System.out.println("Unable to update ");
                    			}
                    			break;
                    			
                    		case 2:
                    			System.out.println("Enter name to update :");
                    			String updatedName = userInput.nextLine();   
                    			userInput.nextLine();
                    			if(Controller.updateStudent(idToUpdate,fieldUpdateSelection,updatedName)) {
                    				System.out.println("Student name updated successfully");
                    			}else {
                    				System.out.println("Unable to update ");
                    			}
                    			break;
                    			
                    		default:
                    			break;
                    		}
                    	}else {//students do not exist , update operation can not  be performed
                    		System.out.println("update operation can not  be performed");
                    		
                    	}
                    	break;
                       
                       
                    case 0:
                        System.out.println("---------EXIT------------");
                        userInput.close();
                        System.exit(0);
                    break;
                    
                    
                      
                    default:
                        System.out.println("INVALID SELECTION OF OPTION");
                    break;
                }       
	}while (true);
}
		
		public static Student userInputForStudent() {
			System.out.print("Enter id : ");
			int id = userInput.nextInt();
			userInput.nextLine();
			System.out.print("Enter name : ");
			String name = userInput.nextLine();
			char gen ;
			while (true) {
	            System.out.print("Enter Gender (m/f): ");
	            gen = userInput.next().toLowerCase().charAt(0); 
	            if (gen == 'm' || gen == 'f') {
	                break; 
	            } else {
	                System.out.println("Invalid input! Gender must be 'm' or 'f'. Please try again.");
	            }
	        }

			return new Student(id,name, gen);  	
		}
		
		public static boolean toContinueAddingStudents() {
			System.out.print("Continue adding students ? y/n :");
			char userChoice = userInput.next().charAt(0);
			if(userChoice == 'y' || userChoice == 'Y') {
				return true;
			}
			return false;
		}
		
		public static void displayStudents(List<Student> students) {
			System.out.println("===========================================");
			System.out.printf("|%-10s| %-20s| %-5s|\n", "ID","Name","Gen");
			System.out.println("===========================================");
			
			for(Student student : students) {
				System.out.printf("|%-10s| %-20s| %-5s|\n",student.getId(),student.getName(),student.getGen());
			}
			System.out.println("===========================================");
		}
		
		public static boolean checkExistingStudents(){
			List<Student> checkExistingStudents= Controller.checkExistingStudents();
			if(checkExistingStudents == null) {
				System.out.println("No student Exist in batch");
				return false;
			}else {
				System.out.println("Students Exist");
				System.out.println(checkExistingStudents);
				displayStudents(checkExistingStudents);
				return true;
			}
		}

}

	

