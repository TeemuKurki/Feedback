package com.MasterBranch.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MasterBranch.model.Question;

@Transactional
public interface QuestionRepository  extends JpaRepository<Question, Integer> {
	List<Question> findAll();
}
