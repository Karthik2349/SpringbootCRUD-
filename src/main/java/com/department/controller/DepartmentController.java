package com.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.model.Department;
import com.department.repository.DepartmentRepository;
import com.department.service.DepartmentService;
@Controller
@RequestMapping("/departments/")
public class DepartmentController {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("showform")
	public String showDepartmentForm(){
		return "add-department";
	}
	@GetMapping("list")
	public String departments(Model model){
		model.addAttribute("departments", this.departmentRepository.findAll());
		return "index";
	}
	@PostMapping("add")
	public String addDepartment(@valid Department department,BindingResult result,Model model){
		if(result.hasErrors()){
			return "add-department";
		}
		this.departmentRepository.save(department);
		return "redirect:list";
	}
	@GetMapping("edit{depid}")
	public String showUpdateform(@PathVariable("depid") long depid,Model model){
		Department department = this.departmentRepository.findById(depid)
		.orElseThrow(() -> new IllegalArgumentException("invalid department id :" + depid));
		model.addAttribute("department", department);
		return "update-department";
	}
	@GetMapping("update{depid}")
	public String updateDepartment(@PathVariable("depid") long depid,@valid Department department,BindingResult result,Model model){
		if(result.hasErrors()){
			department.setDepid(depid);
			return "update-department";
		}
		departmentRepository.save(department);
		model.addAttribute("departments", this.departmentRepository.findAll());
		return "index";
	}
	@DeleteMapping("delete/{depid}")
	public String deleteDepartment(@PathVariable ("depid") long depid,Model model){
		Department department = this.departmentRepository.findById(depid)
		.orElseThrow(() -> new IllegalArgumentException("invalid department id :" + depid));
		this.departmentRepository.delete(department);
		model.addAttribute("departments", this.departmentRepository.findAll());
		return "index";
	}

}
