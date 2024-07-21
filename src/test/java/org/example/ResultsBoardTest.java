package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class ResultsBoardTest {
    private ResultsBoard board;

    @BeforeEach
    void setUp(){
        board = new ResultsBoard();
    }

    @Test
    void testAddStudent(){
        board.addStudent("Alice", 5);
        assertEquals(1, board.getAllStudents().size());

        Student addStudent = board.getAllStudents().get(0);
        Assertions.assertEquals("Alice", addStudent.name);
        Assertions.assertEquals(5.0, addStudent.avgScore);
    }

    @Test
    public void testGetAllStudents() {
        board.addStudent("Alice", 5.0);
        board.addStudent("Charlie", 4.8);
        board.addStudent("Bob", 4.5);

        List<Student> allStudents = board.getAllStudents();
        List<Student> expected = List.of(
                new Student("Alice", 5.0),
                new Student("Charlie", 4.8),
                new Student("Bob", 4.5)
        );
        assertEquals(expected, allStudents);
    }

    @Test
    void testTop3(){
        board.addStudent("Alice", 5.0);
        board.addStudent("Bob", 5.0);
        board.addStudent("Charlie", 5.0);
        board.addStudent("David", 3.9);
        board.addStudent("Eve", 4.7);

        List<String> top3 = board.top3();
        List<String> expected = List.of("Alice", "Bob", "Charlie");
        assertEquals(expected, top3);
    }
}
