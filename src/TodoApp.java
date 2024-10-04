import java.util.Scanner;

public class TodoApp {

    public static Scanner scanner = new Scanner(System.in);
    public static String[] todoList = new String[10];

    // Test Feature Here
    public static void testAddTodo() {
        for (int i = 1; i <= 11; i++) {
            addTodo("Coba " + i);
        }

        viewTodo();
    }

    public static void main(String[] args) {
        testAddTodo();
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

    public static String scannerUtil(String info) {
        System.out.printf("%s: ", info);
        String input = scanner.nextLine();
        return input;
    }

}
