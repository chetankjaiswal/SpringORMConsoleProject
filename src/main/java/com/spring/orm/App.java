package com.spring.orm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import com.springorm.model.StudentModel;

public class App 
{
	static StudentModel studentModel= new StudentModel();
    public static void main( String[] args )
    {
        ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao= context.getBean("studentDao",StudentDao.class);
//        Student student=new Student(777,"chetan jaiswal","Rustampur");
//        int r=studentDao.insert(student);
//        System.out.println("row inserted "+r);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean on=true;
        
        while(on)
        {
         System.out.println("1.Add student");
         System.out.println("2.Display all students");
         System.out.println("3.Get single Student");
         System.out.println("4.Delete student");
         System.out.println("5.Update Student");
         System.out.println("6.exit");
        
         try 
         {
		    	Integer choice= Integer.parseInt(br.readLine());
		    	switch(choice)
		    	{
			    	case 1:
			    		//Add Student
			    		 if(studentModel.addStudent()!=0)
			    		 {
			    		  System.out.println("student added successfully");
			    		 }
			    		break;
			    		
			    	case 2:
			    		//get All Students
			    		 studentModel.getAllStudents();
			    		break;
			    	case 3:
			    		//getSingle student
			    		 studentModel.getStudent(); 
			    		break;
			    	case 4:
			    		//Delete student
			    		 studentModel.deleteStudent();
			    		break;
			    	case 5: 
			    		//Update student
			    		studentModel.updateStudent();
			    		break;
			    	case 6:
			    		//exit
			    		on=false;
			    		System.out.println("---------Thanks you--------");
			    		break;
			    		
		    	}
		 } 
         catch (Exception e) 
         {
			System.out.println("------Enter correct choice----");
		 }
        
       }
        
    }
}
