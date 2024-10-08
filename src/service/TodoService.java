package service;

public interface TodoService {
    void addTodo(String todo);

    void getAll();

    void updateTodo(Integer id, String newTodo);

    void deleteTodo (Integer id);


}
