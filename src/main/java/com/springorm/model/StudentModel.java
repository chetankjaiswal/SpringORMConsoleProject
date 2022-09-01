package com.springorm.model;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class StudentModel 
{
	static Scanner scan=new Scanner(System.in);
	ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
    StudentDao studentDao= context.getBean("studentDao",StudentDao.class);
    
	public Integer addStudent()
	{
		Student student = new Student();
		
		System.out.println("Enter Student ID");
		student.setStudentId(scan.nextInt());
		System.out.println("Enter Student Name");
		scan.nextLine();
		student.setStudentName(scan.nextLine());
		scan.nextLine();
		System.out.println("Enter Student City");
		student.setStudentCity(scan.nextLine());
		return studentDao.insert(student);
	}

	public void getAllStudents() 
	{
	  List<Student> students = studentDao.getAllStudent();
	 if(students!=null)
	  for(Student student:students) 
	   {
		  System.out.println(student);
	   }
	 else {
		 System.out.println("No Record");
	 }

	}
	
	public void getStudent()
	{
	  System.out.println("Enter student Id");
	  try {
      Student student= studentDao.getStudent(scan.nextInt());
      if(student==null)
      System.out.println("student not exists with this id");
      else
      System.out.println(student);
	  }
	  catch (Exception e) {
		System.out.println("Enter valid numbers");
		scan.nextLine();
	 }
	}

	public void deleteStudent() 
	{
		 System.out.println("Enter student Id");
		  try {
    			 studentDao.deleteStudent(scan.nextInt());
		  }
		  catch (Exception e) {
			System.out.println("Enter valid numbers");
			scan.nextLine();
		 }
	}
	
	
	public void updateStudent() 
   {
		try {
		System.out.println("Enter Id to update student");
		int id=scan.nextInt();
		Student student= studentDao.getStudent(id);
	      if(student==null)
	      System.out.println("student not exists with this id");
	      else
	      	  {
				System.out.println("Enter Name");
				scan.nextLine();
				String name=scan.nextLine();
				System.out.println("Enter City");
			
				String city=scan.nextLine();
				Student newstudent=new Student(id,name,city);
				studentDao.updateStudent(newstudent);
	      	  }
		}
		catch (Exception e) {
			System.out.println("Enter valid number");
			scan.nextLine();
		}
	}
	
}
