package sparsearray;

import java.io.*;
import java.util.List;

// 压缩工具
public class CompressUtility {

    /*
        思路分析：遍历整个二维数组，每遇到一个非零值，新建Triple对象加入Array_After_Compression，
        并记录非零值。
    */

    /**
     * 不存盘压缩，直接返回压缩后的集合对象。
     *
     * @param arrays 待压缩数组
     * @param n      数组维数
     * @return 压缩后的集合对象
     */
    public static Array_After_Compression compress(int[][] arrays, int n) {
        if (arrays == null) {
            throw new NullPointerException("数组不能为空！");
        }

        if (n <= 0) {
            throw new DimensionException("数组维度异常");
        }

        Array_After_Compression array_after_compression = new Array_After_Compression();
        array_after_compression.list.add(new Triple(n, n, 0)); // 非零值个数暂定0
        int nonzero_count = 0; // 记录非零值个数

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = 0;
                if ((value = arrays[i][j]) != 0) { // 值非零
                    nonzero_count++;
                    array_after_compression.list.add(new Triple(i, j, value));
                }
            }
        }

        // 遍历结束，需要修改非零值个数
        array_after_compression.list.get(0).setValue(nonzero_count);

        return array_after_compression;
    }

    /*
        保存对象方法。
    */
    public static void save(String filePath, Object object) {
        if (filePath == null) {
            throw new NullPointerException("文件路径不能为空！");
        }

        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeObject(object);
            System.out.println("写入成功！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 关流
            try {
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    /*
        思路分析：根据压缩数组首行创建并初始化二维数组，根据压缩数组后面若干行修改二维数组。
    */
    public static int[][] decompress(Array_After_Compression array_after_compression) {
        if (array_after_compression == null) {
            throw new NullPointerException("压缩数组不能为空！");
        }

        List<Triple> list = array_after_compression.list; // 获取压缩数组
        Triple triple = null;
        int row = 0;
        int col = 0;
        int value = 0;
        int[][] nums = null;

        // 根据list首个三元组获取原数组相关信息
        triple = list.get(0);
        row = triple.getRow();
        col = triple.getCol();
        int valueNum = triple.getValue();
        nums = new int[row][col];
//        for (int i = 0; i < row; i++) { // 初始化
//            for (int j = 0; j < col; j++) {
//                nums[i][j] = 0;
//            }
//        }

        // 遍历剩余的三元组填充原数组
        for (int i = 1; i <= valueNum; i++) {
            triple = list.get(i);
            row = triple.getRow();
            col = triple.getCol();
            value = triple.getValue();
            nums[row][col] = value;
        }

        return nums;
    }

    /*
        从文件中读取Array_After_Compression对象
    */
    public static Array_After_Compression load(String filePath) {
        if (filePath == null) {
            throw new NullPointerException("文件路径不能为空！");
        }

        ObjectInputStream ois = null;

        Array_After_Compression array_after_compression = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(filePath));
            // 读取对象
            array_after_compression = (Array_After_Compression) ois.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("对应的类没有找到！");
        } finally {
            // 关流
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return array_after_compression;
    }
}
