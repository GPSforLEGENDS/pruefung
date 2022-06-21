package xyz.GPSforLEGENDS;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {


        int[] nums1 = {1,3,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,4,6};
        int n = 3;

        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m+n];

        int k = 0;
        outer:
        for(int i = 0; i <= m; i++){
            while(k < n){
                if(i == m || nums2[k] < nums1[i]){
                    tmp[i+k] = nums2[k];
                    k++;
                } else{
                    tmp[i+k] = nums1[i];
                    continue outer;
                }
            }

            if(i != m) tmp[i+k] = nums1[i];
        }

        System.arraycopy(tmp, 0, nums1, 0, m+n);
    }
}
