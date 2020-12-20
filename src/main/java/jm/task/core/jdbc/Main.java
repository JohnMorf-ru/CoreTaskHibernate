package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.dropUsersTable();
        userService.createUsersTable();

        List<User> list = Arrays.asList(new User("Jessy", "Pinkman", (byte) 29)
                , new User("Walter", "White", (byte) 53)
                , new User("Soul", "Goodman", (byte) 49)
                , new User("Gustavo", "Frink", (byte) 50));
        list.forEach((x) -> userService.saveUser(x.getName(), x.getLastName(), x.getAge()));

        userService.getAllUsers().forEach(System.out::println);

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
