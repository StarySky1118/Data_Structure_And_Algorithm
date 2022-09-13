package centralindex;

public class Utility {
    /*
        思路分析：遍历数组：计算每一个下标前后元素之和是否相等，如果相等就返回。
    */
    public static int getCentralIndex(int[] nums) {
        int centralIndex = -1; // 默认无中心索引
        int sum_left = 0; // 下标左侧之和
        int sum_right = 0; // 下标右侧之和

        for (int i = 0; i < nums.length; i++) {
            sum_left = 0;
            sum_right = 0;

            // 计算左侧之和
            for (int j = 0; j < i; j++) {
                sum_left += nums[j];
            }

            // 计算右侧之和
            for (int j = i + 1; j < nums.length; j++) {
                sum_right += nums[j];
            }

            if (sum_left == sum_right) {
                centralIndex = i;
                break;
            }
        }

        return centralIndex;
    }
}
