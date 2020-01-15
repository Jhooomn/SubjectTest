package com.app.api.infrastructure.repository.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.app.api.infrastructure.dto.SubjectDto;
import com.app.api.shared.domain.Credits;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectDto, String> {

}
