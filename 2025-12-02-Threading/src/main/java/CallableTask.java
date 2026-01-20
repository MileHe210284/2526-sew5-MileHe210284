import java.util.concurrent.Callable;

public class CallableTask implements Callable<Double> {
    private int index;
    private double value;

    public CallableTask(int index){
        this.index = index;
    }

    public void setIndex(int index){
        this.index = index;
    }


    @Override
    public Double call() throws Exception {
        System.out.println("Thread "+ index+ " started");
        try{
            Thread.sleep(1000);
            value = Math.random();
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println("Thread "+ index+ " finished");
        return value;
    }
}
