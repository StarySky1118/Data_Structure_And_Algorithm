package minlength;

public class Solution {
    public static int minSubArrayLen(int target, int[] nums) {
        int minLength = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= target) { // 单个元素大于target情况
                if(minLength == 0) {
                    minLength = 1;
                } else {
                    minLength = 1 < minLength ? 1 : minLength;
                }
                continue;
            }
            int total = nums[i]; // 计算总和
            int j;
            for(j = i + 1; j < nums.length; j++) {
                total += nums[j]; // 求和
                if(total >= target) {
                    int length = j - i + 1;
                    if(minLength == 0) {
                        minLength = length;
                    } else {
                        minLength = length < minLength ? length : minLength;
                    }
                    break; // 停止向后遍历
                }
            }
            if(j == nums.length) { // 从i开始后面所有数相加都不能达到target
                break;
            }
        }

        return minLength;
    }
}
