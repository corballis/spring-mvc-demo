package hu.greencode.spring.demo.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {

    @RequestMapping("/")
    public String todoWelcome() {
        return "todos";
    }

}
