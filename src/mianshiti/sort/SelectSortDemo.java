package mianshiti.sort;

import java.util.Arrays;

/**
 * @author : yong
 * create at: 2022/9/3 14:28
 * @Description : 选择排序
 * 参考：https://blog.csdn.net/qq_52596258/article/details/120689724
 **/

public class SelectSortDemo {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 7, 3, 2, 4};
        System.out.println("选择排序前：" + Arrays.toString(arr));
        selectSort(arr);
        System.out.println("选择排序后：" + Arrays.toString(arr));
    }
    static void selectSort(int[] ints){
        for (int i = 0; i < ints.length; i++) {
            // index保存剩余数据中最小的值的下标，初始假设i最小
            int index = i;
            // 获取剩余数据中最小的值，用index保存其下标
            for(int j = i+1; j < ints.length; j++){
                if(ints[index] > ints[j]){
                    index = j;
                }
            }
            if(index != i){
                int temp = ints[i];
                ints[i] = ints[index];
                ints[index] = temp;
            }
        }
    }
}
