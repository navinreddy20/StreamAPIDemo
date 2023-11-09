package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalEx {
    public static void main(String[] args) {


        List<String> names = Arrays.asList("Navin", "Shveta", "Ashim", "Jo", "Svati");

        String name = names.stream()
                .filter(n -> n.contains("w"))
                .findFirst()
                .orElse("Not Found");

        System.out.println(name);


//        String name = null;
//
//        for(String n : names){
//            if(n.contains("w"))
//            {
//                name = n;
//                break;
//            }
//        }
//
//        System.out.println(name + " " + name.length());

    }
}
