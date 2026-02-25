package org.practice.springrest.restlearn;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//@Controller+@ResponseBody
@RequestMapping("/api1")
public class GreetingsController {

    @GetMapping("/wish1")
    public ResponseEntity<String> wish1(){
        ResponseEntity<String > response = new ResponseEntity<String >("Harsha", HttpStatus.OK);
        return response;
    }


}
