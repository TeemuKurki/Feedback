package com.MasterBranch.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.MasterBranch.model.Query;

@Transactional
public interface QueryRepository  extends JpaRepository<Query, Long> {
	List<Query> findAll();
}
