package br.com.felipediogo.whitelistapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@ComponentScan("br.com.felipediogo")
@EntityScan("br.com.felipediogo.database.entities")
@EnableJpaRepositories("br.com.felipediogo.database.repositories")
public class WhiteListAppApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(WhiteListAppApplication.class);

	private static final String CREATE_TABLE_RULE_SCRIPT = "CREATE TABLE IF NOT EXISTS rules (" +
			"id INT NOT NULL AUTO_INCREMENT," +
			"client VARCHAR(128) NOT NULL," +
			"regex VARCHAR(128) NOT NULL," +
			"PRIMARY KEY (`id`))";

	private static final String CREATE_TABLE_GLOBAL_RULE_SCRIPT = "CREATE TABLE IF NOT EXISTS global_rules (" +
			"id INT NOT NULL AUTO_INCREMENT," +
			"regex VARCHAR(128) NOT NULL," +
			"PRIMARY KEY (`id`))";

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(WhiteListAppApplication.class, args);
	}

	@Override
	public void run(String... args) {
		try {
			log.info("Running scripts to initialize database");
			jdbcTemplate.execute(CREATE_TABLE_RULE_SCRIPT);
			jdbcTemplate.execute(CREATE_TABLE_GLOBAL_RULE_SCRIPT);
			log.info("Database initialized");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
