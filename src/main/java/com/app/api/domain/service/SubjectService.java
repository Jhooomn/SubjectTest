package com.app.api.domain.service;

import java.util.List;

import com.app.api.domain.model.Subject;
import com.app.api.shared.domain.Id;

public interface SubjectService {

	public Subject saveSubject(Subject subject);

	public Subject getSubject(Id id);

	public List<Subject> getSubjects();

	public Subject updateSubject(Subject subject);

	public void deleteSubject(Id id);

}
