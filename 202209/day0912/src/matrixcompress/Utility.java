package matrixcompress;

import java.util.ArrayList;
import java.util.List;

public class Utility {

    /*
        矩阵压缩存储。
        实现思路
            遍历矩阵：每遇到一个非零元素，创建Triple表示之并添加到List。记录总行数、总列数和非零元素的个数，
            修改List首个元素的值。
    */

    /**
     * 压缩矩阵为三元组列表。
     *
     * @param nums       待压缩矩阵
     * @param matrix_row 矩阵行数
     * @param matrix_col 矩阵列数
     * @return 压缩后的三元组列表
     */
    public static List<Triple> compress(int[][] nums, int matrix_row, int matrix_col) {
        List<Triple> list = new ArrayList<>(); // 压缩后列表
        int value = 0; // 遍历矩阵时遇到的元素值
        int non_default_count = 0; // 非默认值元素个数

        // List首元素默认值
        list.add(new Triple(matrix_row, matrix_col, 0));

        // 遍历矩阵
        for (int i = 0; i < matrix_row; i++) {
            for (int j = 0; j < matrix_col; j++) {
                if ((value = nums[i][j]) != 0) { // 遇到非零元素
                    list.add(new Triple(i, j, value)); // 添加非零元素
                    non_default_count++; // 非默认值元素个数++
                }
            }
        }

        // 修改List首元素
        list.get(0).setValue(non_default_count);

        return list;
    }

    /**
     * 压缩矩阵为三元组列表。
     *
     * @param default_value 矩阵默认值
     * @param nums       待压缩矩阵
     * @param matrix_row 矩阵行数
     * @param matrix_col 矩阵列数
     * @return 压缩后的三元组列表
     */
    public static List<Triple> compress(int[][] nums, int matrix_row, int matrix_col, int default_value) {
        List<Triple> list = new ArrayList<>(); // 压缩后列表
        int value = 0; // 遍历矩阵时遇到的元素值
        int non_default_count = 0; // 非默认值元素个数

        // List首元素默认值
        list.add(new Triple(matrix_row, matrix_col, 0));

        // 遍历矩阵
        for (int i = 0; i < matrix_row; i++) {
            for (int j = 0; j < matrix_col; j++) {
                if ((value = nums[i][j]) != default_value) { // 遇到非零元素
                    list.add(new Triple(i, j, value)); // 添加非零元素
                    non_default_count++; // 非默认值元素个数++
                }
            }
        }

        // 修改List首元素
        list.get(0).setValue(non_default_count);

        return list;
    }

    /*
        将压缩后的列表解压缩为矩阵。
        思路分析
            首先从列表首个元素获取矩阵的行数与列数，并由此创建矩阵。遍历列表剩余元素，将非零值填入矩阵。
    */
    /**
     * 将压缩列表解压缩为矩阵。
     * @param list 压缩列表
     * @return 解压缩后的矩阵
     */
    public static int[][] decompress(List<Triple> list) {

        // 获取矩阵行数和列数，创建矩阵
        int[][] nums = new int[list.get(0).getRow()][list.get(0).getCol()];

        // 遍历列表，填入非零值
        for (int i = 1; i < list.size(); i++) {
            Triple triple = list.get(i);
            nums[triple.getRow()][triple.getCol()] = triple.getValue();
        }

        return nums;
    }

    /**
     * 将压缩列表解压缩为矩阵。
     * @param default_value 矩阵默认值
     * @param list 压缩列表
     * @return 解压缩后的矩阵
     */
    public static int[][] decompress(List<Triple> list, int default_value) {

        // 获取矩阵行数和列数，创建矩阵
        int total_row = list.get(0).getRow();
        int total_col = list.get(0).getCol();
        int[][] nums = new int[total_row][total_col];

        // 列表填入默认值
        for (int i = 0; i < total_row; i++) {
            for (int j = 0; j < total_col; j++) {
                nums[i][j] = default_value;
            }
        }

        // 遍历列表，填入非零值
        for (int i = 1; i < list.size(); i++) {
            Triple triple = list.get(i);
            nums[triple.getRow()][triple.getCol()] = triple.getValue();
        }

        return nums;
    }
}
