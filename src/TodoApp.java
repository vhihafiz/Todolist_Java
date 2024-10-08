import repository.TodoRepository;
import repository.TodoRepositoryImpl;
import service.TodoService;
import service.TodoServiceImpl;
import view.TodoListView;

public class TodoApp {
    public static void main(String[] args) {
        startApp();
    }

    public static void startApp() {
        TodoRepository todoRepository = new TodoRepositoryImpl();
        TodoService todoService = new TodoServiceImpl(todoRepository);
        TodoListView todoListView = new TodoListView(todoService);

        todoListView.menuTodoList();
    }

}
