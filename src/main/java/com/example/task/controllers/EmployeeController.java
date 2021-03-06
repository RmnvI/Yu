package com.example.task.controllers;

import com.example.task.models.Employee;
import com.example.task.models.ScheduleTime;
import com.example.task.models.api.EmployeeApiModel;
import com.example.task.repositories.EmployeeRepository;
import com.example.task.repositories.ScheduleTimeRepository;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeRepository employeeRepository;
    private ScheduleTimeRepository scheduleTimeRepository;

    public EmployeeController(EmployeeRepository employeeRepository, ScheduleTimeRepository scheduleTimeRepository) {
        this.employeeRepository = employeeRepository;
        this.scheduleTimeRepository = scheduleTimeRepository;
    }

    /**
     * Method need to find employee by Id
     * @param id
     * @return
     */
    @GetMapping("employee/id/{id}")
    public Employee getEmployeeById(@PathVariable long id){
        System.out.println(employeeRepository.findAll());
        return employeeRepository.findById(id).get();
    }

    /**
     * Method need to show all employees
     * @param pageNumber - number of page
     * @param pageSize - page size
     * @param sortBy - type of sorting
     * @return
     */
    @GetMapping("employee")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam(defaultValue = "0") int pageNumber,
                                                       @RequestParam(defaultValue = "10") int pageSize,
                                                       @RequestParam(defaultValue = "id") String sortBy){
        Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        Page<Employee> employees = (Page<Employee>) employeeRepository.findAll(paging);
        if(employees.hasContent()){
            return new ResponseEntity<List<Employee>>(employees.getContent(), new HttpHeaders(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<List<Employee>>(new ArrayList<>(), new HttpHeaders(), HttpStatus.OK);
        }

    }

    /**
     * Method need to find necessary employee by firstName
     * @param firstName - firstName
     * @return
     */
    @GetMapping("employee/{firstName}")
    public List<Employee> getEmployeesByFirstName(@PathVariable String firstName){
        return employeeRepository.findAllByFirstName(firstName);
    }

    /**
     * Method need to add a new employee
     * @param employee
     */
    @PostMapping("employee")
    public void addEmployee(@RequestBody EmployeeApiModel employee){
        //mapping dateTime to time, cause sql lib cant parse.
        String dateStartTime = ISODateTimeFormat.dateTimeParser().parseDateTime(employee.getStartTime()).toLocalTime().toString().substring(0,8);
        String dateEndTime = ISODateTimeFormat.dateTimeParser().parseDateTime(employee.getStartTime()).toLocalTime().toString().substring(0,8);

        ScheduleTime time = new ScheduleTime(0L, Time.valueOf(dateStartTime),Time.valueOf(dateEndTime));
        time = scheduleTimeRepository.save(time);
        employeeRepository.save(new Employee(0, employee.getFirstName(), employee.getLastName(), time));
    }

    /**
     * Method need to delete employee
     * @param id
     */
    @DeleteMapping("employee/{id}")
    public void deleteEmployee(@PathVariable long id){
        System.out.println(id);
        employeeRepository.deleteById(id);
    }
}
