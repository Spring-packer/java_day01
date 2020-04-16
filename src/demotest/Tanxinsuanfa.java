package demotest;

import java.util.Scanner;

public class Tanxinsuanfa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        /*
         * 思路：贪心算法;
         * 从第一个数开始, 寻找可以一个可以跳最远的点;
         * 例1：3 1 2 4 1 0 0
         * 1.从第一个位置0,可以跳到位置1和位置2和位置3;
         * 2.如果跳到位置1,那么最远就可以跳到位置(1+1);
         * 3.如果跳到位置2,那么最远就可以跳到位置(2+2);
         * 4.如果跳到位置3,那么最远就可以跳到位置(3+4);
         * 5.故选择跳到位置3 ,重复1.2.3步;
         *
         * 算法分析：
         * 1.如果选择跳到位置3 ,就无法跳到位置2和位置3, 那么会不会因此错过最优解？ 答：不会！
         * 2.因为任意位置1和位置2能到达的位置, 位置3都可以到达;
         * 3.故不会错过最优解;
         */
        int[]a = new int[n];
        for(int i= 0 ;i< n ;i++) {
            a[i] = sc.nextInt();
        }
        int i;
        int l;  //左边界       控制搜索的起始位置
        int r;  //右边界       控制搜索的终止位置
        for( i= 0 ;i< n && a[i]!= 0 ;) { //当a[i]==0 时 , 该位置为可到达的最远位置
            r = i + a[i];
            l = i + 1;
            for(int j= i+1 ;j< n && j<= i+a[i] ;j++) {    //
                if(j+a[j] >= r){ //遍历可到达位置 能到达的最远位置
                    r = j+ a[j];    //更新左右边界
                    l = j;
                }
            }
            i = l;  //左边界

        }
        if(i< n-1) {
            System.out.println("false");

        }else{
            System.out.println("true");
        }
    }
}
