package com.sujata.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sujata.entity.Payroll;
import com.sujata.service.PayrollService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/payroll")
public class PayrollController {

	private final PayrollService payrollService;

	public PayrollController(PayrollService payrollService) {
		this.payrollService = payrollService;
	}

	/**
	 * Create Payroll
	 */
	@PostMapping("/employee/{employeeId}")
	public ResponseEntity<Payroll> createPayroll(@PathVariable Long employeeId, @Valid @RequestBody Payroll payroll) {

		Payroll savedPayroll = payrollService.createPayroll(employeeId, payroll);

		return ResponseEntity.status(HttpStatus.CREATED).body(savedPayroll);
	}

	/**
	 * Get All Payrolls
	 */
	@GetMapping
	public ResponseEntity<List<Payroll>> getAllPayrolls() {

		return ResponseEntity.ok(payrollService.findAll());
	}

	/**
	 * Get Payroll By Id
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Payroll> getPayrollById(@PathVariable Long id) {

		return ResponseEntity.ok(payrollService.findById(id));
	}

	/**
	 * Update Payroll
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Payroll> updatePayroll(@PathVariable Long id, @Valid @RequestBody Payroll payroll) {

		return ResponseEntity.ok(payrollService.updatePayroll(id, payroll));
	}

	/**
	 * Delete Payroll
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePayroll(@PathVariable Long id) {

		payrollService.deletePayroll(id);

		return ResponseEntity.noContent().build();
	}

}