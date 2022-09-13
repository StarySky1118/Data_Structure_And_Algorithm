package matrixcompress;

import java.util.List;

public class CompressTest {
    public static void main(String[] args) {
        int[][] nums = new int[8][9];

        // 修改矩阵默认值为100
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                nums[i][j] = 100;
            }
        }

        nums[0][0] = 1;
        nums[1][1] = 2;
        nums[2][2] = 3;

        List<Triple> list = Utility.compress(nums, nums.length, nums[0].length, 100);

        int[][] nums1 = Utility.decompress(list);
    }
}
