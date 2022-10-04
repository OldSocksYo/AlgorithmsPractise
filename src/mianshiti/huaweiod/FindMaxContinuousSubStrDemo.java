package mianshiti.huaweiod;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author : yong
 * create at: 2022/9/4 18:11
 * @Description :
 *  有N个正整数组成的一个序列
 *  给定一个整数sum
 *  求长度最长的的连续子序列使他们的和等于sum
 *  返回次子序列的长度
 *  如果没有满足要求的序列 返回-1
 *  案例1：
 *  输入
 *  1,2,3,4,2
 *  6
 *  输出
 *  3
 *  解析：1,2,3和4,2两个序列均能满足要求
 *  所以最长的连续序列为1,2,3 因此结果为3
 *
 *  示例2：
 *  输入
 *  1,2,3,4,2
 *  20
 *  输出
 *  -1
 *  解释：没有满足要求的子序列，返回-1
 *
 *  备注： 输入序列仅由数字和英文逗号构成
 *  数字之间采用英文逗号分割
 *  序列长度   1<=N<=200
 *  输入序列不考虑异常情况
 *  由题目保证输入序列满足要求
 * ————————————————
 * 版权声明：本文为CSDN博主「chenzm666666」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/m0_46084322/article/details/125476213
 **/

public class FindMaxContinuousSubStrDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int sum = scanner.nextInt();
        System.out.println(findMaxContinuousSubStr(str, sum));
    }
    static int findMaxContinuousSubStr(String str, int sum){
        int maxCount = -1;
        // 将输入的字符串转换为数字
        String[] split = str.split(",");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }
        // 循环从第一个开始依次相加判断是否符合要求
        for (int i = 0; i < list.size(); i++) {
            // 每一轮中，单个数就等于sum
            if(list.get(i) == sum){
                maxCount = Math.max(maxCount, 1);
            }
            // 记录当前这一轮比较中的起始索引
            int start = i;
            int tempSum = 0;
            while (start < list.size()){
                // 将start之后的数字依次相加
                tempSum += list.get(start);
                if(tempSum == sum){
                    maxCount = Math.max(maxCount, start - i + 1);
                }else if(tempSum < sum){
                    start++;
                }else {
                    // tempSum已经大于sum了，就没必要比较了
                    break;
                }
            }
        }
        return maxCount;
    }
}
