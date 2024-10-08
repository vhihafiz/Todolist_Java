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
                System.out.println("Success add todo: " + todo.getTodo() + ", with id: " + (i+1));
                break;
            }
        }

    }

    @Override
    public Todo[] getAll() {
        return todoList;
    }

    @Override
    public void updateTodo(Integer id, String newTodo) {
        if (id > 0 && id < todoList.length && todoList[id - 1] != null) {
            String oldTodo = todoList[id-1].getTodo();
            todoList[id - 1].setTodo(newTodo);
            String todo = todoList[id-1].getTodo();

            System.out.println("Success update todo with id: " + id + " from: " + oldTodo + " to: " + newTodo);

        } else if (id <= 0) {
            System.out.println("Todo is start from 1");
        } else if (id > todoList.length) {
            System.out.println("Cannot delete id: " + id + ", todo length maximum number is " + todoList.length);
        } else if (todoList[0] == null) {
            System.out.println("Todolist now is empty, there is nothing to delete");
        } else if (todoList[id - 1] == null) {
            for (int i = 0; i < todoList.length; i++) {
                if (todoList[i] == null) {
                    System.out.println("Cannot delete id: " + id + ", because Todo number only " + i);
                    break;
                }
            }
        }
    }

    @Override
    public void deleteTodo(Integer id) {
        if (id > 0 && id < todoList.length && todoList[id - 1] != null) {
            String todoDeleted = todoList[id - 1].getTodo();
            for (int i = (id - 1); i < todoList.length; i++) {
                if (i == todoList.length - 1) {
                    todoList[i] = null;
                } else {
                    todoList[i] = todoList[i + 1];
                }
            }
            System.out.println("Success delete todo id: " + id + " with name: " + todoDeleted);
        } else if (id <= 0) {
            System.out.println("Todo is start from 1");
        } else if (id > todoList.length) {
            System.out.println("Cannot delete id: " + id + ", todo length maximum number is " + todoList.length);
        } else if (todoList[0] == null) {
            System.out.println("Todolist now is empty, there is nothing to delete");
        } else if (todoList[id - 1] == null) {
            for (int i = 0; i < todoList.length; i++) {
                if (todoList[i] == null) {
                    System.out.println("Cannot delete id: " + id + ", because Todo number only " + i);
                    break;
                }
            }
        }
    }
}
