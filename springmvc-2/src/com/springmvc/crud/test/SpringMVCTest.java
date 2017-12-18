package com.springmvc.crud.test;

import com.springmvc.crud.dao.EmployeeDao;
import com.springmvc.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

@Controller
public class SpringMVCTest {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private ResourceBundleMessageSource messageSource;

    @RequestMapping("/i18n")
    public String testI18n(Locale locale){
        String value = messageSource.getMessage("i18n.user",null,locale);
        System.out.println(value);
        return "i18n";
    }

    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        byte[] body = null;
        ServletContext servletContext = session.getServletContext();
        InputStream in = servletContext.getResourceAsStream("file/test.txt");
        body = new byte[in.available()];
        in.read(body);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition","attachment;filename=text.txt");

        HttpStatus status = HttpStatus.OK;

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(body,headers,status);
        return responseEntity;
    }

    @ResponseBody
    @RequestMapping("/testHttpMessageConverter")
    public String testHttpMessageConverter(@RequestBody String body) {
        System.out.println(body);
        return "hello world "+new Date();
    }

    @ResponseBody
    @RequestMapping("/testJSON")
    public Collection<Employee> testJSON(){
        return employeeDao.getAll();
    }

    @RequestMapping("/testConversionServiceConverer")
    public String testConver(@RequestParam("employee") Employee employee){
        System.out.println("save: "+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
