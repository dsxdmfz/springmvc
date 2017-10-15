package com.springmvc.crud.handlers;

import com.springmvc.crud.dao.DepartmentDao;
import com.springmvc.crud.dao.EmployeeDao;
import com.springmvc.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class EmployeeHandler {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String save(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String input(Map<String,Object> map) {
        map.put("departments", departmentDao.getDepartments());
        map.put("employee",new Employee());
        return "input";
    }

    @RequestMapping("/emps")
    public String list(Map<String,Object> map) {
        map.put("employees", employeeDao.getAll());
        return "list";
    }
}
