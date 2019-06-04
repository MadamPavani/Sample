package com.pawana.dao;

import javax.transaction.Transactional;


import org.springframework.orm.hibernate4.HibernateTemplate;


import com.pawana.bean.Student;

public class StudentDaoImpl implements StudentDao {
	
	String status = "";
	private HibernateTemplate hibernatetemplate;
	
	
    public HibernateTemplate getHibernateTemplate() {
		return hibernatetemplate;
	}

	public void setHibernatetemplate(HibernateTemplate hibernatetemplate) {
		this.hibernatetemplate = hibernatetemplate;
	}

	@Transactional
	@Override
	public String insertStudent(Student bean) {
		// TODO Auto-generated method stub
		Integer in = (Integer)hibernatetemplate.save(bean);
		if(in == bean.getSno()) {
			status = "success";
		}else {
			status = "failure";
		}
		return status;
	}

}
