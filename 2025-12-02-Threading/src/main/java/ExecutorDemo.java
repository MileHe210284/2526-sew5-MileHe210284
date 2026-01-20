import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ExecutorDemo {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(3);


        for(int i =0; i<10; i++){
            final int j=i;
            service.execute(()->{
                System.out.println("Thread "+ j+ " started");
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
                System.out.println("Thread "+ j+ " finished");
            });
        }


        for(int i =0; i<10; i++){
            service.execute(new Task(i));
        }
        service.shutdown();

    }
}