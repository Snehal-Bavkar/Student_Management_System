package edu.jsp.stud_management.controller;


import java.util.ArrayList;
import java.util.List;

import edu.jsp.stud_management.model.Student;
import edu.jsp.stud_management.view.Driver;

public class Controller {
	
     public static List<Student> checkExistingStudents(){
          ArrayList<Student> students = Driver.getBatch().getStudents();
          if(students == null){//List is yet to be created , meaning no list is created
             return null;
          }else{//List is created , but might or might not contains students
                  if(students.size()==0){//List exist but no students in the list
                      return null;
                   }else{//List Exists as well as some students in the List
                          return students;
                        }
          
               }  
    	 }
     
     public static boolean addStudent(Student student) {
    	 ArrayList<Student> students = Driver.getBatch().getStudents();
    	 if(students == null) {//List is yet to be created , meaning no list is created
    		 //We need to create list (in the batch) and add student in it
    		 ArrayList<Student> tempListOfStudent = new ArrayList<Student>();
    		 tempListOfStudent.add(student);
    		 Driver.getBatch().setStudents(tempListOfStudent);
    	 }else {//student list exist might or might not be empty in which we need to add student
    		 students.add(student);
    	 }
    	 if(Driver.getBatch().getStudents().size()!=0) {
    		 return true;
    	 }
    	 return false;
     }
     
     public static boolean addStudents(ArrayList<Student> students) {
    	 int countOfStudentsToBeAdded = students.size();
    	 int countOfStudentsAfterAdding =0;
    	 int countOfExistingStudents =0;
    	 ArrayList<Student> existingStudents = Driver.getBatch().getStudents();
    	 int size = existingStudents.size();
    	 if(existingStudents == null) {
    		 Driver.getBatch().setStudents(students);
    		 countOfStudentsAfterAdding =Driver.getBatch().getStudents().size();
    	 }else {
    		 countOfExistingStudents = Driver.getBatch().getStudents().size();
    		 Driver.getBatch().getStudents().addAll(students);
    		 countOfStudentsAfterAdding = Driver.getBatch().getStudents().size();
    	 }
    	 int finalExpectedCount = countOfExistingStudents +countOfStudentsToBeAdded;
    	 int diff = countOfStudentsAfterAdding - countOfStudentsToBeAdded;
    	 if(diff == 0 || countOfStudentsAfterAdding == finalExpectedCount) {
    		 return true;
    	 }
		return false; 
     }
     
     
     public static boolean removeStudent(int idToRemove) {
    	 ArrayList<Student> students = Driver.getBatch().getStudents();
    	 Student studentToRemove = null;
    	 for(Student student : students) {
    		 if(student.getId()==idToRemove) {
    			 studentToRemove = student;
    			 break;
    		 }
    	 }
    	 if(studentToRemove !=null) {
    		 Driver.getBatch().getStudents().remove(studentToRemove);
    		 return true;
    	 }
    	 return false;
     }
     
     public static boolean updateStudent(int idToUpdate, byte fieldToUpdate, Object fieldToUpdateValue) {
         ArrayList<Student> students = Driver.getBatch().getStudents();
         Student studentToUpdate = null;

         // Find the student with the given ID
         for (Student student : students) {
             if (student.getId() == idToUpdate) {
                 studentToUpdate = student;
                 break;
             }
         }

         // If the student is not found, return false
         if (studentToUpdate == null) {
             return false;
         }

         // Update the student's field based on the selection
         try {
             if (fieldToUpdate == 1) { // Update gender
                 studentToUpdate.setGen((Character) fieldToUpdateValue);
             } else { // Update name
                 studentToUpdate.setName((String) fieldToUpdateValue);
             }
             return true; // Return true if the update is successful
         } catch (Exception e) {
             // Handle any exceptions (e.g., invalid type casting)
             return false;
         }
     }
 
     
     public static boolean checkStudentExistById(int idToCheck) {
    	 ArrayList<Student> students = Driver.getBatch().getStudents();
    	 for(Student student:students) {
    		 if(student.getId()==idToCheck) {
    			 
    				 return true;
    			 }
    		 }
    		 return false;
    	 
     }
     

	   

}
