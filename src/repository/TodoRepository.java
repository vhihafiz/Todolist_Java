package repository;

import entity.Todo;

public interface TodoRepository {

    void addTodo(Todo todo);

    Todo[] getAll();

    void updateTodo (Integer id, String todo);

    void deleteTodo(Integer id);



}
