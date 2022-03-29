package com.hectorl.fundamentos;

import com.hectorl.fundamentos.bean.MyBean;
import com.hectorl.fundamentos.bean.MyBeanProperties;
import com.hectorl.fundamentos.bean.MyBeanWithDependency;
import com.hectorl.fundamentos.component.ComponentDependency;
import com.hectorl.fundamentos.entity.User;
import com.hectorl.fundamentos.pojo.UserPojo;
import com.hectorl.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private  final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	 // dependencias
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanProperties myBeanProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	public FundamentosApplication(
			@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
			MyBean myBean , MyBeanWithDependency myBeanWithDependency,
			MyBeanProperties myBeanProperties,
			UserPojo userPojo,
			UserRepository userRepository
	){
		this.componentDependency = componentDependency;
		//inyecta dependecia
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanProperties = myBeanProperties;
		this.userPojo = userPojo;
		this.userRepository= userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public  void run (String... args) {
		//ejemplosAnteriores();
		saveUsersDataBase();
		getInformationJpqlfromUser();
	}

	private void saveUsersDataBase(){
		User user1 = new User("hector", "hector@mail.com", LocalDate.of(2022,03,28));
		User user2= new User("lucy", "lucy@mail.com", LocalDate.of(2022,01,28));
		User user3= new User("lucy rosalba", "rosalba@mail.com", LocalDate.of(2022,02,28));
		User user4= new User("motta", "motta@mail.com", LocalDate.of(2022,02,21));
		List<User> list = Arrays.asList(user1, user2, user3,user4);
		list.stream().forEach(userRepository::save);
	}

	private void getInformationJpqlfromUser(){
		/* LOGGER.info("usuario hallado : " +
				userRepository.findByUserEmail("hector@mail.com")
				.orElseThrow(()->new RuntimeException("no usuario")));

		userRepository.findAndSort("lucy", Sort.by("id").descending())
				.stream().forEach(user -> LOGGER.info("ususario con sort : " + user));

		userRepository.findByName("motta")
				.stream()
				.forEach(user -> LOGGER.info("us con query: "+ user));

		LOGGER.info("us con query methodd: " + userRepository.findByEmailAndName("motta@mail.com","motta")
				.orElseThrow(()->new RuntimeException("no usuario ###"))

		);

		userRepository.findByNameLike("%ta%")
				.stream()
				.forEach(user -> LOGGER.info("us like con query: "+ user));

		userRepository.findByEmailAndName(null, "hector" )
				.stream()
				.forEach(user -> LOGGER.info("us con query mail o name: "+ user));
		*/

		userRepository.findByBirthDateBetween(LocalDate.of(2021,03,03), LocalDate.of(2022,05,01))
				.stream()
				.forEach(user -> LOGGER.info("us_entre_fechas "+ user));
		;

		userRepository.findByNameLikeOrderByIdDesc("%u%")
				.stream()
				.forEach(user -> LOGGER.info("us_con_like_y_ordenado "+ user));
	}

	private void ejemplosAnteriores() {
		componentDependency.saludar();
		// llamar la implementacion
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanProperties.function());
		System.out.println(userPojo.getEmail()+"--"+userPojo.getPassword());
		try {
			int value = 10/0;
			LOGGER.debug("mi valooor:" + value);
		} catch(Exception e){
			LOGGER.error("err al div '0' " + e.getMessage());
		}

		LOGGER.error("esto es error");
	}
}
