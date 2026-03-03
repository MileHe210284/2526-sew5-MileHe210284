package Collections;

public class Nerds extends Figure{

    public Nerds(String name, int healthPoints) {
        super(name, healthPoints);
    }

    @Override
    public void introduce() {
        System.out.println("I am nerd "+name);
    }

    @Override
    public void fight(int strength) {
        System.out.println("I am nerd "+name);
    }

    @Override
    public int compareTo(Figure o) {
        if(o.getClass() == Nerds.class){
            return Integer.compare(this.healthPoints, o.healthPoints);
        }
        return 1;
    }
}
