package com.MasterBranch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

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

	/*@Bean
	public CommandLineRunner demo(QuestionRepository qrepository, EnquiryRepository erepository, OptionRepository orepository) {
		return (args) -> {
			
			Enquiry e1 = new Enquiry("Testikysely", true);
			Question q1 = new Question(e1, "Osasitko koodata sujuvasti ennen kuin siirryit Digiprojekti-kurssille?", 1);
			Option o1 = new Option(q1, "Osasin koodata sujuvasti");
			Option o2 = new Option(q1, "");
			Option o3 = new Option(q1, "");
			Option o4 = new Option(q1, "");
			

			
	        Enquiry e1 = new Enquiry("Harjoitus kysely", true);
	        Question q1 = new Question(e1, "Monivalinta Kysymys", 1);
	        Question q2 = new Question(e1, "Tavallinen Kysymys", 0);
	        Option o1 = new Option(q1, "Eka valinta");
	        Option o2 = new Option(q1, "Toka valinta");
	        
	        erepository.save(e1);
	        qrepository.save(q1);
	        qrepository.save(q2);
	        orepository.save(o1);
	        orepository.save(o2);


		};
	}*/
}
