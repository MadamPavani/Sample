package com.pawana.test;


import org.springframework.context.support.AbstractXmlApplicationContext ;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.pawana.bean.Student;
import com.pawana.dao.StudentDao;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao dao =  (StudentDao) context.getBean("stuDao");
		Student st = new Student();
		st.setSno(169);
		st.setSname("naveen");
		st.setSsal(5000);
		st.setSaddr("hyd");
		String status = dao.insertStudent(st);
		System.out.println(status);
		

	}

}
