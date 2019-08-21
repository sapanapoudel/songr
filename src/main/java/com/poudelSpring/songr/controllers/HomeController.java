package com.poudelSpring.songr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Pattern;

@Controller
public class HomeController {
    @GetMapping("/hello")
    public String helloWorldRoute() {
        return "helloworld";
    }


    //route that turns words into UPPER CASE
    @GetMapping("/capitalize/hello/{name}")
    public String capitalizeRoute(@PathVariable String name, Model model) {
        model.addAttribute("name", name.toUpperCase());

        return "capitalizeword";
    }

    //route that reverse the
    @GetMapping("/reverse")
    public String reverseOrderInRoute(@RequestParam(required=false,
            defaultValue = "Hello World") String name, Model m) {
        m.addAttribute("name", reverseWord(name));
        return "reverseword";

    }

    //Source: https://www.geeksforgeeks.org/reverse-words-given-string-java/
    public static String reverseWord(String input) {
        Pattern pattern = Pattern.compile("\\s");
        String[] temp = pattern.split(input);
        String result = "";
        for(int i = 0; i < temp.length; i++) {
            if(i == temp.length -1) {
                result = temp[i] +result;

            } else {
                result = " " + temp[i] + result;
            }

        }
            return result;

    }

}
