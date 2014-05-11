package hu.greencode.spring.demo.todo;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TodoRepositoryImpl implements TodoRepository {

    private Map<String, Todo> todos = new HashMap<String, Todo>();

    @Override
    public void save(Todo todo) {
        todos.put(todo.getId(), todo);
    }

    @Override
    public Todo find(String id) {
        return todos.get(id);
    }

    @Override
    public Collection<Todo> findAll() {
        return todos.values();
    }

    @Override
    public void delete(String id) {
        todos.remove(id);
    }
}
