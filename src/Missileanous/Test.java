package Missileanous;

public class Test {
    public static void main(String[] args) {
        int N = 26;

        int sum = digitsSum(N);
       int nextDigit = nextDigit(N,sum);
        System.out.println(nextDigit);
        System.out.println(findNextWithSameDigitSum(N));


    }

    public static int digitsSum(int num){
        int sum = 0;
        while(num>0) {
            int digit = num % 10;
            sum = sum+digit;
            num = num / 10;
        }
        return sum;
    }

    public static int nextDigit(int num,int sum){
        int nextDigitSum = 0;
        int nextNum = num+1;
        while(nextDigitSum!=sum){
            nextDigitSum = digitsSum(nextNum);
            if(nextDigitSum==sum){
                return nextNum;
            }
            nextNum++;
        }
        return nextNum;
    }

    public static int findNextWithSameDigitSum(int num){
        int targetSum = digitsSum(num);
        while(digitsSum(++num)!=targetSum);
        return num;
    }
}
