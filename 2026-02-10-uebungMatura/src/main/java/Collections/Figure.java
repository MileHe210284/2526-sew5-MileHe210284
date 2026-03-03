package Collections;

public abstract class Figure implements Fighter, Comparable<Figure> {
    protected String name;
    protected int healthPoints;
    public Figure(String name, int healthPoints){this.name=name; this.healthPoints=healthPoints;}
    public abstract void introduce();

}
