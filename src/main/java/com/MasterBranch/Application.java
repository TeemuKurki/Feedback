package com.MasterBranch;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.MasterBranch.model.Enquiry;
import com.MasterBranch.model.Question;
import com.MasterBranch.model.Option;
import com.MasterBranch.repository.EnquiryRepository;
import com.MasterBranch.repository.OptionRepository;
import com.MasterBranch.repository.QuestionRepository;


@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(QuestionRepository qrepository, EnquiryRepository erepository, OptionRepository orepository) {
		return (args) -> {
			
	        
	        
	        Enquiry e = new Enquiry("Harjoitus kysely", true);
	        Question q1 = new Question(e, "Monivalinta Kysymys", 1);
	        Question q2 = new Question(e, "Tavallinen Kysymys", 0);
	        Option o1 = new Option(q1, "Eka valinta");
	        Option o2 = new Option(q1, "Toka valinta");
	        
	        erepository.save(e);
	        qrepository.save(q1);
	        qrepository.save(q2);
	        orepository.save(o1);
	        orepository.save(o2);


		};
		
	}
	
}
