package com.MasterBranch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.MasterBranch.model.Answer;
import com.MasterBranch.model.Enquiry;
import com.MasterBranch.model.Query;
import com.MasterBranch.repository.AnswerRepository;
import com.MasterBranch.repository.EnquiryRepository;
import com.MasterBranch.repository.QueryRepository;


@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(QueryRepository repository, EnquiryRepository EnReporitory, AnswerRepository ansRepository) {
		return (args) -> {
			// save students
			Query q = new Query("Testi kysymys", 0); 
			Query q1 = new Query("Ääkköset", 0); 
			Answer a1 = new Answer();
			a1.setAnswer("testi vastaus");
			Enquiry eq = new Enquiry();
			eq.setName("Testikysely");

			repository.save(q);
			repository.save(q1);
			EnReporitory.save(eq);
			ansRepository.save(a1);
			

		};
	}
}
