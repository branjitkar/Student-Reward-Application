package MyProject.AvatarDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;


@SpringBootApplication
public class AvatarDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvatarDemoApplication.class, args);
	}

}
