package com.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Driver {

    private static Logger logger= LoggerFactory.getLogger(Driver.class);

    public static void main(String[] args) {

        try{
            // create object mapper
            ObjectMapper mapper=new ObjectMapper();
            // read JSON file and map/convert to Java POJO
            // data/sample-lite.json
            Student theStudent=
                    mapper.readValue(new File("data/sample-full.json")
                            ,Student.class);

            // print first name and last name
            logger.info("First Name = "+theStudent.getFirstName());
            logger.info("Last Name = "+theStudent.getLastName());

            // print out address: street and city
            Address address=theStudent.getAddress();

            logger.info("Street = "+address.getStreet());
            logger.info("City = "+address.getCity());

            // print out languages
            for(String tempLang : theStudent.getLanguages()){
                logger.info(tempLang);
            }



        }catch (Exception exc){
            exc.printStackTrace();
        }

    }
}
