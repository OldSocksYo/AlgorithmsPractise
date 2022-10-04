package mianshiti.string;

/**
 * @author : yong
 * create at: 2022/9/3 15:44
 * @Description :滑动窗口解决最长不重复子串
 * 如何判断右边界 right 向右拓展时，其对应的字符和当前找到的子串中没有出现过呢？
 * 一个简单的方法是：设置一个数组记录 ASCII 码出现的频率，这样当 right 向右拓展时，
 * 就可以查找其对应的字符对应的 ASCII 码在该数组中相应的频率值是多少，如果非0，则表示已经有了。
 * 参考：https://zhuanlan.zhihu.com/p/351773348
 **/

public class MaxNotRepeatSubstringDemo {

    public static void main(String[] args) {
        //String str = "abcabb";
        String str = "abc";
        System.out.println(maxNotRepeatSubStr(str));
    }

    static int maxNotRepeatSubStr(String str) {
        int l = 0;
        int r = -1;
        int maxLen = 0;
        int[] ascllArr = new int[256];
        while (l < str.length() && r + 1 <str.length()) {
            if (r + 1 < str.length() && ascllArr[str.charAt(r + 1)] == 0) {
                ascllArr[str.charAt(++r)]++;
            } else {
                ascllArr[str.charAt(l++)]--;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
