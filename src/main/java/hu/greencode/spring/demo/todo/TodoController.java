package hu.greencode.spring.demo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoValidator validator;

    @RequestMapping("/")
    public String todoWelcome(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        model.addAttribute("todo", new Todo());
        return "todos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
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
    public String deleteTodo(@PathVariable("todoId") String id) {
        todoRepository.delete(id);
        return "redirect:/";
    }

}
