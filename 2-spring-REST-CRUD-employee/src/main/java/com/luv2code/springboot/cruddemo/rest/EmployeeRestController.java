package com.luv2code.springboot.cruddemo.rest;


import com.luv2code.springboot.cruddemo.Serivice.EmployeeService;
//import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class EmployeeRestController {

    private EmployeeService employeeService;
   // private EmployeeDAO employeeDAO;
    /* inject directly
    expose employee
    and return all the employee

     */

    public EmployeeRestController(EmployeeService theEmployeeService)
    {
        employeeService=theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findll()
    {
         return employeeService.findall();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee theEmployee=employeeService.findByID(employeeId);

        if(theEmployee==null){
            throw new RuntimeException("Employee ID not FOUND "+employeeId);
        }
        return theEmployee;

    }

    @PostMapping("/employees")
    public Employee AddEmployee(@RequestBody Employee theEmployee)

    {
        theEmployee.setId(0);
        Employee DBEmployee=employeeService.save(theEmployee);
        return DBEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee)
    {
        Employee DbEmployee=employeeService.save(theEmployee);
        return  DbEmployee;
    }

    @DeleteMapping("/employees/{employeeID}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee=employeeService.findByID(employeeId);

        if(tempEmployee==null){
            throw new RuntimeException("EMPLOYEE ID NOT FOUND.......!!! "+employeeId);
        }
        employeeService.deleteById(employeeId);

        return "Deleted employee id "+employeeId;
    }
}
