package repository;

import entity.Todo;

public class TodoRepositoryImpl implements TodoRepository {

    public Todo[] todoList = new Todo[10];

    public boolean isFull() {
        boolean isFull = true;

        for (int i = 0; i < todoList.length; i++) {
            if (todoList[i] == null) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void resizeIsFull() {
        if (isFull()) {
            Todo[] tempTodoList = todoList;
            todoList = new Todo[todoList.length * 2];

            for (int i = 0; i < tempTodoList.length; i++) {
                todoList[i] = tempTodoList[i];
            }
        }
    }

    @Override
    public void addTodo(Todo todo) {
        resizeIsFull();

        for (int i = 0; i < todoList.length; i++) {
            if (todoList[i] == null) {
                todoList[i] = todo;
                break;
            }
        }

    }

    @Override
    public Todo[] getAll() {
        return todoList;
    }
}
