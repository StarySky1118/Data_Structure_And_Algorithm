package sparsearray;

import java.util.ArrayList;
import java.util.Iterator;

public class CompressTest {
    public static void main(String[] args) {

        int[][] nums = new int[9][9];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                nums[i][j] = 0;
            }
        }

        nums[1][1] = 1;
        nums[2][2] = 2;
        nums[3][3] = 3;

        Array_After_Compression array_after_compression = CompressUtility.compress(nums, 9);
        Array_After_Compression array_after_compression1 = null;

        String filePath = "Z:\\CompressArray.dat";

        CompressUtility.save(filePath, array_after_compression);

        array_after_compression1 = CompressUtility.load(filePath);


//        Iterator<Triple> iterator = array_after_compression.list.iterator();
//        while (iterator.hasNext()) {
//            Triple next =  iterator.next();
//            System.out.println(next);
//        }
//
//        int[][] nums02;
//        nums02 = CompressUtility.decompress(array_after_compression);


    }
}
