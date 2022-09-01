package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	//save the student object
	@Transactional
	public int insert(Student student)
	{
		 Integer i=0;
		try 
		{
		  i= (Integer)this.hibernateTemplate.save(student);
		}
		catch (Exception e) {
			System.out.println("Unable to save Student");
		}
		 return i;
	}
	
	//get the single student object
	public Student getStudent(int studentId)
	{
		Student student=null;
		try {
			student = this.hibernateTemplate.get(Student.class,studentId);	
		}
		catch (Exception e) {
			System.out.println("Unable to find student try again");
		}
		
		return student;
	}
	
	//get All student list
	public List<Student> getAllStudent()
	{
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		if(students.isEmpty()) 
		return null;
		else
		return students;
	}
	
	//deleting the student object
	@Transactional
	public void deleteStudent(int studentId)
	{
		Student student = this.hibernateTemplate.get(Student.class,studentId);
		try {
			this.hibernateTemplate.delete(student);
			System.out.println("student deleted successfully");
		} catch (Exception e) {
		   System.out.println("Student Doest exists or unable to delete");
		}
		
	}
	
	//updating student object  
	@Transactional
	public void updateStudent(Student student)
	{
		this.hibernateTemplate.update(student);
	}
	
	
}
