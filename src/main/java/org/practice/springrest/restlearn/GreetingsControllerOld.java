package org.practice.springrest.restlearn;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingsControllerOld {
    @GetMapping("/wish1")
    @ResponseBody
    public ResponseEntity<String> getWishes(){
        String res = "Hello, Harsha";
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/wish2")
    @ResponseBody
    public String getWish(){
        return "Hello Harsha";
    }

}
