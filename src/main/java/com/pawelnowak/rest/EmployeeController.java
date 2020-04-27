package com.pawelnowak.rest;

import com.pawelnowak.entity.Employee;
import com.pawelnowak.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        List<Employee> theEmployees = employeeService.findAll();
        theModel.addAttribute("employees", theEmployees);
        return "employees/list-employees";

    }
    @RequestMapping(method = RequestMethod.GET)
    public String getEmployee(@RequestParam("employeeId") int employeeId, Model theModel) {
        Employee theEmployee = employeeService.findById(employeeId);
        theModel.addAttribute("employees", theEmployee);
        if (theEmployee == null) {
            return "employees/Id";
        }
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";

    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
        Employee theEmployee = employeeService.findById(theId);
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {

        employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }


    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute("employee")  Employee theEmployee, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "employees/employee-form";
        }
        employeeService.save(theEmployee);

        return "redirect:/employees/list";

    }
}
