package isi.tn.qatar22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories(basePackages="isi.tn.qatar22")
@SpringBootApplication
public class Qatar22Application {

	public static void main(String[] args) {
		SpringApplication.run(Qatar22Application.class, args);
	}

}
