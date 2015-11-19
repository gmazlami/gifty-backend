package ch.gmazlami.gifty;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import ch.gmazlami.gifty.config.AppConfig;

@Configuration
@EnableAutoConfiguration

public class GiftyBackendConfiguration implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
	
}
