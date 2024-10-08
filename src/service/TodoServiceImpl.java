package service;

import entity.Todo;
import repository.TodoRepository;
import repository.TodoRepositoryImpl;

public class TodoServiceImpl implements TodoService{
    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    @Override
    public void addTodo(String todo) {
        Todo newTodo = new Todo(todo);
        todoRepository.addTodo(newTodo);
    }

    @Override
    public void getAll() {
        Todo[] todos = todoRepository.getAll();

        for (int i = 0; i < todos.length; i++) {
            if (todos[i] != null) {
                System.out.println((i+1) + ". " + todos[i].getTodo());
            }
        }

    }


    @Override
    public void updateTodo(Integer id, String newTodo) {
        todoRepository.updateTodo(id, newTodo);
    }

    @Override
    public void deleteTodo(Integer id) {
        todoRepository.deleteTodo(id);
    }
}
