package peaksoft.service;

import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final static String url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String usere = "postgres";
    private final static String password = "zyinatullo";

    public static Connection connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, usere, password);
            System.out.println("Connected to the PostgreSQL server\n" +
                    "successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }


    public void createUsersTable() {
        try {
            Connection connection = DriverManager.getConnection(url, usere, password);
            Statement statement = connection.createStatement();
            {
                String SQL =
                        "CREATE TABLE usere ("
                                + "id SERIAL PRIMARY KEY,"
                                + "name VARCHAR(30)NOT NULL,"
                                + "last_name VARCHAR (30)NOT NULL,"
                                + "age INT NOT NULL)";

                statement.execute(SQL);
                System.out.println("☼☼☼~~КОШУЛДУ~~☼☼☼:");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void dropUsersTable() {
        String SQL = "DROP  TABLE usere ";
        try{
            Connection connection = connection();
            Statement statement = connection.createStatement();
            statement.executeQuery(SQL);{

                System.out.println("Koshuldu:");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        String SQL = "INSERT INTO usere(name,last_name,age) VALUES (?,?,?)";

        try (
                Connection connection =DriverManager.getConnection(url,usere,password);
                PreparedStatement statement = connection.prepareStatement(SQL)){
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.executeUpdate();
            statement.executeUpdate(SQL);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void removeUserById(long id){
        String SQL = "DELETE FROM usere WHERE id=(?)";
        try{
            Connection connection =DriverManager.getConnection(url,usere,password);
            PreparedStatement statement = connection.prepareStatement(SQL);{
                statement.setInt(1, (int) id);
                ResultSet rs = statement.executeQuery();
                if (rs.next()){
                    System.out.println("id :"+rs.getLong("id"));
                    System.out.println("name:"+rs.getString("name"));
                    System.out.println("lastName:"+rs.getString("lastName"));
                    System.out.println("age:"+rs.getByte("age"));

                }
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }


    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String SQL = "SELECT * FROM usere";
        try (Connection connection = DriverManager.getConnection(url,usere,password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)){
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getByte("age")));

            }
            return users;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public void cleanUsersTable() {
        String SQL = "DELETE FROM usere";
        try (
                Connection connection = DriverManager.getConnection(url, usere, password);
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(SQL))
        {
            while (rs.next()) {
                System.out.println("id:" + rs.getLong("id"));
                System.out.println("Name:" + rs.getString("name"));
                System.out.println("lastName:" + rs.getString("lastName"));
                System.out.println("age:" + rs.getByte("age"));

                rs.close();
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }

    }
}