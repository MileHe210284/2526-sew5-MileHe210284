import java.util.concurrent.RunnableScheduledFuture;

public class Task implements Runnable {
    private int index;
    private double value;

    public Task(int index){
      this.index = index;
    }

    public void setIndex(int index){
        this.index = index;
    }

    @Override
    public void run() {
        System.out.println("Thread "+ index+ " started");
        try{
            Thread.sleep(1000);
            value = Math.random();
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println("Thread "+ index+ " finished");

    }
}
