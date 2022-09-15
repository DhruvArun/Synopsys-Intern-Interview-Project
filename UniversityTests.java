import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UniversityTests {
    String department = "APSC";
    University APSC = new University(
            department,
            Arrays.asList("APSC 101", "APSC 102"),
            Arrays.asList("Dr. Jon", "Dr. Alice"),
            Arrays.asList("t1", "t2"),
            Arrays.asList("jon@apsc.com", "alice@apsc.com"),
            Arrays.asList(Arrays.asList("Dhruv", "Anna"), Arrays.asList("James", "John")),
            Arrays.asList(Arrays.asList("s1", "s2"), Arrays.asList("s3", "s4")),
            Arrays.asList(Arrays.asList("dhruv@gmail.com", "anna@gmail.com"), Arrays.asList("james@gmail.com", "john@gmail.com")),
            Arrays.asList(Arrays.asList("APSC 101 - Lab 1", "APSC 101 - Lab 2"), Arrays.asList("APSC 102 - Lab 1", "APSC 102 - Lab 2")),
            Arrays.asList(Arrays.asList("APSC 101 - Quiz 1", "APSC 101 - Quiz 2"), Arrays.asList("APSC 102 - Quiz 1", "APSC 102 - Quiz 2")),
            Arrays.asList(Arrays.asList("APSC 101 - Exam 1"), Arrays.asList("APSC 102 - Exam 1")),
            Arrays.asList(Arrays.asList(Arrays.asList(-1, -1), Arrays.asList(-1, -1)), Arrays.asList(Arrays.asList(-1, -1), Arrays.asList(-1, -1))),
            Arrays.asList(Arrays.asList(Arrays.asList(-1, -1), Arrays.asList(-1, -1)), Arrays.asList(Arrays.asList(-1, -1), Arrays.asList(-1, -1))),
            Arrays.asList(Arrays.asList(Arrays.asList(-1), Arrays.asList(-1)), Arrays.asList(Arrays.asList(-1), Arrays.asList(-1)))
    );

    @Test
    public void testMarks() {
        List<Integer> result1 = APSC.labMark.get(Arrays.asList("APSC 101", "Dhruv", "s1"));
        List<Integer> expResult1 = Arrays.asList(-1, -1);

        List<Integer> result2 = APSC.quizMark.get(Arrays.asList("APSC 101", "Dhruv", "s1"));
        List<Integer> expResult2 = Arrays.asList(-1, -1);

        List<Integer> result3 = APSC.examMark.get(Arrays.asList("APSC 101", "Dhruv", "s1"));
        List<Integer> expResult3 = Arrays.asList(-1);

        Assert.assertArrayEquals(expResult1.toArray(), result1.toArray());
        Assert.assertArrayEquals(expResult2.toArray(), result2.toArray());
        Assert.assertArrayEquals(expResult3.toArray(), result3.toArray());
    }

    @Test
    public void testStudentDetails() {
        HashMap<String, List<String>> result = APSC.studentDetails;
        HashMap<String, List<String>> expResult = new HashMap<>();
        expResult.put("Dhruv", Arrays.asList("s1", "dhruv@gmail.com"));
        expResult.put("Anna", Arrays.asList("s2", "anna@gmail.com"));
        expResult.put("James", Arrays.asList("s3", "james@gmail.com"));
        expResult.put("John", Arrays.asList("s4", "john@gmail.com"));

        Assert.assertEquals(expResult, result);
    }

    @Test
    public void testTeacherDetails() {
        HashMap<String, List<String>> result = APSC.teacherDetails;
        HashMap<String, List<String>> expResult = new HashMap<>();
        expResult.put("Dr. Jon", Arrays.asList("t1", "jon@apsc.com"));
        expResult.put("Dr. Alice", Arrays.asList("t2", "alice@apsc.com"));

        Assert.assertEquals(expResult, result);
    }

    @Test
    public void testCourses() {
        List<String> result = APSC.courses.get(department);
        List<String> expResult = Arrays.asList("APSC 101", "APSC 102");

        Assert.assertArrayEquals(expResult.toArray(), result.toArray());
    }

    @Test
    public void testStudents() {
        List<String> result1 = APSC.students.get("APSC 101");
        List<String> expResult1 = Arrays.asList("Dhruv", "Anna");

        List<String> result2 = APSC.students.get("APSC 102");
        List<String> expResult2 = Arrays.asList("James", "John");

        Assert.assertArrayEquals(expResult1.toArray(), result1.toArray());
        Assert.assertArrayEquals(expResult2.toArray(), result2.toArray());
    }

    @Test
    public void testTeachers() {
        String result1 = APSC.teacher.get("APSC 101");
        String expResult1 = "Dr. Jon";

        String result2 = APSC.teacher.get("APSC 102");
        String expResult2 = "Dr. Alice";

        Assert.assertEquals(expResult1, result1);
        Assert.assertEquals(expResult2, result2);
    }
}