package mianshiti.huaweiod;

import java.util.Scanner;

/**
 * @author : yong
 * create at: 2022/9/3 10:00
 * @Description :
 * 某系统中有一空间连续的内存，被划分成多个大小相同的内存块。内存的使用状态记录在字符串 memory 中，每个内存块的状态用字符 x 或 . 表示，其中：
 * ·         . 表示该内存块空闲；
 * ·         x 表示该内存块被使用，x 为小写字母。
 * 现在可释放其中 最多 cnt 个内存块（即字符串中的 x 变成 .），以获得一块空间连续的、且 最长的 空闲内存，请计算并返回该最长空闲内存的内存块数量。
 * 示例 1：
 * 输入：
 * memory = "..x..x..xx..."
 * cnt = 2
 * 输出：8
 * 解释：
 *
 * 将 memory[2] 与 memory[5] 的内存块释放，可获得从 memory[0] 到 memory[7]、长度为 8 的连续空闲内存；
 * 将 memory[5] 与 memory[8] 的内存块释放，可获得从 memory[3] 到 memory[8]、长度为 6 的连续空闲内存；
 * 将 memory[8] 与 memory[9] 的内存块释放，可获得从 memory[6] 到 memory[12]、长度为 7 的连续空闲内存；
 * 其他释放方式获得的连续空闲内存都小于 8；
 * 因此返回 8。
 * 示例 2：
 * 输入：
 * memory = "....x."
 * cnt = 3
 * 输出：6
 * 示例 3：
 * 输入：
 * memory = "xx.x..xx....x..."
 * cnt = 0
 * 输出：4
 * 提示：0 <= cnt <= memory.length <= 10^5
 * ————————————————
 * 版权声明：本文为CSDN博主「@小码哥」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https:blog.csdn.net/qq_42581175/article/details/125233761
 *
 * 整体思路：分两步
 * 1.先写一个函数，用来计算当前字符串中最大的.的个数
 * 2.再用另一个函数来计算，从前往后，每次替换了cnt个x后的字符串中.的最大个数
 * 注意：这里有一种特殊情况，当cnt的个数大于字符串中的x的个数时，就将字符串中的所有x替换为.后，再计算最大值即可
 **/

public class FindMaxPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入字符串
        String memory = scanner.nextLine();
        // 输入cnt
        int cnt = scanner.nextInt();
        int maxMemory = getMaxMemory(memory, cnt);
        System.out.println(maxMemory);
        scanner.close();
    }

    static int getMaxMemory(String memory, int cnt){
        char[] memChars = memory.toCharArray();
        // 当前轮第一个遇到的x
        int firstX = -1;
        // 当前轮已经计数过的x个数
        // 在这里，我们不真的去替换x，只是把它当做.来计算即可
        int tmpCnt = 0;
        // 当前轮已经计数的.的个数
        int currentCountedPoint = 0;
        // 当前已经完成的所有情况下的最大连续点的个数
        int maxContinuousPoint = 0;
        for (int i = 0; i < memChars.length; i++) {
            if (memChars[i] == '.') {
                currentCountedPoint++;
            } else if (memChars[i] == 'x') {
                if (tmpCnt == 0) {
                    // 记录当前轮中第一个遇到的x
                    firstX = i;
                }
                tmpCnt++;
                if (tmpCnt <= cnt) {
                    currentCountedPoint++;
                } else {
                    // 当前“替换”的x的数量已经超过cnt了，回溯到当前这一轮计数中的第一个x的位置
                    maxContinuousPoint = Math.max(maxContinuousPoint, currentCountedPoint);
                    currentCountedPoint = 0;
                    tmpCnt = 0;
                    i = firstX;
                }
            }
            if ((i+1) == memChars.length) {
                // 当cnt的个数多余memory中实际的x的个数时，防止越界；
                // 当计数到最后一个字符后，用当前已经计数的.来求一次最大的.数
                maxContinuousPoint = Math.max(maxContinuousPoint, currentCountedPoint);
            }
        }
        return maxContinuousPoint;
    }

    //static int getMaxMemory(String memory, int cnt){
    //    char[] chars = memory.toCharArray();
    //    if(cnt == 0){
    //        return findMaxPoint(chars);
    //    }
    //    int max = 0;
    //    int cusRound = 0;
    //    int temp = 0;
    //    while (cusRound < chars.length){
    //        for (int i = cusRound; i < chars.length; i++) {
    //            if(chars[i] == 'x'){
    //                chars[i] = '.';
    //                temp++;
    //            }
    //            // 已经替换了cnt个x后，判断一次最大的.的数量
    //            if(temp == cnt){
    //                max = Math.max(findMaxPoint(chars), max);
    //                // 将chars重置为输入的字符串样式，为下一轮做准备
    //                chars = memory.toCharArray();
    //                //temp 归0
    //                temp = 0;
    //            }
    //        }
    //        //如果cnt大于当前字符串中x的总数，也计算一次将所有x替换为.后的.的最大数量
    //        if(temp < cnt){
    //            max = Math.max(findMaxPoint(chars), max);
    //        }
    //        cusRound ++;
    //    }
    //
    //    return max;
    //}
    //
    //
    ////找出“xxx...xx...x..x..x..”中最大的连续.的数量
    //static int findMaxPoint(char[] chars){
    //    int i = 0; // 记录第几轮查找
    //    int j = 0; // 用来做每轮循环中下标的移动
    //    int max = 0; // 最大的.数量
    //    while (i < chars.length){
    //        int tempMax = 0; //每轮循环中. 的数量
    //        // 如果当前一轮中第一个字符不是.,直接i++，进行下一轮
    //        if(chars[i] != '.'){
    //            i++;
    //            continue;
    //        }
    //        // 用j保存当前轮的第一个.的位置
    //        j = i;
    //        // 循环查找i之后连续的.，并用tempMax保存其个数
    //        while (j < chars.length){
    //            if(chars[j] == '.'){
    //                tempMax++;
    //                j++;
    //            }else{
    //                break;
    //            }
    //        }
    //        max = Math.max(tempMax, max);
    //        i++;
    //    }
    //    return max;
    //}
}
