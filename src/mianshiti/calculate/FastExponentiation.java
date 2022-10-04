package mianshiti.calculate;

/**
 * @author : yong
 * create at: 2022/10/4 9:29
 * @Description : 快速幂
 * 原文：https://blog.csdn.net/qq_19782019/article/details/85621386
 **/

public class FastExponentiation {
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        System.out.println("普通求值：" + ordinaryExponentiation(3, 4));
        System.out.println("快速幂求值：" + fastExponentiation(3, 4));
        long e = System.currentTimeMillis();
        System.out.println("耗时：" + (e - s));
    }

    /**
     * 求base的power次方的结果的<普通做法/>
     * @param base 基数
     * @param power 指数
     * @return base^power的结果
     */
    static long ordinaryExponentiation(int base, int power){
        long result = 1;
        for (int i = 0; i < power; i++) {
            result *= base;
        }
        return result;
    }

    /**
     * 求base的power次方的结果的<快速幂方法/>
     * @param base 基数
     * @param power 指数
     * @return base^power的结果
     */
    static long fastExponentiation(int base, int power){
        long result = 1;
        while (power > 0){
            /*
            // ====================初版=====================
            // <原理说明/>
            // 1.如果power为偶数：base^power = (base^2)^(power/2)
            //   如3^6=3*3*3*3*3*3=(3*3)*(3*3)*(3*3)=(3*3)^3=(3^2)^3
            // 2.如果power为奇数：base^power = base * base^(power - 1)
            //   如3^5=3*3^4
            if(power % 2 == 0){
                power = power / 2;
                base = base * base;
            } else {
                power = power - 1;
                result = result * base;
                power = power / 2;
                base = base * base;
            }*/



           /*
           // ====================改进=====================
           // <原理说明/>
           // 上面的if else中都有power = power / 2;和base = base * base;这两句
           // 然后用int接收时，(power-1)/2 和 power/2 结果一样，可以得到<初版/>中的语句
           // 可以合并为如下样式
           if(power % 2 == 1){
                result = result * base;
            }
            power = power / 2;
            base = base * base;*/


            /*
            //====================终版=====================
           // <原理说明/>
           // 奇数&1为1，偶数&1为0；正数(和负偶数)/2操作等价于有符号右移一位；
           // 然后，&和>>操作效率又会高于%和/，所以最终版如下：
            */
            if((power & 1) == 1){
                result = result * base;
            }
            power = power >> 1;
            base = base * base;
        }
        return result;
    }

}
