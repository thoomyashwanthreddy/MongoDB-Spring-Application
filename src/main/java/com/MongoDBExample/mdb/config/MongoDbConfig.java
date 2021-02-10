package com.MongoDBExample.mdb.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.MongoDBExample.mdb.Repository.UserRepository;
import com.MongoDBExample.mdb.entity.Users;

@Configuration
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class MongoDbConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				userRepository.save(new Users(1,"Yashwanth","Development",2000L));
			    userRepository.save(new Users(2,"Thoom","Operations",3000L));
	
			}
		};
	}

}
