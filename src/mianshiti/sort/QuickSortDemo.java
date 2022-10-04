package mianshiti.sort;

import java.util.Arrays;

/**
 * @author : yong
 * create at: 2022/9/3 15:22
 * @Description : 快速排序
 * 参考：https://blog.csdn.net/shujuelin/article/details/82423852
 **/

public class QuickSortDemo {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 7, 3, 6, 2, 4};
        System.out.println("快速排序前：" + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("快速排序后：" + Arrays.toString(arr));
    }
    static void quickSort(int[] ints, int low, int high){
        if(low > high){
            return;
        }
        int i = low;
        int j = high;
        // temp保存基数
        int temp = ints[low];
        while (i < j){
            while (temp <= ints[j] && i < j){
                j--;
            }
            while (temp >= ints[i] && i < j){
                i++;
            }
            if(i < j){
                int t = ints[i];
                ints[i] = ints[j];
                ints[j] = t;
            }
        }
        ints[low] = ints[i];
        ints[i] = temp;
        // 递归处理基数左边的数组
        quickSort(ints, low, i - 1);
        // 递归处理基数右边的数组
        quickSort(ints, i + 1, high);
    }
}
