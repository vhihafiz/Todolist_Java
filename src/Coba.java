import entity.Todo;

public class Coba {
    public static void main(String[] args) {
        Todo[] todoList = new Todo[1];

        Todo todo = new Todo();
        todo.setTodo("coba");

        todoList[0] = todo;


        for (int i = 0; i < 1; i++) {
            if (todoList[0].getTodo() == null) {
                System.out.println("todo kosong");
            } else {
                System.out.println("Todo berisi yaa");
            }
        }


    }

}

