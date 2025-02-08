import java.util.Arrays;

public class AddTwoNumbersUsingArray {

    private static int[] addTwoNumbers(int[] i1,int[] i2){
        int maxLength = Math.max(i1.length, i2.length);
        int[] i3 = new int[maxLength+1];

        int carry = 0;
        int i=i1.length-1; int j=i2.length-1; int k=maxLength;
        int sum =0;

        while(i>=0 || j>=0 || carry!=0){
            sum = carry;

            if(i>=0){
                sum = sum+i1[i--];
            }
            if(j>=0){
                sum = sum+i2[j--];
            }

            carry = sum/10;

            i3[k--]= sum%10;;

        }
        if(i3[0]==0){
            i3 = Arrays.copyOfRange(i3,1,i3.length);
        }

        return i3;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(addTwoNumbers(new int[]{2,4,3}, new int[]{5,6,4})));
    }
}
