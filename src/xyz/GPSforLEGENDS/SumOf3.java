package xyz.GPSforLEGENDS;

import java.util.*;

public class SumOf3 {

    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> resultIndices = new HashSet<>();

        HashMap<Integer, List<IntPair>> h = new HashMap<>();

        for(int i = 0; i < nums.length - 1; i++){
            for(int k = i+1; k < nums.length; k++){
                int val = (int) (nums[i] + nums[k] + 10e5);

                if(!h.containsKey(val)){
                    h.put(k, new ArrayList<>());
                }

                h.get(k).add(new IntPair(i, k));
            }
        }

        for(int i = 0; i < nums.length; i++){
            int lookingFor = (int) (nums[i] + 10e5);

            List<IntPair> pairs = h.get(lookingFor);

            if(pairs != null){
                for(IntPair pair : pairs) {
                    List<Integer> solutionIndices = new ArrayList<>();
                    solutionIndices.add(i);
                    solutionIndices.add(pair.a);
                    solutionIndices.add(pair.b);
                    Collections.sort(solutionIndices);

                    resultIndices.add(solutionIndices);
                }
            }
        }

        return null;
    }

    private class IntPair{
        int a;
        int b;

        public IntPair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
}


