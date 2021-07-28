package com.pyh.hellospringboot.dao;

import com.pyh.hellospringboot.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departments=null;

    static
    {
        departments=new HashMap<Integer, Department>();
        departments.put(1,new Department(601,"生产部"));
        departments.put(2,new Department(602,"仓管部"));
        departments.put(3,new Department(603,"销售部"));
    }

    public Collection<Department> getDepartments()
    {
        return departments.values();
    }

    public Department getDepartmentById(Integer id)
    {
        return departments.get(id);
    }
}
