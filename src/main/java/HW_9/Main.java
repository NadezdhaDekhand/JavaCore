package HW_9;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        List<Course> courseList = library.getStudents().stream()
                .flatMap(student -> student.getCourses().stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Cписок уникальных курсов");
        System.out.println(courseList);

        Integer reduce = library.getStudents().stream()
                .map(student -> student.getCourses().size())
                .reduce(0, (max, size) -> size > max ? size : max);
        System.out.println("-----------------------------------------");
        System.out.println("Максимальное количество курсов: " + reduce);

        List<Student> students = library.getStudents().stream()
                .filter(student -> student.getCourses().size() > 1)
                .limit(3)
                .map(Student::getFio).map(Student::new)
                .collect(Collectors.toList());
        System.out.println("-----------------------------------------");
        System.out.println("Самые любознательные");
        System.out.println(students);

    }
}





