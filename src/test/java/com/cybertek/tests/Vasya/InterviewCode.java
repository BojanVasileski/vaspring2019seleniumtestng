package com.cybertek.tests.Vasya;

public class InterviewCode {
    public static void main(String[] args) {

        int num = 435;
        System.out.println(reverseInteger(num));
    }
    //write a method that will calculate some of all digits
    public static int sumAll(int num){
        int sum = 0;

        while (num > 0) {
            sum += num%10;
            num /= 10;  //get rid of last digit

        }
        return sum;
    }
    //reverse integer without converting it to string
    public static int reverseInteger(int num){
        int reverse = 0;
        int remainder = 0;
        while (num > 0) {
            remainder = num%10;                     // to get last digit
            reverse = reverse*10 + remainder;       //concat digits
            num = num/10;                           //to get rid of last digit
        }

        return reverse;
    }

    //write a method that can insert number into
    //array under specific position

    public static int[] addItemIntoArray(int[] arr, int num, int position) {

        int[] newArr = new int[arr.length + 1];

        for (int i = 0,j=0; i < newArr.length; i++,j++) {
            if (i == position) {
                newArr[i]=num;
                j--;
            } else {
                newArr[i]=arr[j];
            }

        }

        return null;
    }

}
