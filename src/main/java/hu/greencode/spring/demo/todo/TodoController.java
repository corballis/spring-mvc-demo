package hu.greencode.spring.demo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping("/")
    public String todoWelcome(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "todos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(@ModelAttribute("todo") Todo todo) {
        todoRepository.save(todo);
        return "redirect:/";
    }

    @RequestMapping("/delete-todo/{todoId}")
    public String deleteTodo(@PathVariable("todoId") String id) {
        todoRepository.delete(id);
        return "redirect:/";
    }

}
