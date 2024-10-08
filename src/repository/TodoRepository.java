package repository;

import entity.Todo;

public interface TodoRepository {

    void addTodo(Todo todo);

    Todo[] getAll();

}
