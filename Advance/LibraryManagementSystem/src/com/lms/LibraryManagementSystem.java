package com.lms;
import java.sql.*;
import java.util.Scanner;

public class LibraryManagementSystem {

    static Scanner sc = new Scanner(System.in);

    
     void addBook(Connection con)  {
    	 
    	 
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();
		try {
			con.setAutoCommit(false);
		        String sql = "INSERT INTO Books(title, author, available) VALUES(?,?,true)";
		        PreparedStatement ps = con.prepareStatement(sql);
		
		        ps.setString(1, title);
		        ps.setString(2, author);
		
		        ps.executeUpdate();
		} catch (Exception e) {
            try {
				con.rollback();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        System.out.println("Book added successfully.");
    }

    
     void borrowBook(Connection con)  {

        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();

        System.out.print("Enter User Name: ");
        String userName = sc.next();

        try {
        	con.setAutoCommit(false);
            String sql = "SELECT available FROM Books WHERE id=?";
            PreparedStatement ps1 = con.prepareStatement(sql);
            ps1.setInt(1, bookId);

            ResultSet rs = ps1.executeQuery();

            if (rs.next() && rs.getBoolean("available")) {

                String updateBook = "UPDATE Books SET available=false WHERE id=?";
                PreparedStatement ps2 = con.prepareStatement(updateBook);
                ps2.setInt(1, bookId);
                ps2.executeUpdate();

                String insertTransaction =
                        "INSERT INTO Transactions(book_id,user_id,borrow_date) VALUES(?,?,CURDATE())";

                PreparedStatement ps3 = con.prepareStatement(insertTransaction);
                ps3.setInt(1, bookId);
                ps3.setInt(2, userId);
                ps3.executeUpdate();

                String insertUser =
                        "INSERT INTO users(id,name) VALUES(?,?)";

                PreparedStatement ps4 = con.prepareStatement(insertUser);
                ps4.setInt(1, userId);
                ps4.setString(2, userName);
                ps4.executeUpdate();

                con.commit();
                System.out.println("Book borrowed successfully.");

            } else {
                System.out.println("Book not available.");
                con.rollback();
            }

        } catch (Exception e) {
            try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
       
    }
}