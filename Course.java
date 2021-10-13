package HomeWork__1;

public class Course {
    Doable[] obstacles;

    public Course(Doable[] obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        for (Doable obstacle : obstacles)
            team.doIt(obstacle);
    }


}


