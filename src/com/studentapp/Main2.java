package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {
	private static List<Student> studentlist;
	public static void main(String[] args) {
		System.out.println("**************** Student Management System ****************");
		System.out.println("**************** Welcome ****************");
		studentlist = new ArrayList<Student>();
		Student s1 = new Student("Raj", 23, "S-1");
		s1.enrollCourse("Java");
		s1.printStudentInfo();
		Student s2 = new Student("Abhi", 20, "S-2");
		s2.enrollCourse("DSA");
		s2.printStudentInfo();
		Student s3 = new Student("Rajni", 20, "S-3");
		s3.enrollCourse("Devops");
		s3.printStudentInfo();
studentlist.add(s1);
studentlist.add(s2);
studentlist.add(s3);	

Student result ;
result= findStudentByID("S-2");
System.out.println("Result" +result);

sortByName();


	}
	
	private static void sortByName() {
		Comparator<Student> studentNameComparator = (o1,o2)-> o1.getName().compareTo(o2.getName());
		Collections.sort(studentlist, studentNameComparator);
		System.out.println(studentlist);
	}

	public static Student findStudentByID(String studentId)
	{
		Student result=null ;
		try {
		result= studentlist.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
		.findFirst()
		.orElseThrow(()-> new RuntimeException("No Data Found "));
		
	}
		catch(RuntimeException e)
		{
			System.err.println("Sudent with id " +studentId+ " Not found");
		}
		return result;
	}
}
