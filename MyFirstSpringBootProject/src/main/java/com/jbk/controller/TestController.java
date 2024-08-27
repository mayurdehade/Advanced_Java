package com.jbk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController is a specialized version of the @Controller annotation.
// It is used to create RESTful web services. It combines @Controller and @ResponseBody,
// meaning that each method in this class will return data directly, typically in JSON format,
// rather than rendering a view.
@RestController
public class TestController {

    // @GetMapping is a shortcut for @RequestMapping(method = RequestMethod.GET).
    // It maps HTTP GET requests to specific handler methods. Here, it maps the root URL ("/")
    // to the getMessage() method.
    @GetMapping("/")
    public String getMessage() {
        // This method handles GET requests to the root URL ("/").
        // It returns a simple string "Hello World!" which will be sent as a response.
        // Since this is a @RestController, the string will be returned as plain text in the HTTP response body.
        return "Hello World!";
    }

    // This method handles GET requests to the "/hello" URL.
    // It returns a string "Hello Spring" that will be sent back in the HTTP response.
    @GetMapping("/hello")
    public String getHello() {
        return "Hello Spring";
    }

    // This method handles GET requests to the "/wlc" URL.
    // It returns a string "Welcome..." that will be sent back in the HTTP response.
    @GetMapping("/wlc")
    public String getWelcome() {
        return "Welcome...";
    }
}
