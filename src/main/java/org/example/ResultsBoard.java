package org.example;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ResultsBoard {
    List<Student> students;

    public ResultsBoard() {
        students = new ArrayList<>();
    }

    void addStudent(String name, double avgScore){
        Student student = new Student(name, avgScore);
        students.add(student);
    }

    List<String> top3(){
        students.sort(Comparator.comparingDouble((Student s) -> s.avgScore).reversed().thenComparing(s -> students.indexOf(s)));
        List<String> top3Students = new ArrayList<>();
        for (int i = 0; i < 3 && i < students.size(); i++) {
            top3Students.add(students.get(i).name);
        }
        return top3Students;
    }

    List<Student> getAllStudents(){
        return new ArrayList<>(students);
    }

    public static void main(String[] args){
       ResultsBoard listStudents = new ResultsBoard();
        listStudents.addStudent("Alice", 5.0);
        listStudents.addStudent("Bob", 5.0);
        listStudents.addStudent("Charlie", 5.0);
        listStudents.addStudent("David", 3.9);
        listStudents.addStudent("Eve", 4.7);

        System.out.println(listStudents.top3());
    }
}





