package setzero02;

// 二元组：行+列
public class Tuple {
    private int row; // 元素所在行
    private int col; // 元素所在列

    public Tuple(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
