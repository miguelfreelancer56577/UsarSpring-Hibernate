/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.packt.Spring.chapter7.springmvc.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.packt.Spring.chapter7.springmvc.model.Employee;
import org.packt.Spring.chapter7.springmvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SPPDF
 */
@Repository
@Transactional(readOnly = true)
public class EmployeeDaoImpl implements EmployeeService{
    @Autowired
    private SessionFactory sessionFactory;
    
//    public EmployeeDaoImpl() {
//        
//    }
    
    @SuppressWarnings("unchecked")
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.openSession();
        
//        with HQL
        String hql = "FROM Employee";
//        String hql = "FROM Employee as e";
//        String hql = "select e.firstName FROM Employee as e";
//        String hql = " FROM Employee as e WHERE e.firstName='RAVI'";
//        String hql = "FROM Employee E order by E.firstName DESC";
//        String hql = "FROM Employee E order by E.firstName ASC, E.id desc";
//        String hql = "SELECT SUM(E.salary) FROM Employee E GROUP BY E.firstName";
//        String hql = "FROM Employee E WHERE E.firstName = :employee_firstName";
        Query query = session.createQuery(hql);
//        query.setParameter("employee_firstName", "ravi");
        List<Employee> emList = query.list();
        
//        with HCQL
//        Criteria criteria = session.createCriteria(Employee.class);
//        List<Employee> emList = criteria.list();
        
        return emList;
    }
    @SuppressWarnings("unchecked")
    public List<Employee> criteriaEmployees() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Employee.class);
        Criterion salary = Restrictions.eq("salary", 4000);
        Criterion firstName = Restrictions.like("firstName","RAVI");
//        LogicalExpression andExp = Restrictions.and(salary, firstName);
        LogicalExpression andExp = Restrictions.or(salary, firstName);
        criteria.add(andExp);
//        criteria.add(Restrictions.eq("salary", 4000));
//        criteria.add(Restrictions.between("salary", 1000,4000));
        List<Employee> emList = criteria.list();
        
        return emList;
    }
    
    
    @SuppressWarnings("unchecked")
    public List<Employee> pagEmployee(int start, int end){
        Session session = sessionFactory.openSession();
        String hql = "from Employee";
        Query query = session.createQuery(hql);
        query.setFirstResult(start);
        query.setMaxResults(end);
        return query.list();
    }
    @Transactional(readOnly = false)
    public void insertEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        session.save(employee);
    }
    
    @Transactional(readOnly = false)
    public int updateEmployee(Employee employee){
        Session session = sessionFactory.openSession();
        String hql = "update Employee e set e.firstName=:name where id=:id";
        Query query = session.createQuery(hql);
        query.setParameter("name", employee.getFirstName());
        query.setParameter("id", employee.getId());
        int result = query.executeUpdate();
        return result;
    }
    
    @Transactional(readOnly = false)
    public int deleteEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        String hql = "delete Employee e where e.id=:id";
        Query query = session.createQuery(hql);
        query.setParameter("id", employee.getId());
        int result = query.executeUpdate();
        return result;
    }
    
    
}
