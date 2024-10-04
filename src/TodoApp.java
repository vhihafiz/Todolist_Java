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

    public static void main(String[] args) {
        testDeleteTodo();
    }

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
        for (int i = 0; i < todoList.length; i++) {
            if (todoList[i] != null) {
                System.out.println((i + 1) + ". " + todoList[i]);
            }
        }
    }

    public static void deleteTodo(int id) {
        if (id > 0) {
            id -= 1;

            for (int i = id; i < todoList.length; i++) {
                if (i == todoList.length - 1) {
                    todoList[i] = null;
                } else {
                    todoList[i] = todoList[i+1];
                }
            }
        } else if (todoList[0] == null) {
            System.out.println("Todolist now is empty, there is nothing to delete");
        } else if (id <= 0) {
            System.out.println("Todo is start from 1");
        } else if (id > todoList.length) {
            System.out.println("Cannot delete, todo length maximum number is " + todoList.length);
        } else if (todoList[id - 1] == null) {
            for (int i = 0; i < todoList.length; i++) {
                if (todoList[i] == null) {
                    System.out.printf("Cannot delete id: %d, because Todo number only %d", id, i);
                    break;
                }
            }
        }
    }

    public static String scannerUtil(String info) {
        System.out.printf("%s: ", info);
        String input = scanner.nextLine();
        return input;
    }

}
