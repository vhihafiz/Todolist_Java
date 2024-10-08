package test;

import repository.TodoRepository;
import repository.TodoRepositoryImpl;
import service.TodoService;
import service.TodoServiceImpl;

public class TestTodoRepository {
    public static void main(String[] args) {
//        testAddTodo();
//        testGetAllTodo();
    }

    public static void testAddTodo() {
        TodoRepository todoRepository = new TodoRepositoryImpl();
        TodoService todoService = new TodoServiceImpl(todoRepository);

        todoService.addTodo("CobaTodo");
        todoService.addTodo("CobaTodo2");
        todoService.addTodo("CobaTodo3");

        todoService.getAll();



    }

    public static void testGetAllTodo() {
        TodoRepository todoRepository = new TodoRepositoryImpl();
        TodoService todoService = new TodoServiceImpl(todoRepository);

        todoService.addTodo("CobaTodo");
        todoService.addTodo("CobaTodo");
        todoService.addTodo("CobaTodo");

        todoService.getAll();
    }
}
