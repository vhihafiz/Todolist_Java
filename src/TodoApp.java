import java.util.Scanner;

public class TodoApp {

    public static Scanner scanner = new Scanner(System.in);
    public static String[] todoList = new String[10];

    // Test Feature Here
    public static void testAddTodo() {
        for (int i = 1; i <= 5; i++) {
            addTodo("Coba " + i);
        }
    }

    public static void testDeleteTodo() {
        testAddTodo();
        deleteTodo(3);
        deleteTodo(1);
        viewTodo();
    }

    public static void testUpdateTodo() {
        testAddTodo();
        updateTodo(11, "Update");
        updateTodo(3, "Update");
        viewTodo();
    }

    // Test Menu
    public static void testMenuAdd() {
        menuAdd();
        viewTodo();
    }

    public static void testMenuUpdate() {
        testAddTodo();
        menuUpdate();
        viewTodo();
    }

    public static void testMenuDeleteTodo() {
        testAddTodo();
        menuDelete();
        viewTodo();
    }


    public static void main(String[] args) {

        menuTodoApp();
    }

    // Main Menu
    public static void menuTodoApp() {
        boolean isStart = true;

        while (isStart) {
            System.out.println("Welcome to TodoApp");
            System.out.println("1. Add Todo");
            System.out.println("2. Get All Todo");
            System.out.println("3. Update Todo");
            System.out.println("4. Delete Todo");
            System.out.println("X. Exit App");

            String input = scannerUtil("Choice");

            switch (input) {
                case "1" -> menuAdd();
                case "2" -> viewTodo();
                case "3" -> menuUpdate();
                case "4" -> menuDelete();
                case "x" -> isStart = false;
                case "X" -> isStart = false;

            }

        }

    }


    // CRUD todoApp

    public static void addTodo(String todo) {
        boolean isFull = true;

        for (int i = 0; i < todoList.length; i++) {
            if (todoList[i] == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            String[] tempTodoList = todoList;
            todoList = new String[todoList.length * 2];

            for (int i = 0; i < tempTodoList.length; i++) {
                todoList[i] = tempTodoList[i];
            }
        }

        for (int i = 0; i < todoList.length; i++) {
            if (todoList[i] == null) {
                todoList[i] = todo;
                break;
            }
        }


    }

    public static void viewTodo() {
        System.out.println("Todo List: ");
        for (int i = 0; i < todoList.length; i++) {
            if (todoList[i] != null) {
                System.out.println((i + 1) + ". " + todoList[i]);
            }
        }
    }

    public static void deleteTodo(int id) {
        if (id > 0 && id < todoList.length && todoList[id - 1] != null) {
            for (int i = (id - 1); i < todoList.length; i++) {
                if (i == todoList.length - 1) {
                    todoList[i] = null;
                } else {
                    todoList[i] = todoList[i + 1];
                }
            }
        } else if (todoList[0] == null) {
            System.out.println("Todolist now is empty, there is nothing to delete");
        } else if (id <= 0) {
            System.out.println("Todo is start from 1");
        } else if (id > todoList.length) {
            System.out.println("Cannot delete id: " + id + ", todo length maximum number is " + todoList.length);
        } else if (todoList[id - 1] == null) {
            for (int i = 0; i < todoList.length; i++) {
                if (todoList[i] == null) {
                    System.out.println("Cannot delete id: " + id + ", because Todo number only " + i);
                    break;
                }
            }
        }
    }

    public static void updateTodo(int id, String newTodo) {
        if (id > 0 && id < todoList.length && todoList[id - 1] != null) {
            todoList[id - 1] = newTodo;
        } else if (todoList[0] == null) {
            System.out.println("Todolist now is empty, there is nothing to update");
        } else if (id <= 0) {
            System.out.println("Todo is start from 1");
        } else if (id > todoList.length) {
            System.out.println("Cannot update id: " + id + ", todo length maximum number is " + todoList.length);
        } else if (todoList[id - 1] == null) {
            for (int i = 0; i < todoList.length; i++) {
                if (todoList[i] == null) {
                    System.out.println("Cannot delete id: " + id + ", because Todo number only " + i);
                    break;
                }
            }
        }
    }

    // Menu
    public static void menuAdd() {
        System.out.println("Menu Add Todo");
        String input = scannerUtil("Todo (Type X or x for CANCEL)");

        if (input.equals("x") || input.equals("X")) {
            return;
        } else {
            addTodo(input);
        }
    }

    public static void menuUpdate() {
        viewTodo();
        System.out.println("Menu Update Todo");

        String input = scannerUtil("Update id (Type X or x for CANCEL)");
        String updatedTodo = scannerUtil("Update Todo (Type X or x for CANCEL)");

        if (input.equals("x") || input.equals("X")) {
            return;
        } else {
            int id = Integer.parseInt(input);
            updateTodo(id, updatedTodo);
        }
    }

    public static void menuDelete() {
        viewTodo();
        System.out.println("Menu Delete Todo");

        String input = scannerUtil("Delete id (Type X or x for CANCEL)");

        if (input.equals("x") || input.equals("X")) {
            return;
        } else {
            int id = Integer.parseInt(input);
            deleteTodo(id);
        }
    }


    // Util
    public static String scannerUtil(String info) {
        System.out.printf("%s: ", info);
        String input = scanner.nextLine();
        return input;
    }

}
