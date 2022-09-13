package solution724;

public class Utility {
    /*
        思路分析
            首先计算数组各项和total。遍历数组并计算当前下标左侧数据元素之和sum_left：判断是否满足
            total = sum_left * 2 + nums[i]，若满足则返回i；否则将nums[i]添加到sum_left。
    */
    public static int getCentralIndex(int[] nums) {
        int total = countTotal(nums); // 计算数组各项和
        int sum_left = 0; // 当前下标左侧数据元素之和

        for (int i = 0; i < nums.length; i++) {
            if (total == sum_left * 2 + nums[i]) {
                return i;
            }

            sum_left += nums[i];
        }

        return -1; // 不存在中心下标
    }

    /*
        计算数组各项和。
    */
    public static int countTotal(int[] nums) {
        int total = 0;
        for (int value : nums) {
            total += value;
        }
        return total;
    }
}
