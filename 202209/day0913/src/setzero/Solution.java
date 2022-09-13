package setzero;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
        思路分析
            首先确定每个零元素的位置，遍历这些零元素将其所在行和列清零。
    */
    public void setZeroes(int[][] matrix) {
        int width = matrix[0].length; // 获取矩阵宽度
        int height = matrix.length; // 获取矩阵高度

        List<Tuple> list = new ArrayList(); // 零元素二元组列表

        // 确定每个零元素的位置
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(matrix[i][j] == 0) {
                    list.add(new Tuple(i, j));
                }
            }
        }

        // 清零
        for(int i = 0; i < list.size(); i++) {
            // 获取零元素位置
            Tuple tuple = list.get(i);
            int row = tuple.row;
            int col = tuple.col;

            // 所在行清零
            for(int j = 0; j < width; j++) {
                matrix[row][j] = 0;
            }

            // 所在列清零
            for(int j = 0; j < height; j++) {
                matrix[j][col] = 0;
            }
        }
    }

    // 行列二元组
    class Tuple {
        private int row; // 行
        private int col; // 列

        private Tuple(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
