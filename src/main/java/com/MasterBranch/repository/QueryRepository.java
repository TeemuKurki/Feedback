package com.MasterBranch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MasterBranch.model.Query;

public interface QueryRepository  extends JpaRepository<Query, Long>{
	public List<Query> findById(int id);
}
