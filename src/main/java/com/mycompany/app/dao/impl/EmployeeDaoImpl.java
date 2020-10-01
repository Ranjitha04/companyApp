package com.mycompany.app.dao.impl;




import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.app.dao.EmaployeeDao;
import com.mycompany.app.entity.Employee;
import com.mycompany.app.service.EmployeeService;


@Repository
public class EmployeeDaoImpl implements EmaployeeDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void saveEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = new ArrayList();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		empList = session.createQuery("from Employee").list();
		session.getTransaction().commit();
		session.close();
		return empList;
	}

}
