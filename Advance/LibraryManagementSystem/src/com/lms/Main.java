package com.lms;

import java.sql.*;
import java.util.Scanner;

class Main{

public static void main(String[] args) {
	
	LibraryManagementSystem libraryMS=new LibraryManagementSystem();
	Scanner sc = new Scanner(System.in);
	final String URL = "jdbc:mysql://localhost:3306/library_db";
	final String USER = "root";
	final String PASSWORD = "2703";
    
	try {

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            while (true) {

                System.out.println("\n1 Add Book");
                System.out.println("2 Borrow Book");
                System.out.println("3 Exit");

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        libraryMS.addBook(con);
                        break;

                    case 2:
                    	libraryMS.borrowBook(con);
                        break;

                    case 3:
                        return;

                    default:
                        System.out.println("Invalid choice");
                }
            }

       } catch (Exception e) {
            e.printStackTrace();
       }
    }
}