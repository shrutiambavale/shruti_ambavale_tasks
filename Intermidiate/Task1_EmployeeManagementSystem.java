package Intermidiate;

import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

class Task1_EmployeeManagementSystem {

    ArrayList<Employee> employees = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    void addEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        employees.add(new Employee(id, name, salary));
        System.out.println("Employee added successfully.");
    }

    void viewEmployees() {
        if (!employees.isEmpty()) {
            for (Employee e : employees) {
                System.out.println("-------Employee Details------");
                System.out.println(" ID: " + e.id);
                System.out.println(" Name: " + e.name);
                System.out.println(" Salary: " + e.salary);
            }
        }
    }

    void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();

        for (Employee e : employees) {
            if (e.id == id) {
                System.out.print("Enter new Name: ");
                e.name = sc.next();

                System.out.print("Enter new Salary: ");
                e.salary = sc.nextDouble();

                System.out.println("Employee updated successfully.");
                return;
            }
        }

    }

    void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        Iterator<Employee> itr = employees.iterator();

        while (itr.hasNext()) {
            Employee e = itr.next();
            if (e.id == id) {
                itr.remove();
                System.out.println("Employee deleted successfully.");
            }
        }

    }

    public static void main(String[] args) {

        Task1_EmployeeManagementSystem ems = new Task1_EmployeeManagementSystem();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Add Employee");
            System.out.println("2.View Employees");
            System.out.println("3.Update Employee");
            System.out.println("4.Delete Employee");
            System.out.println("5.Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ems.addEmployee();
                    break;
                case 2:
                    ems.viewEmployees();
                    break;
                case 3:
                    ems.updateEmployee();
                    break;
                case 4:
                    ems.deleteEmployee();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
