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
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(WhiteListAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String createRulesTable = "CREATE TABLE IF NOT EXISTS rules ( "
				+ "id SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT, " + "client VARCHAR(128) NULL, "
				+ "regex VARCHAR(128) NOT NULL, CREATED_AT DATETIME DEFAULT CURRENT_TIMESTAMP, "
				+ "PRIMARY KEY (`id`)) ";
		String createGlobalRulesTable = "CREATE TABLE IF NOT EXISTS global_rules ( "
				+ "id SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT, "
				+ "regex VARCHAR(128) NOT NULL, CREATED_AT DATETIME DEFAULT CURRENT_TIMESTAMP, " + "PRIMARY KEY (`id`)) ";
		try {
			jdbcTemplate.execute(createRulesTable);
			jdbcTemplate.execute(createGlobalRulesTable);
			log.info("Tables created");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
