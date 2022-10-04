package mianshiti.sort;

import java.util.Arrays;

/**
 * @author : yong
 * create at: 2022/9/3 14:19
 * @Description : 冒泡排序
 * 参考：https://blog.csdn.net/qq_52596258/article/details/120689724
 **/

public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 7, 3, 2};
        System.out.println("冒泡排序前：" + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("冒泡排序后：" + Arrays.toString(arr));
    }
    static void bubbleSort(int[] ints){
        for (int i = ints.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++){
                if(ints[j] > ints[j+1]){
                    int temp = ints[j];
                    ints[j] = ints[j+1];
                    ints[j+1] = temp;
                }
            }
        }
    }
}
