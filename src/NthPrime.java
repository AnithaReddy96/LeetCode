public class NthPrime {


    public static void main(String[] args) {
        int n = 6;
        String s = "123";
        s.matches("^\\d.*");
        System.out.println(n + "th prime number is: " + findNthPrime(n));

    }

    public static int findNthPrime(int n) {
        int count = 0, num = 1;

        while (count <n) {
            num++;
            if (isPrime(num)) {
                count++;
            }
        }
        return num;
    }

  private static boolean isPrime(int num){
        if(num<2) return false;
        if(num==2 || num==3) return true;
        if(num%2==0 || num%3==0) return false;

        for(int i =5;i<=Math.sqrt(num);i++){
            if(num%i==0)
                return false;
        }
        return true;
    }



}
