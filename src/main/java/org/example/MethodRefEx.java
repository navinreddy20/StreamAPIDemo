package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// functional Programming
// first class citizen - function can be passed as argument,
// can be returned from a function, can be assigned to a variable
// Java 8 supports functional programming because it supports functional style

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student{
    private String name;
    private int marks;

}

public class MethodRefEx {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Navin", "Shweta", "Ashim", "Jo", "Swati");

        Student s = new Student();

        // list of students
        List<Student> students = Arrays.asList(
                new Student("Naveen", 80),
                new Student("Shweta", 90),
                new Student("Ashim", 70),
                new Student("John", 60),
                new Student("Swati", 85)
        );

        List<String> uNames = new ArrayList<>();

//        uNames = names.stream()
//                .map(name -> name.toUpperCase())     // stream of String
//                .toList();

        uNames = students.stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .toList();


//        for(String name : names)
//        {
//            uNames.add(name.toUpperCase());
//        }

        uNames.forEach(name -> System.out.println(name));

    }
}
