import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Each Department will have the following Data Structures to store relevant information for that specific Department
class University {
    // Constructor for University
    // All lists of same size, with indexes mapped to corresponding case
    public University(
        String departmentName, 
        List<String> courseList, 
        List<String> teacherList,
        List<String> teacherIDList,
        List<String> teacherEmailList,
        List<List<String>> studentList,
        List<List<String>> studentIDList,
        List<List<String>> studentEmailList, 
        List<List<String>> labList, 
        List<List<String>> quizList, 
        List<List<String>> examList,
        List<List<List<Integer>>> labGrades,
        List<List<List<Integer>>> quizGrades,
        List<List<List<Integer>>> examGrades
    ) {
        program.add(departmentName);
        courses.put(departmentName, courseList);

        for (int i = 0; i < courseList.size(); i++) {
            teacher.put(courseList.get(i), teacherList.get(i));
            students.put(courseList.get(i), studentList.get(i));
            assignLab.put(courseList.get(i), labList.get(i));
            assignQuiz.put(courseList.get(i), quizList.get(i));
            assignExam.put(courseList.get(i), examList.get(i));

            for (int j = 0; j < studentList.get(i).size(); j++) {
                List<String> identifier = Arrays.asList(
                    courseList.get(i), 
                    studentList.get(i).get(j), 
                    studentIDList.get(i).get(j)
                ); // {Course Name, Student Name, Student ID}

                List<String> studentID = Arrays.asList( 
                    studentIDList.get(i).get(j),
                    studentEmailList.get(i).get(j)
                ); // {Student ID, Student Email}

                studentDetails.put(studentList.get(i).get(j), studentID);

                labMark.put(identifier, labGrades.get(i).get(j));
                quizMark.put(identifier, quizGrades.get(i).get(j));
                examMark.put(identifier, examGrades.get(i).get(j));
            }
        }

        for (int i = 0; i < teacherList.size(); i++) {
            List<String> teacherID = Arrays.asList( 
                teacherIDList.get(i),
                teacherEmailList.get(i)
            ); // {Student ID, Student Email}

            teacherDetails.put(teacherList.get(i), teacherID);
        }
    }

    public Set<String> program = new HashSet<>();  // Set of Programs Offering different courses
    public HashMap<String, List<String>> courses = new HashMap<>(); // <Program, List of Courses Offered>
    public HashMap<String, String> teacher = new HashMap<>(); // <Course Name, Instructor for Course> 
    public HashMap<String, List<String>> students = new HashMap<>(); // <Course Name, List of Registered Students> 
    public HashMap<String, List<String>> assignLab = new HashMap<>(); // <Course Name, List of Lab Assignments for that Course>
    public HashMap<String, List<String>> assignQuiz = new HashMap<>(); // <Course Name, List of Quizzes for thet Course>
    public HashMap<String, List<String>> assignExam = new HashMap<>(); // <Course Name, List of Exams for that Course>
    public HashMap<String, List<String>> studentDetails = new HashMap<>(); // <Student Name, {ID, Email}>
    public HashMap<String, List<String>> teacherDetails = new HashMap<>(); // <Professor Name, {ID, Email}>
    public HashMap<List<String>, List<Integer>> labMark = new HashMap<>(); // <{Course Name, Student Name, Student ID}, {Lab Assignment Grades}>
    public HashMap<List<String>, List<Integer>> quizMark = new HashMap<>(); // <{Course Name, Student Name, Student ID}, {Quiz Grades}>
    public HashMap<List<String>, List<Integer>> examMark = new HashMap<>(); // // <{Course Name, Student Name, Student ID}, {Exam Grades}>
}