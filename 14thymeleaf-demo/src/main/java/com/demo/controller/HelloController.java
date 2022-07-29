package com.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Student;

@Controller
public class HelloController {

	@RequestMapping("/sayhello")
	public String sayHello() {
		return "hello";
	}

	@RequestMapping("/sendData")
	public ModelAndView sendData() {
		ModelAndView mav = new ModelAndView("data");
		mav.addObject("message", "Keep Learning to be competent!");
		return mav;
	}

	@RequestMapping("/sendData1")
	public String sendData1(Model model) {
		model.addAttribute("message", "Keep Learning to be competent!");
		return "data";
	}

	@RequestMapping("/sendData2")
	public String sendData1(Map<String, Object> map) {
		map.put("message", "Keep Learning to be competent!");
		return "data";
	}

	@RequestMapping("/student")
	public String getStudent(Model model) {
		Student student = new Student();
		student.setName("John");
		student.setScore(99);
		model.addAttribute("student", student);
		return "student";
	}

	@RequestMapping("/studentform")
	public ModelAndView showStudentForm() {
		ModelAndView mav = new ModelAndView("studentform");
		Student student = new Student();
		student.setName("Bob");
		student.setScore(88);
		mav.addObject(student);
		return mav;
	}

	@RequestMapping("/saveStudent")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		ModelAndView mav = new ModelAndView("result");
		System.out.println(student.getName());
		System.out.println(student.getScore());
		mav.addObject(student);
		return mav;
	}

}
