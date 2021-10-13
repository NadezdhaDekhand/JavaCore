package HomeWork__1;

public class Track implements Doable {
    private int length;
    private int height;
    public Track(int length, int height ) {
        this.length = length;
        this. height = height;
    }

    public boolean doIt(Player player) {
        return player.run(length);
    }
    @Override
    public String toString() {
        return  "Полоса препятствий: длинна - " + length + "m , высота барьеров - " +  height + "m";
    }
}
