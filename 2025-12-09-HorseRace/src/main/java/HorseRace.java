import java.util.concurrent.*;
import java.util.*;

public class HorseRace {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //instanz von Horses und Scoreboards
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<HorseResult>> horseList = new ArrayList<>();
        Scoreboard score = new Scoreboard();


        for(int i =1; i<=10; i++){
            Horse horsie = new Horse(i);
            Future<HorseResult> submit = executor.submit(horsie);
            horseList.add(submit);
        }



      for(Future<HorseResult> f : horseList){
          HorseResult result = f.get();
          score.addResult(result);
      }
      executor.shutdown();
      score.result();

    }
}
