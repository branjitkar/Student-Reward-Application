package teacher.example.Teacher;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import teacher.example.Teacher.Integration.KafkaSender;

@SpringBootApplication
public class TeacherApplication implements CommandLineRunner {
	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
    KafkaSender sender() {
		return new KafkaSender();
	}

	public static void main(String[] args) {
		SpringApplication.run(TeacherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Message has been sent");
	}
}
