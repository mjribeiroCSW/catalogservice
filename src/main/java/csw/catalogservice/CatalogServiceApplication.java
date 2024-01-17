package csw.catalogservice;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogServiceApplication {

	@Value("${spring.flyway.enabled}")
	private static boolean DB_Enabled;
	@Value("${spring.datasource.ur}")
	private static String URL;
	@Value("${spring.datasource.username}")
	private static String USER;
	@Value("${spring.datasource.password}")
	private static String PASSWORD;

	public static void main(String[] args) {

		if (DB_Enabled)
		{
			var flyway = Flyway.configure().dataSource(URL, USER, PASSWORD).load();
			flyway.migrate();
		}

		SpringApplication.run(CatalogServiceApplication.class, args);
	}
}
