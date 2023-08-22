public class Recurrence {
    static int factorial(int n){
        int factorial=1;
        if(n==1||n==0){
            return 1;
        }else{
            for (int i=1;i<=n;i++){
                factorial=factorial*i;
            }
            return factorial;
        }
    }
    static int factorialRecursive(int n){
        if (n==1||n==0){
            return 1;
        }
        return n*factorialRecursive(n-1);
    }
    static int fibonacci(int n){
        if (n==1||n==2){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println(factorial(3));
        System.out.println(factorialRecursive(3));
        System.out.println(fibonacci(3));
    }
}
