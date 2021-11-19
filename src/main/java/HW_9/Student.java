package HW_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Student {
    private String fio; //ФИО
    private List<Course> courses; //взятые книги

    public List<Course> getCourses() {
        return courses;
    }

    public Student(String fio) {
        this.fio = fio;
        this.courses = new ArrayList<>();
    }

    public String getFio() {
        return fio;
    }

    @Override
    public String toString() {
        return "Student {" + "'" + fio + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return fio.equals(student.fio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio);
    }
}


