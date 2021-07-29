package com.pyh.hellospringboot.controller;

import com.pyh.hellospringboot.dao.DepartmentDao;
import com.pyh.hellospringboot.dao.EmployeeDao;
import com.pyh.hellospringboot.pojo.Department;
import com.pyh.hellospringboot.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/employeeList")
    public String employeeList(Model model)
    {
        Collection<Employee> employeeList= employeeDao.getEmployees();
        model.addAttribute("employeeList",employeeList);
        return "emp/list";
    }

    /*检查一下返回的数据是否正确而已，是个自己写的test
    @ResponseBody
    @RequestMapping("/employeeList")
    public Collection<Employee> employees()
    {
        return employeeDao.getEmployees();
    }*/

    @GetMapping("/saveEmployee")
    public String toSaveEmployee(Model model)
    {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);

        return "emp/new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(Employee employee)
    {
        employeeDao.save(employee);
//        这样转发到list，之前数据库里的员工信息还会显示在list.html中。如果只是单纯的 return "emp/list"; 这样不会有之前的员工信息
        return "redirect:/employeeList";
    }


}
