package hu.greencode.spring.demo.todo;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TodoValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Todo.class) ;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (((Todo)target).getTask().equalsIgnoreCase("work")) {
            errors.rejectValue("task", "iDoNotLikeIt");
        }
    }
}
