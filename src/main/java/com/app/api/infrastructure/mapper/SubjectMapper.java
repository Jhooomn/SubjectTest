package com.app.api.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.app.api.domain.model.Subject;
import com.app.api.infrastructure.dto.SubjectDto;
import com.app.api.infrastructure.rest.SubjectRest;
import com.app.api.shared.domain.Code;
import com.app.api.shared.domain.Credits;
import com.app.api.shared.domain.Id;
import com.app.api.shared.domain.Name;
import com.app.api.shared.infrastructure.mapper.MapperDto;
import com.app.api.shared.infrastructure.mapper.MapperRest;

@Component
public class SubjectMapper implements MapperDto<SubjectDto, Subject>, MapperRest<SubjectRest, Subject> {

	@Override
	public SubjectRest domRest(Subject o) {
		SubjectRest subject = new SubjectRest();

		subject.setId(o.getId().getId());
		subject.setCode(o.getCode().getCode());
		subject.setCredits(o.getCredits().getCredits());
		subject.setName(o.getName().getName());

		return subject;
	}

	@Override
	public Subject restDom(SubjectRest i) {
		// VALUE OBJECTS -> Smart Constructor
		return Subject.of(new Id(i.getId()), new Name(i.getName()), new Code(i.getCode()), new Credits(i.getCredits()));
	}

	@Override
	public SubjectDto domDto(Subject o) {
		SubjectDto subject = new SubjectDto();
		subject.setId(o.getId().getId());
		subject.setCode(o.getCode().getCode());
		subject.setCredits(o.getCredits().getCredits());
		subject.setName(o.getName().getName());
		return subject;
	}

	@Override
	public Subject dtoDom(SubjectDto i) {
		return Subject.of(new Id(i.getId()), new Name(i.getName()), new Code(i.getCode()), new Credits(i.getCredits()));
	}

}
