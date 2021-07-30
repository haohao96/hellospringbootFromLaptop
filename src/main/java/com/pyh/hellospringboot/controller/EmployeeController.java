package com.pyh.hellospringboot.controller;

import com.pyh.hellospringboot.dao.DepartmentDao;
import com.pyh.hellospringboot.dao.EmployeeDao;
import com.pyh.hellospringboot.pojo.Department;
import com.pyh.hellospringboot.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/update/{id}")
    public String updateEmployee(@PathVariable Integer id,Model model)
    {
        Employee employee = employeeDao.getEmployeeById(id%100); //数据库中的id和employee的id不一样，一个是一位数，一个是三位数
        employeeDao.delete(id%100);
        model.addAttribute("updateEmployee",employee);
        model.addAttribute("departments",departmentDao.getDepartments());
        return "emp/update";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(Employee employee)
    {
        employeeDao.save(employee);
        return "redirect:/employeeList";
    }


}
