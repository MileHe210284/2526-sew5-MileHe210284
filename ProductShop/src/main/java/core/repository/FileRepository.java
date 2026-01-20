package core.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import core.Product;

import java.io.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class FileRepository extends InMemoryProductRepository implements FileConversion {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public void writeToFile() throws FileNotFoundException {

        PrintWriter delContents = new PrintWriter("C:/repos/2526-sew5-MileHe210284/ProductShop/src/main/resources/jsonFiles/products.json");
        delContents.print("");

        String json = gson.toJson(products);
        System.out.println(json);

        try (Writer writer = new FileWriter("C:/repos/2526-sew5-MileHe210284/ProductShop/src/main/resources/jsonFiles/products.json")) {
            gson.toJson(products, writer);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ConcurrentMap readFromFile() {

        try (Reader reader = new FileReader("C:/repos/2526-sew5-MileHe210284/ProductShop/src/main/resources/jsonFiles/products.json")) {

            // Convert JSON File to Java Object
            ConcurrentMap products = gson.fromJson(reader, ConcurrentHashMap.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}
