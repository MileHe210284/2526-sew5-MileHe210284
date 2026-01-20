package core;

import core.builder.SimpleProduct;
import core.repository.FileRepository;
import core.repository.InMemoryProductRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Predicate;

public class TestDriver {
    public static void main(String[] args) throws FileNotFoundException {

        Predicate<Product> startWithB = prod -> prod.name().startsWith("b");

        Product p = SimpleProduct.builder().name("bike").price(Money.of("150","EUR")).prop("1","blue").build();
        Product p1 = SimpleProduct.builder().name("fork").price(Money.of("5","EUR")).prop("2","yellow").build();
        Product p2 = SimpleProduct.builder().name("car").price(Money.of("15000","EUR")).prop("3","pink").build();

        System.out.println("printing: "+p.name()+" id: "+p.id()+" price: "+p.basePrice());

        InMemoryProductRepository mem = new InMemoryProductRepository();
        mem.save(p);
        mem.save(p1);
        mem.save(p2);

        for(Product px : mem.findAll()){
            System.out.println(px);
            System.out.println(px.name());
            System.out.println(px.id());
        }

        System.out.println("predicate");

        for(Product px : mem.search(startWithB)){
            System.out.println(px);
            System.out.println(px.name());
            System.out.println(px.id());
        }

        // write json file
        FileRepository jsonFile = new FileRepository();

        jsonFile.save(p);
        jsonFile.save(p1);
        jsonFile.save(p2);

        jsonFile.writeToFile();


        //read from json file
        jsonFile.readFromFile();
        ConcurrentMap readProducts = jsonFile.readFromFile();

    }
}
