package MVCProj01.MVCProj01_Basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.nt") 
@EntityScan("com.nt.modal")
@EnableJpaRepositories("com.nt")
public class MvcProj01BasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcProj01BasicApplication.class, args);
	}

}
