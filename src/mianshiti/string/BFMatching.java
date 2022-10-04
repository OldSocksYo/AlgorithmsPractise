package mianshiti.string;

/**
 * @author : yong
 * create at: 2022/9/9 21:04
 * @Description : 字串匹配 之 BF算法（暴力循环）
 **/

public class BFMatching {
    public static void main(String[] args) {
        String mainStr = "abcdefghi";
        String patternStr = "def";
        int i = bfMatching(mainStr, patternStr);
        System.out.println(i);
    }
    static int bfMatching(String mainStr, String patternStr){
        char[] mainChars = mainStr.toCharArray();
        char[] patternChars = patternStr.toCharArray();
        int i = 0;
        int j = 0;
        while (i < mainChars.length && j < patternChars.length){
            if(mainChars[i] == patternChars[j]){
                i++;
                j++;
            }else {
                i = i - j + 1;
                j = 0;
            }
        }
        if(j == patternChars.length){
            return i - j;
        }else {
            return -1;
        }
    }
}
