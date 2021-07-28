package com.pyh.hellospringboot.dao;

import com.pyh.hellospringboot.pojo.Department;
import com.pyh.hellospringboot.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    @Autowired
    private static DepartmentDao departmentDao;

    private static Map<Integer, Employee> employees=null;

    static
    {
        employees=new HashMap<Integer, Employee>();
        employees.put(1,new Employee(101,"昊昊",new Department(601,"生产部")));
        employees.put(2,new Employee(102,"熙熙",new Department(602,"仓管部")));
        employees.put(3,new Employee(103,"杰杰",new Department(603,"销售部")));
    }

    public Collection<Employee> getEmployees()
    {
        return employees.values();
    }

    public Employee getEmployeeById(Integer id)
    {
        return employees.get(id);
    }

    private static Integer initId=3;

    public void save(Employee employee)
    {
        employees.put(initId++, employee);
    }

    public void delete(Integer id)
    {
        employees.remove(id%100);
    }
}
