package HW_9;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Course> courses;
    private List<Student> students;

    public Library() {
        init();
    }

    private void init() {
        courses = new ArrayList<>();
        courses.add(new Course("Java"));
        courses.add(new Course("JS"));
        courses.add(new Course("Python"));

        students = new ArrayList<>();
        students.add(new Student("Иванов"));
        students.add(new Student("Петpов"));
        students.add(new Student("Сидоров"));
        students.add(new Student("Попов"));

        students.get(3).getCourses().add(courses.get(0));
        students.get(3).getCourses().add(courses.get(2));
        students.get(0).getCourses().add(courses.get(1));
        students.get(1).getCourses().add(courses.get(0));
        students.get(1).getCourses().add(courses.get(1));
        students.get(1).getCourses().add(courses.get(2));
        students.get(2).getCourses().add(courses.get(1));
        students.get(2).getCourses().add(courses.get(0));
        students.get(3).getCourses().add(courses.get(1));
    }
    public List<Course> getCourses() {
        return courses;
    }

    public List<Student> getStudents() {
        return students;
    }
}
