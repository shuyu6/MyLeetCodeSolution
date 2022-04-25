import java.util.*;

public class Question15 {
    public static void main(String[] args) {
        var solution = new Solution();
        var test1 = new int[]{1,-1,2,-2,0};
        var test2 = new int[]{-1,0,1,2,-1,-4};

        System.out.println("Test 1: "+solution.threeSumBruteForce(test1));
        System.out.println("Test 2: "+solution.threeSumBruteForce(test2));
        System.out.println("Test 1 (2 pointer): "+solution.threeSum2Pointer(test1));
        System.out.println("Test 2 (2 pointer): "+solution.threeSum2Pointer(test2));
    }
    static class Solution {
        //O(n^3)
        public List<List<Integer>> threeSumBruteForce(int[] nums) {
            if(nums.length==0) return new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();

            for(int i=0;i<nums.length;i++){
                for (int j=i+1;j<nums.length;j++){
                    for (int k=j+1;k<nums.length;k++) {
                        if (nums[i]+nums[j]+nums[k] == 0){
                            result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        }
                    }
                }
            }
            return result;
        }

        // O(n^2)
        public List<List<Integer>> threeSum2Pointer(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if(nums.length<3) return result;

            // first sort the arrray
            Arrays.sort(nums);

            // left is 0, right is nums size
            for(int i=0; i<nums.length-2;i++){
                // prevent duplicated number
                if (i>0 && nums[i]==nums[i-1]) continue;
                // ignore the left if the current number already bigger than 0
                if (nums[i]>0) break;

                int l=i+1;  // left number
                int r = nums.length-1; // right
                while (l<r){
                    int sum = nums[i]+nums[l]+nums[r];
                    // right number is too big so move to left
                    if (sum>0){
                        r--;
                    }else if (sum < 0){
                        // left number is too small so move to right
                        l++;
                    }else{
                        result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        // remove duplicated number
                        while (l<r && nums[l]==nums[l+1]) l++;
                        while (l<r && nums[r]==nums[r-1]) r--;

                        l++;
                        r--;
                    }

                }
            }

            return result;
        }
    }
}
