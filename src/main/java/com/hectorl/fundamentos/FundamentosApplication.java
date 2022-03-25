package com.hectorl.fundamentos;

import com.hectorl.fundamentos.bean.MyBean;
import com.hectorl.fundamentos.bean.MyBeanProperties;
import com.hectorl.fundamentos.bean.MyBeanWithDependency;
import com.hectorl.fundamentos.component.ComponentDependency;
import com.hectorl.fundamentos.pojo.UserPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private  final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	 // dependencias
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanProperties myBeanProperties;
	private UserPojo userPojo;

	public FundamentosApplication(
			@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
			MyBean myBean , MyBeanWithDependency myBeanWithDependency,
			MyBeanProperties myBeanProperties,
			UserPojo userPojo
	){
		this.componentDependency = componentDependency;
		//inyecta dependecia
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanProperties = myBeanProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public  void run (String... args) {
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
