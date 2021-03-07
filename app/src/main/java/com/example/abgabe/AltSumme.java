package com.example.abgabe;

public class AltSumme {
    public String calculate(String number) {
        int num = Integer.parseInt(number);
        int temp, digit, count = 0;

        //copy input number
        temp = num;

        //count digits
        while (num > 0){
            num = num/10;
            count++;
        }

        //create array based on size of number
        int [] arr = new int [count];

        //read number from behind and fill array from behind
        while (temp > 0){
            digit = temp%10;
            arr[count-1] = digit;
            temp = temp/10;
            count--;
        }
        //Calculate Alternating Sum
        double alternatingSum = 0;

        //Counting together first digit with every second digit;
        if (arr != null || count <arr.length){
            for (int i = 0; i < arr.length; i = i + 2){
                alternatingSum += arr[i];
            }
            //Subtract digit on place two and every second digit from place two
            for (int i = 1; i<arr.length; i = i+2){
                alternatingSum -=arr[i];
            }
        }
        //Creating String if number is even or not and returning the String
        String res = "";
        if (alternatingSum % 2 == 0){
            res = "Die Zahl ist gerade";
            return res;
        }
        else {
            res = "Die Zahl ist ungerade";
            return res;
        }
    }
}
