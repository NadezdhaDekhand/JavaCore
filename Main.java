package HomeWork__1;

public class Main {
    public static void main(String[] args) {
        Course cource = new Course(new Doable[]{
                new Track(500, 1),});

        Team team = new Team("***WoW***", new Player[] {
                new Player("Иван", 499, 0.9),
                new Player("Сергей", 505, 1),
                new Player("Ольга", 405, 1.08),
                new Player("Таня",500, 1.1) {
                }});


        System.out.println(team);
        cource.doIt(team);
       
        team.showResults();
    }
}
