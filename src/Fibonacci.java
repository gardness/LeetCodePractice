public class Fibonacci {

    public static void fibonacci(int n) {
        int[] res = new int[n];
        res[1] = 1;
        res[2] = 1;

        System.out.print(res[1]);
        System.out.print(" " + res[2]);

        for (int i = 3; i < n; i++) {
            res[i] = res[i - 1] + res[i - 2];
            System.out.print(" " + res[i]);
        }

        System.out.println();
    }

    public static void fibonacci2(int n) {
        int num1 = 1;
        int num2 = 1;
        int num3 = 0;

        System.out.print(num1);
        System.out.print(" " + num2);

        for (int i = 1; i < n; i++) {
            num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
            System.out.print(" " + num3);
        }

        System.out.println();
    }

    public static int fibonacci3(int n) {
        if(n == 1 || n == 2) {
            return i;
        } else {
            return fibonacci3(n - 1) + fibonacci3(n - 2);
        }
    }

}
