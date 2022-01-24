package peaksoft;

import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl service = new UserServiceImpl();
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        System.out.println("☺☺☺~~БИР САНДЫ ТАНДАНЫЗ~~☺☺☺");

        while (true) {
            int a = scanner.nextInt();
            String b = scanner.nextLine();
            switch (a){
                case 1 :
                    service.createUsersTable();
                    break;
                case 2:
                    service.dropUsersTable();
                    break;
                case 3:
                    System.out.println("☺☺☺~~ИЙГИЛИКТУУ КОШУЛДУ~~☺☺☺");
                    System.out.println("name");
                    String name = scanner.nextLine();
                    System.out.println("lastName");
                    String lastName = scanner.nextLine();
                    System.out.println("age");
                    byte age = scanner.nextByte();
                    service.saveUser(name, lastName,age);
                    break;
                case 4:
                    System.out.println("♣♣♣~~КАЙСЫЛ ~'ID'~ ОЧУРОСУЗ~~♣♣♣");
                    long id = scanner.nextByte();
                    service.removeUserById(id);
                    System.out.println("♥♥♥♥~~СИЗ ТАНДАГАН ~'ID'~ ИЙГИЛИКТУУ ОЧТУ~~♥♥♥♥");
                    break;
                case 5:
                    System.out.println(service.getAllUsers());
                    break;
                case 6:
                    service.cleanUsersTable();
                    break;
                default:
                    System.out.println("☺☺☺~~АНДАЙ АДРЕС СИЗДЕ ЖОК~~☺☺☺");
                    System.out.println("☻☻☻~~TАНДАГАН САНЫНЫЗДАН КИЧИНЕ САНДАРДЫ ТАНДАП КОРУНУЗ~~☻☻☻");

            }
        }
    }
}