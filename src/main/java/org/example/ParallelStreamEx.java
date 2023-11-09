package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParallelStreamEx {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(10000);

        for(int i=1;i<=10000;i++){
            nums.add(i);
        }

        long startSeq = System.currentTimeMillis();

        int sum1 = nums.stream()
                .filter(i -> i%2==0)
                .map(i -> {
                    try { Thread.sleep(1);} catch (InterruptedException e) {}
                    return i*2;
                })
                .reduce(0, (c,e) -> c+e);

        long endSeq = System.currentTimeMillis();

        System.out.println(sum1 + " : " + (endSeq-startSeq) + " ms Seq");

        long startPara = System.currentTimeMillis();
        int sum2 = nums.parallelStream()
                .filter(i -> i%2==0)
                .map(i -> {
                    try { Thread.sleep(1);} catch (InterruptedException e) {}
                    return i*2;
                })
                .reduce(0, Integer::sum);
        long endPara = System.currentTimeMillis();

        System.out.println(sum2 + " : " + (endPara-startPara) + " ms Para");


        int sum3 = nums.stream()
                .filter(i -> i%2==0)
                .map(i -> i*2)
                .mapToInt(i -> i)
                .sum();

        System.out.println(sum3);


    }
}
