package teacher.example.Teacher;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import teacher.example.Integration.Sender;

@SpringBootApplication
public class TeacherApplication implements CommandLineRunner {
	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
	Sender sender() {
		return new Sender();
	}

	public static void main(String[] args) {
		SpringApplication.run(TeacherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Message has been sent");
	}
}
