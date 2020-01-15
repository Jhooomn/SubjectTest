package com.app.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.application.SubjectApplication;
import com.app.api.domain.service.SubjectService;
import com.app.api.infrastructure.mapper.SubjectMapper;
import com.app.api.infrastructure.rest.SubjectRest;

@RestController
@RequestMapping("/subject")
public class SubjectController {

	SubjectApplication subjectApplication;

	public SubjectController(@Autowired SubjectMapper subjectMapper, @Autowired SubjectService subjectService) {
		this.subjectApplication = new SubjectApplication(subjectMapper, subjectService);
	}

	@GetMapping
	public List<SubjectRest> getSubject() {
		return subjectApplication.getAll();
	}

	@GetMapping("/{id}")
	public SubjectRest getSubject(@PathVariable String id) {
		return subjectApplication.findSubject(id);
	}

	@PostMapping
	public SubjectRest saveSubject(@RequestBody SubjectRest subject) {
		return subjectApplication.save(subject);
	}

	@PutMapping
	public SubjectRest updateSubject(@RequestBody SubjectRest subject) {
		return subjectApplication.update(subject);
	}

	@DeleteMapping("/{id}")
	public void deleteSubject(@PathVariable String id) {
		subjectApplication.delete(id);
	}

}
