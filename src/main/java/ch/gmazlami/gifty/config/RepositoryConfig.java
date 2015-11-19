package ch.gmazlami.gifty.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "ch.gmazlami.gifty.postgres.repositories")
@EnableMongoRepositories(basePackages = "ch.gmazlami.gifty.mongodb.repositories")
@EnableAutoConfiguration
@EntityScan(basePackages = {"ch.gmazlami.gifty.models"})
public class RepositoryConfig {
}
