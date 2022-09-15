package reverse;

public class Solution {
    /*
        将字符串str翻转。
        思路分析
            使用双指针，一个指针从0开始向后遍历，另一个指针从str.length-1开始向
            前遍历，交换，直到前指针>=后指针。
     */
    public static String reverse(String str) {
        // 转化为字符数组
        char[] chars = str.toCharArray();
        char temp = ' ';

        // 双指针遍历交换
        for (int low = 0, high = chars.length - 1; low < high; low++, high--) {
            temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
        }

        return new String(chars);
    }
}
