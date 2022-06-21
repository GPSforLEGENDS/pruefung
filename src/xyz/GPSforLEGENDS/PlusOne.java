package xyz.GPSforLEGENDS;

public class PlusOne {

    public int[] plusOne(int[] digits) {

        boolean carry = true;
        int arrayPos = digits.length-1;

        while(carry){
            int n = digits[arrayPos];
            n++;

            if(n == 10){
                n = 0;

                if(arrayPos == 0){
                    digits[arrayPos] = n;

                    int[] result = new int[digits.length+1];
                    System.arraycopy(digits, 0, result,1, digits.length);
                    result[0] = 1;
                    return result;
                }

            } else{
                carry = false;
            }
            digits[arrayPos] = n;
            arrayPos--;
        }

        return digits;
    }
}
