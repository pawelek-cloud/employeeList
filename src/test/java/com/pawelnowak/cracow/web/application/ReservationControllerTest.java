package com.pawelnowak.cracow.web.application;



import com.pawelnowak.entity.Employee;
import com.pawelnowak.rest.EmployeeController;
import com.pawelnowak.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(EmployeeController.class)

public class ReservationControllerTest {

    @MockBean

    private EmployeeService employeeService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getEmployee() throws Exception {

        Employee mockEmployee = new Employee();
        mockEmployee.setId(1);
        mockEmployee.setFirstName("John");
        mockEmployee.setLastName("Smith");
        mockEmployee.setEmail("tom@gmail.com");


        given(employeeService.findById(1)).willReturn
                (mockEmployee);
        this.mockMvc.perform(get("/employees?employeeId=1")).andExpect
                (status().isOk()).andExpect(content().string(containsString("tom@gmail.com")));

    }

}