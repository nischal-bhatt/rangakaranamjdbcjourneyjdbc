package ranga.karanam.step.jdbcjourney;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ranga.karanam.step.jdbcjourney.entity.Person;
import ranga.karanam.step.jdbcjourney.jpa.PersonJpaRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		logger.info("user id 10001 using jpa now-> {} ", repository.findById(10001));
		logger.info("inserting 10005 -> {}" , repository.insert(new Person(10005,"tara","berlin", new Date())));
		logger.info("updateing 10003 -> {}" , repository.update(new Person(10003,"petraclaus","singapore",new Date())));
		repository.deleteById(10002);
		
		logger.info("all users -> {}" ,repository.findAll());
		
		/*System.out.println("logging out stuff");
		logger.info("all users -> {}",dao.findAll());
	    logger.info("user if 10001 -> {}",dao.findById(10001) );
	    logger.info("number of people deleted -> {}",dao.deleteById(10002));
	    logger.info("inserting 10004 -> {}",dao.insert(new Person(10004,"Tara","Berlin",new Date())));
	    logger.info("update 10003 -> {}",dao.update(new Person(10003, "Peter","Utrecht", new Date())));
	    */
	}

}
