package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        Consumer<Integer> con = new Consumer<Integer>() {
            @Override
            public void accept(Integer num) {
                System.out.println(num);
            }
        };

        Predicate<Integer> pred = new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i%2==0;
            }
        };

        Function<Integer, Integer> fun = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer num) {
                return num * 2;
            }
        };

        BinaryOperator<Integer> bi = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer c, Integer e) {
                return c + e;
            }
        };



        // Sum of double of even numbers
        List<Integer> nums = Arrays.asList(4,6,7,2,1,8,3); // 4 6 2 8 // 8 12 4 16 // 40

        Stream<Integer> s1 = nums.stream();
        Stream<Integer> s2 = s1.filter(i -> i%2==0); // we have to pass obj of Predicate
        Stream<Integer> s3 = s2.map(i -> i * 2);
        s3.forEach(i -> System.out.println(i));



        nums.forEach(num -> System.out.println(num));



//        int sum = nums.stream()
//                .filter(i -> i%2==0)  //  c e
//                .map(i -> i*2)        // 24 16
//                .reduce(0, (c, e) -> c+e);
//
//        System.out.println(sum);



    }
}


//int sum = nums.stream().filter(i -> i%2==0).map(i -> i*2).reduce(0, (c,e) -> c+e);

 //   int sum = 0;
//        for(int num : nums)
//        {
//            if(num%2==0)
//            {
//                num = num * 2;
//                sum = sum + num;
//            }
//        }
//
//        System.out.println(sum);