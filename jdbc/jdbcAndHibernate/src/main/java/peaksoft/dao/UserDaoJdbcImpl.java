package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.service.UserServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    UserServiceImpl service = new UserServiceImpl();
    public void createUsersTable() {
        service.createUsersTable();
    }

    public void dropUsersTable() {
        service.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        service.saveUser(name,lastName,age);

    }

    public void removeUserById(long id) {
        service.removeUserById(id);

    }

    public List<User> getAllUsers() {
        service.getAllUsers();
        return null;

    }

    public void cleanUsersTable() {
       service .cleanUsersTable();
    }
}