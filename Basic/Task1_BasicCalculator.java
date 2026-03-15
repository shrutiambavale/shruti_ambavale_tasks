package Basic;

import java.util.*;

class Calculator {

    static void operations(double num1, double num2, int choice) {

        if (num1 != 0 && num2 != 0) {
            switch (choice) {
                case 1:
                    System.out.println("Addition :" + (num1 + num2));
                    break;
                case 2:
                    System.out.println("Substraction :" + (num1 - num2));
                    break;
                case 3:
                    System.out.println("Multiplication :" + (num1 * num2));
                    break;
                case 4:
                    System.out.println("Division :" + (num1 / num2));
                    break;
                default:
                    System.out.println("Please Enter Correct Choice");
                    break;
            }
        } else {
            System.out.println("Please Enter Correct Number");
        }
    }

    public static void main(String[] s) {

        Scanner sc = new Scanner(System.in);
        double num1 = 1, num2 = 1;
        try {
            System.out.println("Enter Numnber 1: ");
            num1 = sc.nextDouble();
            System.out.println("Enter Numnber 2: ");
            num2 = sc.nextDouble();
        } catch (Exception e) {

            System.out.println("Please Enter Correct Number");
            System.out.println(e.getMessage());
        }
        System.out.println("Enter choice:\n1.Addition\n2.Substraction\n3.Multiplication\n4.Division");
        int choice = sc.nextInt();

        Calculator.operations(num1, num2, choice);
    }
}