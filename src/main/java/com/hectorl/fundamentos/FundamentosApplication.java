package com.hectorl.fundamentos;

import com.hectorl.fundamentos.bean.MyBean;
import com.hectorl.fundamentos.bean.MyBeanWithDependency;
import com.hectorl.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	 // dependencias
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean , MyBeanWithDependency myBeanWithDependency){
		this.componentDependency = componentDependency;
		//inyecta dependecia
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
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
	}
}
