package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {
	private static List<Student> studentlist;
	public static void main(String[] args) {
		System.out.println("**************** Student Management System ****************");
		System.out.println("**************** Welcome ****************");
		studentlist = new ArrayList<Student>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Student Name");
		String name = scanner.next();
		System.out.println("You have entered the name "+name);
		
		System.out.println("Enter Student Age");
		int age = scanner.nextInt();
		System.out.println("Student Age is "+age);


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
