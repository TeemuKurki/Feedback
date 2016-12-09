package com.MasterBranch.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.MasterBranch.model.Option;

public interface OptionRepository  extends JpaRepository<Option, Integer> {
	List<Option> findAll();
}
