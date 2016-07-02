package com.jerrydy.springbootgettingstarted.controller;

import com.jerrydy.springbootgettingstarted.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // using @RequestMapping("/greeting") maps GET, PUT, POST to this method by default
    // @RequestParam is optional, required=false by default.
    // @RestController marks the class as a controller where every method returns a domain object instead of a view.
    // It is shorthand for @Controller and @ResponseBody.
    @RequestMapping(method = RequestMethod.GET, value = "/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}