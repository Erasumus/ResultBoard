package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class boardStudentTest {
    private boardStudent board;

    @BeforeEach
    void setUp(){
        board = new boardStudent();
    }

    @Test
    void testAddStudent(){
        board.addStudent("Alice", 5);
        assertEquals(1, board.students.size());

        Student addStudent = board.getAllStudents().get(0);
        Assertions.assertEquals("Alice", addStudent.name);
        Assertions.assertEquals(5.0, addStudent.avgScore);
    }

    @Test
    public void testGetAllStudents() {
        board.addStudent("Alice", 5.0);
        board.addStudent("Bob", 4.5);
        board.addStudent("Charlie", 4.8);

        List<Student> allStudents = board.getAllStudents();
        List<Student> expected = List.of(
                new Student("Bob", 4.5),
                new Student("Charlie", 4.8),
                new Student("Alice", 5.0)
        );
        assertEquals(expected, allStudents);
    }

    @Test
    void testGetTop3Students(){
        board.addStudent("Alice", 5.0);
        board.addStudent("Bob", 4.5);
        board.addStudent("Charlie", 4.8);
        board.addStudent("David", 3.9);
        board.addStudent("Eve", 4.7);

        List<String> top3name = board.getTop3Students();
        List<String> expectedName = List.of("Alice", "Charlie", "Eve");
        List<Double> expectedAvg = List.of(5.0, 4.8, 4.7);
        for(int i = 0; i<3; i++){
            assertEquals(top3name.get(i), expectedName.get(i));
            assertEquals(expectedAvg.get(i), expectedAvg.get(i), 0.001);
        }
    }
}
