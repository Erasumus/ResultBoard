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
        int result = Double.compare(this.avgScore, other.avgScore);
        if (result == 0) {
            result = this.name.compareTo(other.name);
        }
        return result;
    }

    @Override
    public String toString(){
        return name + " : " + avgScore;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return false;
        if(o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.avgScore, avgScore) == 0 && Objects.equals(student.name, name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, avgScore);
    }
}
