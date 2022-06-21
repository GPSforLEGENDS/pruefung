package xyz.GPSforLEGENDS;

public class ZigZagConversion {

    public static void main(String[] args) {

    }

    //1 2 4 6 8

    public static String convert(String s, int numRows) {

        int next = numRows*2 - 2;
        if(numRows == 1) next = 1;

        int lineLength = (int) Math.ceil(s.length() / (numRows + (Math.max(0, numRows-2))));

        StringBuilder b = new StringBuilder(s.length());

        for(int r = 0; r < numRows; r++){
            for(int c = 0; c < lineLength; c++){

            }
        }



        return null;
    }
}
