package com.BMTask.BMLeague;

import com.BMTask.BMLeague.Model.Mail;
import com.BMTask.BMLeague.Service.MailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(scanBasePackages={
//		"com.BMTask.BMLeague"
//		,"com.BMTask.BMLeague.Controller"
//		,"com.BMTask.BMLeague.DAO"
//		,"com.BMTask.BMLeague.Model"
//		,"com.BMTask.BMLeague.Repository"
//		,"com.BMTask.BMLeague.Service"})
@SpringBootApplication
@ConfigurationPropertiesScan
@EntityScan("com.BMTask.BMLeague.Model")
//@ComponentScan(basePackages = {"com.BMTask.BMLeague.Service"})
@EnableJpaRepositories("com.BMTask.BMLeague.Repository")
public class BmLeagueApplication {

	public static void main(String[] args) {


		Mail mail = new Mail();
		mail.setMailFrom("bmtaskspring@gmail.com");
		mail.setMailTo("bmtaskspring@gmail.com");
		mail.setMailSubject("Spring Boot - Email Example");
		mail.setMailContent("Send Email\n\nThanks\n");

		ApplicationContext ctx = SpringApplication.run(BmLeagueApplication.class, args);
		MailService mailService = (MailService) ctx.getBean("mailService");
		mailService.sendEmail(mail);
	}

}
