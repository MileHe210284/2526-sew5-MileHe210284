package Collections;

import java.util.Objects;

public class Knights extends Figure{
    private int strength;

    public Knights(String name, int healthPoints, int strength) {
        super(name, healthPoints);
        this.strength=strength;
    }

    @Override
    public void introduce() {
        System.out.println("I am "+ this.name+ " with strength "+ this.strength);
    }

    @Override
    public void fight(int strength) {
        System.out.println(this.name+ " fights with strength "+ this.strength);
    }

    @Override
    public int compareTo(Figure o) {
        if(o.getClass() == Knights.class){
            return Integer.compare( ((Knights) o).strength,this.strength);
        }
        return -1;
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Knights knight)) return false;
        Knights k = (Knights) o;
        return strength == k.strength && name.equals(k.name) && healthPoints == k.healthPoints;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(strength);
    }
}
