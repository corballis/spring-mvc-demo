package hu.greencode.spring.demo.greeting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@Controller
@ResponseBody
@RequestMapping(value = "/greeting")
public class GreetingController {

    @RequestMapping("/hello")
    @RolesAllowed("ROLE_USER")
    public String helloWorld() {
        return "hello world";
    }

    @RequestMapping("/hello/{name}")
    public String helloName(@PathVariable String name) {
        return "hello " + name;
    }

    // http://localhost:8080/greeting/hello-url?name=John
    @RequestMapping("/hello-url")
    public String helloGetParameter(@RequestParam String name) {
        return "hello " + name;
    }

    // Download the Rest Client extension to your browser and send a request body to the url below
    @RequestMapping("/hello-hostname")
    public String helloHostName(@RequestHeader(value = "Host") String host) {
        return "hello " + host;
    }

    @RequestMapping("/hello-body")
    public String helloBody(@RequestBody String body) {
        return "hello " + body;
    }



}
