package mianshiti.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : yong
 * create at: 2022/9/11 8:44
 * @Description : KMP算法，参考博文：https://blog.csdn.net/yyzsir/article/details/89462339
 **/

public class KMPMatching {
    public static void main(String[] args) {
        String str = "abcdeababcdef";
        String patterStr = "ababc";
        System.out.println(kmpMatching(0, str.toCharArray(), patterStr.toCharArray()));
    }

    /**
     *
     * @param start 从主串的start位置开始匹配
     * @param mainStr 主串
     * @param patternStr 模式串
     * @return 模式串成功在主串中匹配的起始位置
     */
    static int kmpMatching(int start, char[] mainStr, char[] patternStr){
        // 获得next数组
        List<Integer> next = getNext(patternStr);
        int i = start;
        int j = 0;
        while (i < mainStr.length && j < patternStr.length){
            if(j == -1 || mainStr[i] == patternStr[j]){
                // mainStr[i] == patternStr[j],则i j都增加1
                i++;
                j++;
            }else {
                // 如果mainStr[i]和patternStr[j]不相等
                // i不变，j = next[j]
                j = next.get(j);
            }
        }
        return j == patternStr.length ? i - j : -1;
    }

    /**
     * 计算模式串的next数组
     * @param pattern 模式串
     * @return next数组
     */
    static List<Integer> getNext(char[] pattern){
        ArrayList<Integer> next = new ArrayList<>();
        int k = -1;
        int j = 0;
        next.add(k);
        while (j < pattern.length){
            if(k == -1 || pattern[j] == pattern[k]){
                k ++;
                j ++;
                next.add(k);
            }else {
                k = next.get(k);
            }
        }
        return next;
    }
}
