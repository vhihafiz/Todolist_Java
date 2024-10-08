package view;

import service.TodoService;
import util.InputUtil;

public class TodoListView {
    private TodoService todoService;

    public TodoListView(TodoService todoService) {
        this.todoService = todoService;
    }

    public void menuTodoList() {
        boolean isStart = true;

        while (isStart) {
            System.out.println("Menu Todolist: ");
            System.out.println("1. Add Todo");
            System.out.println("2. Get All Todo");
            System.out.println("3. Edit Todo");
            System.out.println("4. Delete Todo");
            System.out.println("X. Exit App");
            String input = InputUtil.input("Choice");


            switch (input) {
                case "1": {
                    menuAdd();
                    break;
                }
                case "2": {
                    todoService.getAll();
                    break;
                }
                case "3": {
                    menuUpdate();
                    break;
                }
                case "4": {
                    menuDelete();
                    break;
                }
                case "X", "x": {
                    isStart = false;
                    break;
                }
                default: {
                    System.out.println("Please select a valid option!");
                    break;
                }
            }
        }

    }

    public void menuAdd() {
        System.out.println("Menu Add Todo");
        System.out.println("X or x (FOR CANCEL)");
        String input = InputUtil.input("Input Todo");

        if (input.equals("x") || input.equals("X")) {
            return;
        } else {
            todoService.addTodo(input);
        }

    }

    public void menuGetAll() {
        todoService.getAll();
    }

    public void menuUpdate() {
        System.out.println("Menu Update Todo");
        System.out.println("X or x (FOR CANCEL)");

        String id = InputUtil.input("Id");

        if (id.equals("x") || id.equals("X")) {
            return;
        }

        String newTodo = InputUtil.input("New Todo");

        if (newTodo.equals("x") || newTodo.equals("X")) {
            return;
        }

        Integer idTodo = Integer.valueOf(id);
        todoService.updateTodo(idTodo, newTodo);
    }

    public void menuDelete() {
        System.out.println("Menu Delete Todo");
        System.out.println("X or x (FOR CANCEL)");

        String id = InputUtil.input("Id");
        if (id.equals("x") || id.equals("X")) {return ;}

        Integer idTodo = Integer.valueOf(id);
        todoService.deleteTodo(idTodo);

    }

}
