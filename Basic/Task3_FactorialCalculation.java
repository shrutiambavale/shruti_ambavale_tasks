package Basic;

import java.util.Scanner;

class FactorialCalculation {

    static int factorial(int num, int result) {
        if (num == 1) {
            return result;
        } else {
            result = num * factorial(num - 1, result);
            return result;
        }
    }

    public static void main(String[] args) {

        int result = 1;
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(FactorialCalculation.factorial(num, result));
    }
}
