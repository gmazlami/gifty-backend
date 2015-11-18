package ch.gmazlami.gifty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import ch.gmazlami.gifty.mongodb.repositories.GiftRepository;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages="ch.gmazlami.gifty")
@EnableMongoRepositories

public class GiftyBackendConfiguration implements CommandLineRunner{

	
	@Autowired
	private GiftRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(GiftyBackendConfiguration.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
	
}
