package com.app.api.infrastructure.repository.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.domain.model.Subject;
import com.app.api.domain.service.SubjectService;
import com.app.api.infrastructure.mapper.SubjectMapper;
import com.app.api.infrastructure.repository.database.SubjectRepository;
import com.app.api.shared.domain.Id;

@Service
public class SubjectAdapter implements SubjectService {

	@Autowired
	SubjectRepository subjectRepository;

	@Autowired
	SubjectMapper subjectMapper;

	@Override
	public Subject saveSubject(Subject subject) {
		return subjectMapper.dtoDom(subjectRepository.save(subjectMapper.domDto(subject)));
	}

	@Override
	public Subject getSubject(Id id) {
		return subjectMapper.dtoDom(subjectRepository.findById(id.getId()).orElseThrow(() -> new RuntimeException()));
	}

	@Override
	public List<Subject> getSubjects() {
		return subjectMapper.listDtoDom(subjectRepository.findAll());
	}

	@Override
	public Subject updateSubject(Subject subject) {
		return subjectMapper.dtoDom(subjectMapper.domDto(subject));
	}

	@Override
	public void deleteSubject(Id id) {
		subjectRepository.deleteById(id.getId());
	}

}
