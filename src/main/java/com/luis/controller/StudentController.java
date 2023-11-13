package com.luis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luis.model.Student;
import com.luis.service.IStudentService;

@Controller
@RequestMapping({ "estudiantes", "students" })
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@GetMapping({ "/list", "/" })
	public String students(Model model) {
		List<Student> students = studentService.getAll();
		model.addAttribute("students", students);
		return "students";
	}

	@GetMapping("/create")
	public String showFormSave(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "createStudent";
	}

	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students/list";
	}

	@GetMapping("/edit/{id}")
	public String showFormEdit(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "editStudent";
	}

	@PostMapping("/save/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		Student studentX = studentService.getStudentById(id);
		studentX.setId(id);
		studentX.setName(student.getName());
		studentX.setSurname(student.getSurname());
		studentX.setEmail(student.getEmail());
		studentService.updateStudent(studentX);
		return "redirect:/students/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "redirect:/students/list";
	}
}
