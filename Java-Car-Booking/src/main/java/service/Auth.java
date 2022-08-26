package service;

import Utils.UserUtils;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Auth {
    private Scanner sc = new Scanner(System.in);
    private UserUtils userUtils;
    private ArrayList<User> users;

    public Auth(UserUtils userUtils) {
        this.userUtils = userUtils;
        users = userUtils.getUsers();
    }

    public void printAuthMenu() {
        while (true) {
            System.out.println("1.Login");
            System.out.println("2.Register");
            System.out.println("3.Exit");

            int option = sc.nextInt();
            if (option == 1) {
                System.out.println("Name: ");
                String name = sc.next();
                System.out.println("password: ");
                String password = sc.next();

                boolean isUserExist = users.stream().anyMatch(user -> user.getUserName().equals(name));

                if (isUserExist) {
                    User loggedInUser = users.stream().filter
                                    (user -> user.getUserName().equals(name) && (user.getPwd().equals(password))).
                            findFirst().get();
                    userUtils.setLoggedInUser(loggedInUser);
                    System.out.println("Login successful");
                    break;
                } else {
                    System.out.println("Invalid user");
                }

            } else if (option == 2) {
                System.out.println("Name: ");
                String name = sc.next();
                System.out.println("Phone: ");
                long phone = sc.nextLong();
                System.out.println("Password: ");
                String password = sc.next();
                boolean isUserExist = users.stream().anyMatch(user -> user.getUserName().equals(name));

                if (isUserExist) {
                    System.out.println("User already exist");
                } else {
                    User user = new User();
                    user.setId(users.size() + 1);
                    user.setUserName(name);
                    user.setPhone(phone);
                    user.setPwd(password);
                    users.add(user);
                    System.out.println("User registered successfully");
                }
            } else if (option == 3) {
                System.exit(0);
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
}