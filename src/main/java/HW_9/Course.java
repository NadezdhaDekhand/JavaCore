package HW_9;

import java.util.Objects;

class Course {
    private String name;

    public Course(String name)   {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Course {" + "'" + name + '\'' +'}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Course course = (Course) o;
        return name.equals(course.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
