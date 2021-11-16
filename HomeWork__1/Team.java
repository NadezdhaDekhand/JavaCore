package HomeWork__1;

public class Team {

     String name;
     Player[] players;
     String result;

    public Team(String name, Player[] players) {
        this.name = name;
        this.players = players;
        result = "" ;
    }

    public void doIt(Doable obstacle) {
        result += obstacle.toString() + "\n";
        for (Player player : players)
            result += "-> " + player.name + " " + obstacle.doIt(player) + "\n";
    }

    public void showResults() {
        System.out.println(result);
    }
    public String toString() {
        return "Команда: " + name ;
    }
}
