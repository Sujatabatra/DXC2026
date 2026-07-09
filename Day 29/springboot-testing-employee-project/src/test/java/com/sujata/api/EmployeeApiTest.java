package com.sujata.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.sujata.SpringbootRestApiEmployeeProjectApplication;
import com.sujata.entity.Employee;
import com.sujata.service.EmployeeService;

@WebMvcTest(EmployeeApi.class)
public class EmployeeApiTest {

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private EmployeeService employeeService;

	@Test
	void testGetAllEmployees() throws Exception {

		Employee employee = new Employee();

		employee.setEmpId(1);
		employee.setEmpName("Rahul");
		employee.setEmpDepartment("IT");
		employee.setEmpDesignation("Developer");
		employee.setEmpBasicSalary(45000);

		// Stubbing the behaviour of getAllEmployees() method of employee service
		when(employeeService.getAllEmployees()).thenReturn(List.of(employee));

		mockMvc.perform(get("/employees")).andExpect(status().isOk()).andExpect(jsonPath("$[0].empId").value(1))
				.andExpect(jsonPath("$[0].empName").value("Rahul"))
				.andExpect(jsonPath("$[0].empDepartment").value("IT"))
				.andExpect(jsonPath("$[0].empDesignation").value("Developer"))
				.andExpect(jsonPath("$[0].empBasicSalary").value(45000));
	}
}