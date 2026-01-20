import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(3);

        //mit einem submit wird ein future überliefert
        Future<Double > future = service.submit(new CallableTask(0));
        List<Future<Double>> futureList = new ArrayList<>();

        for(int i =0; i <10; i++){
            //futureList hinzufügen
            futureList.add(service.submit(new CallableTask(0)));
        }
        service.shutdown();

        while(!futureList.isEmpty()){
            for(int i =0; i <10; i++){
                System.out.println("Task"+i +"finished");
                System.out.println("value "+ futureList.get(i).get());
                futureList.remove(i);
            }
            Thread.sleep(100);
        }

        //TODO start 10 Tasks
        //collect all the futures
        //print all results when all tasks are completed

        while(!future.isDone()){
            System.out.println("still not done....");
            Thread.sleep(100);
        }

        Double val = future.get();
        System.out.println("Calculated value: "+val);
    }
}
