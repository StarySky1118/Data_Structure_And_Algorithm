package arraysplit;

import java.util.Arrays;

public class Solution {
    /*
        思路分析
            首先将nums顺序改为升序。使用双指针high = nums.length-1,low=high-1，[nums[low],nums[high]]为一个
            划分，将nums[low]添加到总和total中。
     */
    public static int arrayPairSum(int[] nums) {
        int total = 0;

        // 将数组排序
        Arrays.sort(nums);

        // 遍历所需位置求和
        for (int i = nums.length - 2; i >= 0; i -= 2) {
            total += nums[i];
        }

        return total;
    }
}
