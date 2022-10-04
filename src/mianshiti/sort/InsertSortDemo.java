package mianshiti.sort;

import java.util.Arrays;

/**
 * @author : yong
 * create at: 2022/9/3 14:39
 * @Description : 插入排序
 * 参考：https://blog.csdn.net/qq_52596258/article/details/120689724
 **/

public class InsertSortDemo {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 7, 3, 2, 4};
        System.out.println("插入排序前：" + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("插入排序后：" + Arrays.toString(arr));
    }
    static void insertSort(int[] ints){
        // 先假设左边的有序数组中只有一个元素，就是原数组中的第一个值所以i从1开始（i表示无需数组的第一个元素下标）
        for (int i = 1; i < ints.length; i++) {
            for (int j = i; j > 0; j--) {
                if(ints[j - 1] > ints[j]){
                    int temp = ints[j-1];
                    ints[j-1] = ints[j];
                    ints[j] = temp;
                }
            }
        }
    }
}
