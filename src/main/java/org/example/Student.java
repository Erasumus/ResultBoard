package org.example;

import java.util.Objects;

class Student implements Comparable<Student>{
    String name;
    double avgScore;

    Student(String name, double avgScore){
        this.name = name;
        this.avgScore = avgScore;
    }

    @Override
    public int compareTo(Student other){
        return Double.compare(this.avgScore, other.avgScore);
    }

    @Override
    public String toString(){
        return name + " : " + avgScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.avgScore, avgScore) == 0 &&
                Objects.equals(name, student.name);
    }
}
