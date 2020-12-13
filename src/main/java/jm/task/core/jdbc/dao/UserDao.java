package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.List;

public interface UserDao {

    String createTableSQL = "create table if not exists users_table"
            + "(user_id int auto_increment,"
            + "name varchar(20) not null,"
            + "lastName varchar(20) not null,"
            + "age int not null,"
            + "primary key (user_id))";
    String dropTableSQL = "drop table users_table";
    String insertUserSQL = "insert into users_table (name, lastName, age) VALUES (?, ?, ?)";
    String getAllUsersSQL = "select * from users_table";
    String removeByIdSQL = "delete from users_table where user_id = ?";
    String cleanTableSQL = "delete from users_table";

    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
