package com.MasterBranch.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.MasterBranch.model.Query;

@Transactional
public interface QueryRepository  extends JpaRepository<Query, Long> {
	List<Query> findAll();
}
