package setzero02;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
        思路分析
            遍历矩阵，将零元素信息封装到Tuple对象，添加到零元素列表。
            遍历零元素列表，将其对应行和列清零。
    */
    public static void setZero(int[][] matrix) {
        int width = matrix[0].length; // 矩阵宽
        int height = matrix.length; // 矩阵高
        List<Tuple> list = new ArrayList<>(); // 零元素列表

        // 创建零元素列表
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(matrix[i][j] == 0) { // 是零元素
                    list.add(new Tuple(i, j));
                }
            }
        }

        // 清零
        for (int i = 0; i < list.size(); i++) {
            Tuple tuple = list.get(i); // 获取二元组
            int row = tuple.getRow(); // 零元素所在行
            int col = tuple.getCol(); // 零元素所在列

            // 所在行清零
            for (int j = 0; j < width; j++) {
                matrix[row][j] = 0;
            }

            // 所在列清零
            for (int j = 0; j < height; j++) {
                matrix[j][col] = 0;
            }
        }
    }
}
