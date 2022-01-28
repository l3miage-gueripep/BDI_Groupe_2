package fr.uga.miage.m1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;

@SpringBootApplication
@RestController
@Log
public class MyApplication{
	
    @Autowired
    PersonsRepository persons;
    
    @RequestMapping(
    		value = "/hello", 
    		method = RequestMethod.GET,
    		produces = "application/json")
    @ResponseBody
    /**
     * 
     * @return the first and the last name
     */
    String testDBConnexion(){
    	log.info("testDBConnexion called");
    	String answer = "No person found";
    	if(persons.count() != 0) {
    		Person p = persons.findAll().get(0);
    		answer = "\"" + p.getFirstName() + " " + p.getLastName() + "\"";
    	}
    	return answer;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class,args);
    }
}
