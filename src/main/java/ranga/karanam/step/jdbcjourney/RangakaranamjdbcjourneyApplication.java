package ranga.karanam.step.jdbcjourney;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ranga.karanam.step.jdbcjourney.entity.Person;
import ranga.karanam.step.jdbcjourney.jdbc.PersonJdbcDAO;

@SpringBootApplication
public class RangakaranamjdbcjourneyApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDAO dao;
	
	public static void main(String[] args) {
		SpringApplication.run(RangakaranamjdbcjourneyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("all users -> {}",dao.findAll());
	    logger.info("user if 10001 -> {}",dao.findById(10001) );
	    logger.info("number of people deleted -> {}",dao.deleteById(10002));
	    logger.info("inserting 10004 -> {}",dao.insert(new Person(10004,"Tara","Berlin",new Date())));
	    logger.info("update 10003 -> {}",dao.update(new Person(10003, "Peter","Utrecht", new Date())));
	}

}
