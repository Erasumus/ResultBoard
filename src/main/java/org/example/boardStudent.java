package org.example;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class boardStudent {
    TreeSet<Student> students = new TreeSet<>();

    void addStudent(String name, double avgScore){
        Student student = new Student(name, avgScore);
        students.add(student);
    }

    List<String> getTop3Students(){
        List<String> top3Students = new ArrayList<>();
        Iterator<Student> iterator = students.descendingIterator();
        for(int i = 0; i<3 && iterator.hasNext(); i++){
            top3Students.add(iterator.next().name);
        }
        return top3Students;
    }

    List<Student> getAllStudents(){
        return new ArrayList<>(students);
    }

    public static void main(String[] args){
       boardStudent listStudents = new boardStudent();
        listStudents.addStudent("Alice", 5.0);
        listStudents.addStudent("Bob", 4.5);
        listStudents.addStudent("Charlie", 4.8);
        listStudents.addStudent("David", 3.9);
        listStudents.addStudent("Eve", 4.7);

        System.out.println(listStudents.getTop3Students());
    }
}





