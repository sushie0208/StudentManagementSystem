package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

	private String name;
	private int age;
	private String studentId;
	List<String> courses;
	
	public Student(String name, int age, String studentId) {
		if (validateAge(age) && validateName(name) && validateId(studentId))
		{
		this.name = name;
		this.age = age;
		this.studentId = studentId;
		courses = new ArrayList<String>();
	}
	}
	
	public void enrollCourse(String course)
	{
		if(validateCourseName(course))
		{
		if(!courses.contains(course))
		{
		courses.add(course);
		System.out.println(course+" Added to Student Successfully");
		}
		
		else
		{
		System.err.println("Student is already enrolled to the course " +course);
		}
	}
	}
	public void printStudentInfo()
	{
		System.out.println("================== Student Information==================");
		System.out.println("Student Name = "+name);
		System.out.println("Student Age = "+age);
		System.out.println("Student Id = "+studentId);
		System.out.println("Courses " +courses);

	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}
	
	
	//VALIDATION METHODS
	
	public boolean validateAge(int age)
	{
		if(age<25 && age>18)
		{
			return true;
		}
		else
		{
			System.err.println("Please enter Valid Age");
			return false;
		}
	}
	
	public boolean validateName(String name)
	{
		if(name==null || (name.isEmpty()))
		{
			
			System.err.println("Name cannot be Blank ");
			return false;
			
		}
			else{
			String nameregex = "^[a-zA-Z\\s]+$";
			Pattern namePattern = Pattern.compile(nameregex);
			Matcher nameMatcher = namePattern.matcher(name);
			if(nameMatcher.matches())
			{
				return true;
			}
			else
			{
				System.err.println("Please enter Valid Name with Aphabets only ");
				return false;
				
			}
		}
		}
		
	
	public boolean validateId(String studentId)
	{
	if(studentId==null || (studentId.isEmpty()))
	{
		throw new IllegalArgumentException("Student id cannot be Blank");
	}
	else
	{
		String studentIdRegex = "S-\\d+$";
		Pattern studentIdPattern = Pattern.compile(studentIdRegex);
		Matcher studentIdMatcher = studentIdPattern.matcher(studentId);
		if(studentIdMatcher.matches())
		{
			return true;
		}
		else
		{
			System.err.println("Please enter Valid ID");
			return false;
		}
	}
	}
	
	public boolean validateCourseName(String course)
	{
		if(course.equalsIgnoreCase("Java")|| (course.equalsIgnoreCase("DSA")||(course.equalsIgnoreCase("Devops"))))
		{
			return true;
			
		}
		else
		{
			System.err.println("Please select course from List {JAVA , DSA, DEVOPS}");
			return false;
			
		}
	}
	
	//Getters 

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}	
	
	
}