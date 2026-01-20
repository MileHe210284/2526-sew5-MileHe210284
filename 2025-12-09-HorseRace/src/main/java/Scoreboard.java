import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Scoreboard {

    List<HorseResult> placements = new ArrayList();

    public void addResult(HorseResult horseResult){
    placements.add(horseResult);
    }

    public void result(){
    placements.sort(Comparator.comparingLong(h -> h.time()));
    for(HorseResult h : placements){
        System.out.println("Horse name " +h.HorseName()+ " finished in the time: "+h.time());
        }
    }
}
