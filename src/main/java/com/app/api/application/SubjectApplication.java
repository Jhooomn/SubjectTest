package com.app.api.application;

import java.util.List;
import java.util.UUID;

import com.app.api.domain.service.SubjectService;
import com.app.api.infrastructure.mapper.SubjectMapper;
import com.app.api.infrastructure.rest.SubjectRest;
import com.app.api.shared.domain.Id;

public class SubjectApplication {

	SubjectService subjectService;

	SubjectMapper subjectMapper;

	public SubjectApplication(SubjectMapper subjectMapper, SubjectService subjectService) {
		this.subjectMapper = subjectMapper;
		this.subjectService = subjectService;
	}

	public SubjectRest save(SubjectRest subject) {
		subject.setId(UUID.randomUUID().toString());
		return subjectMapper.domRest(subjectService.saveSubject(subjectMapper.restDom(subject)));
	}

	public void delete(String id) {
		subjectService.deleteSubject(new Id(id));
	}

	public SubjectRest update(SubjectRest subject) {
		return subjectMapper.domRest(subjectService.updateSubject(subjectMapper.restDom(subject)));
	}

	public List<SubjectRest> getAll() {
		return subjectMapper.listDomRest(subjectService.getSubjects());
	}

	public SubjectRest findSubject(String id) {
		return subjectMapper.domRest(subjectService.getSubject(new Id(id)));
	}

}
