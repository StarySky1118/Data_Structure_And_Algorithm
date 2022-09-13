package sparsearray;

import java.io.Serializable;

// 三元组
public class Triple implements Serializable {
    private int row; // 总行数/所在行
    private int col; // 总列数/所在列
    private int value; // 非零值个数/具体值

    public Triple(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Triple{" +
                "row=" + row +
                ", col=" + col +
                ", value=" + value +
                '}';
    }
}
