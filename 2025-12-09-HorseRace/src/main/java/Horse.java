import java.util.Random;
import java.util.concurrent.Callable;

public class Horse implements Callable<HorseResult> {

    private int name;
    private long time;

    public Horse(int name){
        this.name=name;
    }

    @Override
    public HorseResult call() throws Exception {
        Random rn = new Random();
        time = rn.nextLong(500,1501);
        Thread.sleep(time);

        return new HorseResult(name, time);
    }

    public int getName(){
        return this.name;
    }
}
