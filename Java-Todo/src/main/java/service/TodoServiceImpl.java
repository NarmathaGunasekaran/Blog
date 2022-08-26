package service;

import model.Todo;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoServiceImpl implements TodoService {
    private ArrayList<Todo> todos;
    private Scanner scanner;

    public TodoServiceImpl(ArrayList<Todo> todos, Scanner scanner) {
        this.todos = todos;
        this.scanner = scanner;
    }

    @Override
    public void addTodo() {
        System.out.println("Add Todo");
        System.out.println("*********");
        System.out.println("Enter Your Items");
        String ItemName = scanner.next();
        // todo
        Todo todo = new Todo();
        todo.setId(todos.size() + 1);
        todo.setItemName(ItemName);
        todo.setCompleted(false);
        todos.add(todo);
        System.out.println("********");

    }

    @Override
    public void viewTodo() {
        System.out.println("View Todo");
        System.out.println("********");
        for (Todo todo : todos) {
            System.out.println(todo.getId() + "." + todo.getItemName() +
                   "\n" + "Completed Status-" + (todo.isCompleted() ? "Yes" : "No"));
        }
    }

    @Override
    public void updateTodo() {
        System.out.println("Update Todo");
        System.out.println("********");
        for (Todo todo : todos) {
            System.out.println(todo.getId() + "." + todo.getItemName() +
                    "\n" + "Completed Status-" + (todo.isCompleted() ? "Yes" : "No"));
        }
        System.out.println("Enter your Choice");
        int updateChoice = scanner.nextInt();
        Todo todo = todos.get(updateChoice -1);
        todo.setCompleted(true);
        System.out.println("********");

    }

    public void printMainMenu() {
        while (true) {
            System.out.println("1. Add Todo");
            System.out.println("2. View Todo");
            System.out.println("3. Update Todo");
            System.out.println("4. Exit");
            System.out.println("Enter Your Choice");
            int choice = 0;
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> addTodo();
                    case 2 -> viewTodo();
                    case 3 -> updateTodo();
                    case 4 -> System.exit(0);
                    default -> System.out.println("Invalid choice");
                }
            } catch (Exception exception) {
                System.out.println("Invalid Choice");
                printMainMenu();
            }

        }
    }
}