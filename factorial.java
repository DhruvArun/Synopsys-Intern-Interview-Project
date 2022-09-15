class Factorial {
    // Iterative
    public static long factorial1(int num) {
        long result = 1;

        for (long i = num; i >= 1; i--) {
            result *= i;
        }

        return result;
    }

    // Recursive
    public static long factorial2(long num) {
        if (num == 0) {
            return 1;
        } 
        else {
            return num * factorial2(num - 1);
        }
    }

    public static void main(String[] args) {
        long result1 = factorial1(25);
        System.out.println(result1);

        long result2 = factorial2(25);
        System.out.println(result2);
    }
}