package com.MasterBranch.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.MasterBranch.model.Query;

public interface QueryRepository  extends JpaRepository<Query, Integer> {
	List<Query> findAll();
}
