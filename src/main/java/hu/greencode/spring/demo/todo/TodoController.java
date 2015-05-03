package hu.greencode.spring.demo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@Controller
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ToDoValidator validator;

    @RequestMapping("/")
    @RolesAllowed("ROLE_USER")
    public String todoWelcome(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        model.addAttribute("todo", new Todo());
        return "todos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    @RolesAllowed("ROLE_ADMIN")
    public String addTodo(@ModelAttribute("todo") @Valid Todo todo, BindingResult bindingResult, Model model) {

        validator.validate(todo, bindingResult);

        if (!bindingResult.hasErrors()) {
            todoRepository.save(todo);
            return "redirect:/";
        } else {
            model.addAttribute("todos", todoRepository.findAll());
            return "todos";
        }
    }

    @RequestMapping("/delete-todo/{todoId}")
    @RolesAllowed("ROLE_ADMIN")
    public String deleteTodo(@PathVariable("todoId") String id) {
        todoRepository.delete(id);
        return "redirect:/";
    }

}
