package com.fortumotest.indrek;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SumController {

    private String sum = "0";
    public static String escape = "end";

    @PostMapping
    public String handle(@RequestBody String string) {
        String requestNumber = string.replace("=", "");
        String requestValidationRegex = "[1-9][0-9]*";
        if (!requestNumber.matches(requestValidationRegex)) {
            if (requestNumber.equals(escape)) {
                String returnable = this.sum;
                this.sum = "0";
                return returnable;
            }

            return "Give me a number";
        } else {
            this.sum = (new AddTwoNumberStrings(this.sum, requestNumber)).sum();
            return "";
        }
    }
}
