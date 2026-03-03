package Collections;

import java.util.*;

public class TestDriver {
    public static void main(String[] args) {
        Knights arthur = new Knights("arthur", 20,9);
        Knights lanzelot = new Knights("Lanzelot",10,5);
        Nerds nerd1 = new Nerds("Nerd1", 6);
        Nerds nerd2 = new Nerds("Nerd2", 7);

        System.out.println("-------List-------");
        //list example
        java.util.List<Figure> figureList = new ArrayList<>();
        figureList.add(arthur);
        figureList.add(lanzelot);
        figureList.add(nerd1);
        figureList.add(nerd2);

        for(Figure f : figureList){

            if(f instanceof Fighter){
                Fighter fighter = (Fighter) f; //nicht mehr nötig
                fighter.fight(3);

            }
        }

        //queue example
        System.out.println("------Queue------");
        Queue<Figure> figureQueue = new PriorityQueue<>();
        figureQueue.add(nerd1);
        figureQueue.add(nerd2);
        figureQueue.add(lanzelot);
        figureQueue.add(arthur);

        while(!figureQueue.isEmpty()){
            Figure f = figureQueue.poll();
            f.introduce();
        }

        // set example
        System.out.println("----------SET-------");
        Set<Figure> figureSet = new HashSet<>();
        figureSet.add(arthur);
        figureSet.add(lanzelot);
        figureSet.add(nerd1);
        figureSet.add(nerd2);
        figureSet.add(arthur); //set erlaubt keine duplikate
        figureSet.add ( new Knights("arthur",5,9));

        //List<Figure> list=figureSet.stream().toList();
        for(Figure f : figureSet){
            f.introduce();
        }

        //Map example
        System.out.println("--------Map--------");
        Map<String,List<Figure>> map = new HashMap<>();

        map.put("KingArthur",figureList);
        addFigureToMap(map, "Scrappies", new Knights("Schrott", 1,1));
        addFigureToMap(map, "Scrappies", new Nerds("SchrotNerd", 1));

        //TODO ausgabe map

    }

    public static void addFigureToMap(Map<String, List<Figure>>m, String key, Figure value) {

        //wenn key noch nicht in map. liste erzeugen mit value und eingeben.
        if(!m.containsKey(key)){
            List<Figure> list = new ArrayList<>();
            list.add(value);
            m.put(key,list );
            return;
        }
        //key gibt es --> liste holen und value dazu geben
        else{
            //liste muss man nicht zurückgeben weil die referenz hergegeben wird wenn man die liste holt
            List<Figure> list = m.get(key);
            list.add(value);

        }

    }
}
