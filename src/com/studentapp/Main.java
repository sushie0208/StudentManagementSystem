package com.studentapp;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("**************** Student Management System ****************");
		System.out.println("**************** Welcome ****************");

		Student s1 = new Student("Raj", 23, "S-1");
		s1.enrollCourse("Java");
		s1.printStudentInfo();
		Student s2 = new Student("Ria", 20, "S-2");
		s2.enrollCourse("DSA");
		s2.enrollCourse("dsa");
		s2.printStudentInfo();
		Student s3 = new Student("Rajni", 20, "S-3");
		s3.enrollCourse("Devops");
		s3.printStudentInfo();




	}

}
