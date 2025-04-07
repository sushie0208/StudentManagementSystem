package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static List<Student> studentlist;
private static Scanner scanner;
	public static void main(String[] args) {
		System.out.println("**************** Student Management System ****************");
		
		
		studentlist = new ArrayList<Student>();
		Scanner scanner = new Scanner(System.in);
		while(true)
		{
		System.out.println("**************** Welcome ****************");
		System.out.println("Select an option");
		System.out.println("1. Register a Student ");
		System.out.println("2. Find Student with StudentId ");
		System.out.println("3. List All Student Information ");
		System.out.println("4. List Student Information is sorted order  ");
		System.out.println("5. Exit ");
		int option = scanner.nextInt();
		
		switch (option)
		{
		case 1 : enrollStudent(scanner);
		         break;
		         
		case 2 : findStudentById(scanner);
		         break;
		
		case 3 : printAllStudentData();
		         break;
		         
		case 4 : sortByName();         
		         break;
		         
		case 5 : exit();
		          break;
		          
		default : System.out.println("Invalid Option selected .....Enter between 1-5");
		}
		}
//		Student result = findStudentByID("S-2");
//		System.out.println("Result" + result);
//
//		sortByName();

	}

	private static void exit() {
		System.exit(0);
		
	}

	private static void printAllStudentData() {
		if(studentlist.size()>0)
		{
		System.out.println("===================Print All Student Data===================");
		for (Student student : studentlist) {
			student.printStudentInfo();
		}
		}
		else
		{
			System.err.println("Student list is empty , Please add data");
		}
	}

	private static void findStudentById(Scanner scanner2) {
		Student studentFound = null;
		System.out.println("Enter the Student ID");
		String studentId = scanner2.next();
		try {
			studentFound = studentlist.stream().filter(student -> student.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No Data Found "));

		} catch (RuntimeException e) {
			System.err.println("Student with id " + studentId + " Not found");
		}
		studentFound.printStudentInfo();
		
	}

	private static void enrollStudent(Scanner scanner2) {
		System.out.println("Enter Student Name ");
		String studentName = scanner2.next();
		
		System.out.println("Enter Student Age");
		int studentAge = scanner2.nextInt();
		
		System.out.println("Enter Student Id");
		String studentId = scanner2.next();
		
		Student newStudent = new Student(studentName, studentAge, studentId);
		studentlist.add(newStudent);
		while(true)
		{
		System.out.println("Enter the course to be enrolled....Type Done to exit ");
		String courseName = scanner2.next();
		if(courseName.equalsIgnoreCase("Done"))
		{
			break;
		}
		else
		{
		newStudent.enrollCourse(courseName);
		}
		}
		newStudent.printStudentInfo();
	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
		Collections.sort(studentlist, studentNameComparator);
		printAllStudentData();
	}

	public static Student findStudentByID(String studentId) {
		Student result = null;
		try {
			result = studentlist.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No Data Found "));

		} catch (RuntimeException e) {
			System.err.println("Sudent with id " + studentId + " Not found");
		}
		return result;
	}
}
