package xyz.GPSforLEGENDS;

public class RemoveElement {

    public static void main(String[] args) {

    }

    public static int removeElement(int[] nums, int val) {

        int shift = 0;

        for(int i = 0; i < nums.length; i++){
            nums[i-shift] = nums[i];

            if(nums[i] == val){
                shift++;
            }
        }

        return nums.length - shift;
    }
}
