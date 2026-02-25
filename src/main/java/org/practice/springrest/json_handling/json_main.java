package org.practice.springrest.json_handling;

import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.ObjectWriter;

import java.io.File;

public class json_main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        //  manually converting java object to json
        Customer customer = new Customer(1, "Harsha", "Bengaluru");
        String json = mapper.writeValueAsString(customer);
        System.out.println("Json form of Java Object: "+json);

        //  manually converting json to  java object
        Customer customer1 = mapper.readValue(new File("src/main/java/org/practice/springrest/json_handling/sample.json"), Customer.class);
        System.out.println("java object from json: "+customer1);
    }
}
