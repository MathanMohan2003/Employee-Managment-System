package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{


    private EntityManager entityManager;



    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }


    @Override
    public List<Employee> findall() {
        /*create query
        exceutee query and get result
        return the results
         */

         TypedQuery<Employee> theQuery=entityManager.createQuery("From Employee ",Employee.class);
         List<Employee> employees=theQuery.getResultList();
         return employees;
    }

    @Override
    public Employee findByID(int id) {
        Employee theEmployee=entityManager.find(Employee.class,id);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee DBEmployee=entityManager.merge(theEmployee);
        return DBEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee theEmployee=entityManager.find(Employee.class,id);
        entityManager.remove(theEmployee);
    }
}
